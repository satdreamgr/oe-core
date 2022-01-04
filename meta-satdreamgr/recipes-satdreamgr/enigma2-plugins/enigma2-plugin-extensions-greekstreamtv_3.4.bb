DESCRIPTION = "GreekStreamTV"
SUMMARY = "Watch live stream TV from Greece"
SECTION = "multimedia"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "http://satdreamgr.com"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://setup.py;md5=6343fbab37d88d4ad588416c903cad95"

RDEPENDS_${PN} = "\
	python-lxml \
	python-requests \
	rtmpdump \
	streamlink \
	"

S="${WORKDIR}/git"

SRC_URI = " \
	git://github.com/athoik/GreekStreamTV;protocol=https \
	"

inherit distutils-openplugins gitpkgv
SRCREV = "${AUTOREV}"
PV = "3.4+git${SRCPV}"
PKGV = "3.4+git${GITPKGV}"
PR = "r1"

do_install_append() {
	chmod 755 ${D}${libdir}/enigma2/python/Plugins/Extensions/GreekStreamTV/*.sh
}

#PACKAGES =+ "${PN}-src"

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/GreekStreamTV/*"
FILES_${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/GreekStreamTV/*.py \
	${libdir}/enigma2/python/Plugins/enigma2_plugin_extensions_greekstreamtv-3.2-py2.7.egg-info \
	${libdir}/python2.7/* \
	"

