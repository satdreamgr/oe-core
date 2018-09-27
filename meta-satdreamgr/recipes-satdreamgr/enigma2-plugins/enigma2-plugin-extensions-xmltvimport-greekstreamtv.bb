DESCRIPTION = "Satdreamgr GreekStreamTV EPG Sources"
HOMEPAGE = "http://www.satdreamgr.com"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=eb723b61539feef013de476e68b5c50a"

inherit allarch

PV = "1.2"
PACKAGES = "${PN}"
RDEPENDS_${PN} = "enigma2-plugin-extensions-epgimport livestreamersrv"

do_compile() {
	[ ! -d ${S}/${sysconfdir}/epgimport ] && mkdir -p ${S}/${sysconfdir}/epgimport
	echo '<?xml version="1.0" encoding="latin-1"?>' > ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml
	#echo '<sources>' >> ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml
	echo '<sourcecat sourcename="EPG GR (greekstreamtv)">' >> ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml
	echo '<source type="gen_xmltv" nocheck="1" channels="http://sgcpm.com/epg/stream.channels.xml.gz">' >> ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml
	echo '   <description>EPG GR (greekstreamtv)</description>' >> ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml
	echo '   <url>http://sgcpm.com/epg/greekstreamtvepg.gz</url>' >> ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml
	echo '</source>' >> ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml
	echo '</sourcecat>' >> ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml
	#echo '</sources>' >> ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml
}

do_install () {
	install -d ${D}${sysconfdir}/epgimport
	install -m 0644 ${S}/${sysconfdir}/epgimport/greekstreamtv.sources.xml ${D}${sysconfdir}/epgimport/greekstreamtv.sources.xml
}

