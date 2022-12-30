SUMMARY = "Multi boot loader for enigma2"
MAINTAINER = "oe-alliance"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit gitpkgv

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r32"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "freetype"

SRC_URI = "git://github.com/oe-alliance/openmultiboot.git;protocol=https;branch=main"

inherit autotools-brokensep pkgconfig

S = "${WORKDIR}/git"

MTD_KERNEL ?= "mtd1"
MTD_KERNEL_vuduo2 = "mtd2"
MTD_KERNEL_vusolo2 = "mtd2"
MTD_KERNEL_vusolose = "mtd2"
MTD_KERNEL_vuzero = "mtd2"

MTD_KERNEL_dm800 = "mtd2"
MTD_KERNEL_dm500hd = "mtd2"
MTD_KERNEL_dm500hdv2 = "mtd2"
MTD_KERNEL_dm800se = "mtd2"
MTD_KERNEL_dm800sev2 = "mtd2"
MTD_KERNEL_dm7020hd = "mtd2"
MTD_KERNEL_dm8000 = "mtd2"

MTD_KERNEL_osmini = "mtd0"
MTD_KERNEL_osminiplus = "mtd0"
MTD_KERNEL_osmega = "mtd0"
MTD_KERNEL_osnino = "mtd2"
MTD_KERNEL_osninoplus = "mtd2"
MTD_KERNEL_osninopro = "mtd2"

EXTRA_OEMAKE = " \
    'CFLAGS=${CFLAGS} \
    -I=${includedir}/freetype2 \
    ${@bb.utils.contains("MACHINE_FEATURES", "textlcd", "-DOMB_HAVE_TEXTLCD" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "singlecore", "-DOMB_DEFAULT_TIMER=10" , "-DOMB_DEFAULT_TIMER=10", d)} \
    ${@bb.utils.contains("IMAGE_FSTYPES", "ubi", "-DOMB_FLASH_UBI" , "", d)} \
    ${@bb.utils.contains("IMAGE_FSTYPES", "jffs2", "-DOMB_FLASH_JFFS2" , "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "dreambox", "-DOMB_DREAMBOX", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "mmc", "-DOMB_MMCBLK", "", d)} \
    -DOMB_MENU_ITEM_COLOR=0xE6000000 \
    -DOMB_KERNEL_MTD=\"/dev/${MTD_KERNEL}\"' \
    'LDFLAGS= -lfreetype ${LDFLAGS}' \
    "

do_install() {
    install -d ${D}${base_sbindir}
    install -m 755 ${S}/src/open_multiboot ${D}${base_sbindir}
    install -m 644 ${S}/contrib/open-multiboot-branding-helper.py ${D}${base_sbindir}

    # install omb folder
    install -d ${D}/omb
    touch ${D}/omb/.dummy
}

FILES_${PN} += "/omb"

pkg_preinst_${PN}() {
#!/bin/sh
if mountpoint -q ${libdir}/enigma2/python/Plugins/Extensions/OpenMultiboot; then
    echo "openMultiBoot will only install on main image."
    echo "Child image is running - canceling installation!"
    sleep 3
    exit 1
else
    echo "Main image is running - proceeding installation..."
    exit 0
fi
}

pkg_postinst_${PN}() {
rm /sbin/init
ln -s /sbin/open_multiboot /sbin/init
}

pkg_postrm_${PN}() {
rm /sbin/init
ln -s /sbin/init.sysvinit /sbin/init
}
