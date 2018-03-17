DESCRIPTION = "Satdreamgr HD TransBA skin"
MAINTAINER = "SatDreamGR"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://README.md;md5=9befd2c8b72c31c1f2506e19fbfd03e0"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/satdreamgr/Satdreamgr-HD-TranspBA.git;protocol=git"
SRCREV = "${AUTOREV}"

FILES_${PN} = "/usr/share/enigma2/ /usr/lib/enigma2/"

S = "${WORKDIR}/git"

do_compile() {
}

do_install() {
	install -d ${D}/usr/share
	cp -r --preserve=mode,links ${S}/usr/share/* ${D}/usr/share/
	chmod -R a+rX ${D}/usr/share/enigma2/

        install -d ${D}/usr/lib
        cp -r --preserve=mode,links ${S}/usr/lib/* ${D}/usr/lib/
        chmod -R a+rX ${D}/usr/lib/enigma2/
}

pkg_postinst_${PN}_append () {
        if [ -z "$D" ]
        then
		cd /usr/share/enigma2/Satdreamgr-HD-TranspBA
		if [ ! -L infobar.xml ]
		then
			ln -s infobar_a.xml infobar.xml
		fi
        fi
}
