DESCRIPTION = "Satdreamgr Panel"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "http://satdreamgr.com"
SECTION = "base"
LICENSE = "PD"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=eb723b61539feef013de476e68b5c50a"

inherit gitpkgv allarch

PV = "1.1+git${SRCPV}"
PKGV = "1.1+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/satdreamgr/Panel.git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

FILES_${PN} = "${libdir}"

#PACKAGES =+ "${PN}-src"

FILES_${PN}-src = "\
    ${libdir}/enigma2/python/Components/Converter/*.py \
    ${libdir}/enigma2/python/Plugins/Satdreamgr/*.py \
    ${libdir}/enigma2/python/Plugins/Satdreamgr/*/*.py \
    "

do_install() {
   install -d ${D}${libdir}
   cp -r --preserve=mode,links ${S}/usr/lib/enigma2 ${D}${libdir}/
   python -O -m compileall -d ${libdir}/enigma2/python/ ${D}${libdir}/enigma2/python/
}

