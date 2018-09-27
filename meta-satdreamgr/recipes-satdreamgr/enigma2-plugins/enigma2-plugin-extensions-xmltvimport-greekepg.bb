DESCRIPTION = "Greek EPG Sources"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=eb723b61539feef013de476e68b5c50a"

inherit allarch

PV = "1.5"
PACKAGES = "${PN}"
RDEPENDS_${PN} = "enigma2-plugin-extensions-epgimport"

do_compile() {
	[ ! -d ${S}/${sysconfdir}/epgimport ] && mkdir -p ${S}/${sysconfdir}/epgimport
	echo '<?xml version="1.0" encoding="latin-1"?>' > ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
	#echo '<sources>' >> ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
	echo '<sourcecat sourcecatname="EPG GR (greekepg)">' >> ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
	echo '<source type="gen_xmltv" nocheck="1" channels="http://sgcpm.com/epg/greekepg.channels.xml.gz">' >> ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
	echo '   <description>EPG GR (greekepg)</description>' >> ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
	echo '   <url>http://www.xmltvepg.nl/rytecGR_Basic.xz</url>' >> ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
	echo '   <url>http://www.vuplus-community.net/rytec/rytecGR_Basic.xz</url>' >> ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
	echo '</source>' >> ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
	#echo '</sources>' >> ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
	echo '</sourcecat>' >> ${S}/${sysconfdir}/epgimport/greekepg.sources.xml
}

do_install () {
	install -d ${D}${sysconfdir}/epgimport
	install -m 0644 ${S}/${sysconfdir}/epgimport/greekepg.sources.xml ${D}${sysconfdir}/epgimport/greekepg.sources.xml
}

