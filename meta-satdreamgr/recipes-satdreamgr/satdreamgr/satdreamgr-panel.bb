DESCRIPTION = "Satdreamgr Panel"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "http://satdreamgr.com"
SECTION = "base"
LICENSE = "PD"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=eb723b61539feef013de476e68b5c50a"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/satdreamgr/Panel.git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr/*"

PACKAGES =+ "${PN}-src"

FILES_${PN}-src = "\
	/usr/lib/enigma2/python/Components/Converter/*.py \
	/usr/lib/enigma2/python/Plugins/Satdreamgr/*.py \
	/usr/lib/enigma2/python/Plugins/Satdreamgr/*/*.py \
        "

do_install() {
   cp -r --preserve=mode,links ${S}/usr ${D}/
   python -O -m compileall -d /usr/lib/enigma2/python/ ${D}/usr/lib/enigma2/python/
}

