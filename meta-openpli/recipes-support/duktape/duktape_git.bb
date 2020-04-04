DESCRIPTION = "Duktape is an embeddable Javascript engine, with a focus on portability and compact footprint."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=c83446610de1f63c7ca60cfcc82dec9d"

SRC_URI = "git://github.com/svaarala/duktape.git;protocol=http file://duke2i.patch"
SRCREV = "6001888049cb42656f8649db020e804bcdeca6a7"
S = "${WORKDIR}/git"

DEPENDS += "python-pyyaml-native"

TARGET_CC_ARCH += "${LDFLAGS}"

inherit gitpkgv pythonnative
PV = "2.5.0+git${SRCPV}"
PKGV = "2.5.0+git${GITPKGV}"
PR = "r0"

do_compile() {
	oe_runmake -f Makefile duk
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/duk ${D}${bindir}/duk
}

FILES_${PN} = "${bindir}"
