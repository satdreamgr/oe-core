DESCRIPTION = "Satdreamgr HD skin based on PLiHD"
MAINTAINER = "SatDreamGR"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://usr/share/enigma2/Satdreamgr-HD/skin.xml;beginline=3;endline=8;md5=6b4e3aae7e4fd2322e3593c10257bdd5"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/satdreamgr/Satdreamgr-HD.git;protocol=git"
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
