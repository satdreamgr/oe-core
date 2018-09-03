DESCRIPTION = "device manager for managing storage devices"
MAINTAINER = "Xtrend United <info@xtrend-home.de>"
SECTION = "base"
HOMEPAGE = "www.xtrend-home.de"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=eb723b61539feef013de476e68b5c50a"

RDEPENDS_${PN} = "e2fsprogs-e2fsck e2fsprogs-mke2fs ntfsprogs hddtemp util-linux-sfdisk"

PR = "r2"

inherit allarch
INHIBIT_PACKAGE_DEBUG_SPLIT = '1'
INHIBIT_PACKAGE_STRIP = '1'

SRC_URI = "file://devicemanager-${PV}.tar"

FILES_${PN} = "/usr/*"

S = "${WORKDIR}/"

do_compile() {
}

do_install() {
	install -d ${D}/usr
	cp -r --preserve=mode,links ${S}/usr ${D}/
}
