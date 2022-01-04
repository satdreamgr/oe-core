DESCRIPTION = "Satdreamgr HD TransBA skin"
MAINTAINER = "SatDreamGR"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://README.md;md5=9befd2c8b72c31c1f2506e19fbfd03e0"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r1"

SRC_URI = "git://github.com/satdreamgr/Satdreamgr-HD-TranspBA.git;protocol=https"
SRCREV = "${AUTOREV}"

FILES_${PN} = "${datadir}/enigma2/ ${libdir}/enigma2/"

S = "${WORKDIR}/git"

do_compile() {
}

do_install() {
	install -d ${D}${datadir}
	cp -r --preserve=mode,links ${S}/usr/share/* ${D}${datadir}
	chmod -R a+rX ${D}${datadir}/enigma2/

        install -d ${D}${libdir}
        cp -r --preserve=mode,links ${S}/usr/lib/* ${D}${libdir}
        chmod -R a+rX ${D}${libdir}/enigma2/
}

