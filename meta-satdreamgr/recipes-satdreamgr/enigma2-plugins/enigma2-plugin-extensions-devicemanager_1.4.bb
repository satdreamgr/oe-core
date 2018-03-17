DESCRIPTION = "device manager for managing storage devices"
MAINTAINER = "Xtrend United <info@xtrend-home.de>"
SECTION = "base"
HOMEPAGE = "www.xtrend-home.de"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=eb723b61539feef013de476e68b5c50a"

# libblkid1
RDEPENDS_${PN} = "e2fsprogs-e2fsck e2fsprogs-mke2fs ntfsprogs"
RDEPENDS_${PN} += "hddtemp util-linux-sfdisk"

PR = "r1"

inherit allarch

SRC_URI = "file://devicemanager-${PV}.tar"

FILES_${PN} = "/usr/*"

S = "${WORKDIR}/"

do_compile() {
}

do_install() {
	install -d ${D}/usr
	cp -r --preserve=mode,links ${S}/usr ${D}/
}
