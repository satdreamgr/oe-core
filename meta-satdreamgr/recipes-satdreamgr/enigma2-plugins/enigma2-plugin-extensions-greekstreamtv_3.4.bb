DESCRIPTION = "GreekStreamTV"
SUMMARY = "Watch live stream TV from Greece"
SECTION = "multimedia"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "http://satdreamgr.com"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://setup.py;md5=6343fbab37d88d4ad588416c903cad95"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-lxml \
	${PYTHON_PN}-requests \
	rtmpdump \
	streamlink \
	"

S="${WORKDIR}/git"

SRC_URI = "git://github.com/athoik/GreekStreamTV;protocol=https"

inherit distutils-openplugins gitpkgv
SRCREV = "${AUTOREV}"
PV = "3.4+git${SRCPV}"
PKGV = "3.4+git${GITPKGV}"

do_install_append() {
	chmod 755 ${D}${libdir}/enigma2/python/Plugins/Extensions/GreekStreamTV/*.sh
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/GreekStreamTV/*"
