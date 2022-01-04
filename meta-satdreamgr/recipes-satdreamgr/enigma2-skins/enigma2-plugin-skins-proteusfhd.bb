DESCRIPTION = "Proteus FHD skin"
MAINTAINER = "nautilus7"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/nautilus7/skin-ProteusFHD.git;protocol=https"
SRCREV = "${AUTOREV}"

FILES_${PN} = "${datadir}/enigma2/ ${libdir}/enigma2/"

S = "${WORKDIR}/git"

do_compile() {
}

do_install() {
	install -d ${D}${datadir}
	cp -r --preserve=mode,links ${S}/usr/share/* ${D}${datadir}
	chmod -R a+rX ${D}${datadir}/enigma2/
}
