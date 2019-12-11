DESCRIPTION = "Device manager for storage devices (format/change partitions and type/fast & fixed mount and umount)"
HOMEPAGE = "https://github.com/Dima73/enigma2-plugin-systemplugins-devicemanager"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README.md;md5=fa931694f4579578b39587f7ca837042"

SRC_URI = "git://github.com/satdreamgr/enigma2-plugin-systemplugins-devicemanager.git"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

RRECOMMENDS_${PN} = "dosfstools e2fsprogs e2fsprogs-e2fsck e2fsprogs-mke2fs exfat-utils fuse-exfat hddtemp ntfsprogs util-linux-sfdisk"

inherit gitpkgv

PV = "2+git${SRCPV}"
PKGV = "2+git${GITPKGV}"

inherit distutils-openplugins
