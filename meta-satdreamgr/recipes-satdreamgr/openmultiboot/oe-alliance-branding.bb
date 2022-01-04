DESCRIPTION = "OE-A Branding Lib for OE-A 2.0"
MAINTAINER = "oe-alliance team"
PACKAGE_ARCH = "${MACHINE}"

DEPENDS = "python"

require conf/license/openpli-gplv2.inc

inherit autotools-brokensep gitpkgv pythonnative

#PACKAGES += " ${PN}-src"

SRCREV = "${AUTOREV}"
PV = "2.3+git${SRCPV}"
PKGV = "2.3+git${GITPKGV}"
PR = "r17"

SRC_URI="git://github.com/oe-alliance/branding-module.git;protocol=https"

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

ROOTFS_FILE ?= "rootfs.bin"
ROOTFS_FILE_vuduo = "root_cfe_auto.jffs2"
ROOTFS_FILE_vuduo2 = "root_cfe_auto.bin"
ROOTFS_FILE_vusolo = "root_cfe_auto.jffs2"
ROOTFS_FILE_vusolo2 = "root_cfe_auto.bin"
ROOTFS_FILE_vusolose = "root_cfe_auto.bin"
ROOTFS_FILE_vuultimo = "root_cfe_auto.jffs2"
ROOTFS_FILE_vuuno = "root_cfe_auto.jffs2"
ROOTFS_FILE_vuzero = "root_cfe_auto.bin"

ROOTFS_FILE_vusolo4k = "rootfs.tar.bz2"
ROOTFS_FILE_vuultimo4k = "rootfs.tar.bz2"
ROOTFS_FILE_vuuno4k = "rootfs.tar.bz2"
ROOTFS_FILE_vuuno4kse = "rootfs.tar.bz2"
ROOTFS_FILE_vuzero4k = "rootfs.tar.bz2"

KERNEL_FILE ?= "kernel.bin"
KERNEL_FILE_vuduo = "kernel_cfe_auto.bin"
KERNEL_FILE_vuduo2 = "kernel_cfe_auto.bin"
KERNEL_FILE_vusolo = "kernel_cfe_auto.bin"
KERNEL_FILE_vusolo2 = "kernel_cfe_auto.bin"
KERNEL_FILE_vusolose = "kernel_cfe_auto.bin"
KERNEL_FILE_vuultimo = "kernel_cfe_auto.bin"
KERNEL_FILE_vuuno = "kernel_cfe_auto.bin"
KERNEL_FILE_vuzero = "kernel_cfe_auto.bin"

IMAGEDIR_vuduo = "vuplus/duo"
IMAGEDIR_vuduo2 = "vuplus/duo2"
IMAGEDIR_vusolo = "vuplus/solo"
IMAGEDIR_vusolo2 = "vuplus/solo2"
IMAGEDIR_vusolose = "vuplus/solose"
IMAGEDIR_vuultimo = "vuplus/ultimo"
IMAGEDIR_vuuno = "vuplus/uno"
IMAGEDIR_vuzero = "vuplus/zero"

IMAGEDIR_vusolo4k = "vuplus/solo4k"
IMAGEDIR_vuultimo4k = "vuplus/ultimo4k"
IMAGEDIR_vuuno4k = "vuplus/uno4k"
IMAGEDIR_vuuno4kse = "vuplus/uno4kse"
IMAGEDIR_vuzero4k = "vuplus/zero4k"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-oever="SatDreamGR 5" \
    --with-distro="satdreamgr" \
    --with-boxtype="${MACHINE}" \
    --with-brandoem="${MACHINE}" \
    --with-machinebrand="${MACHINE}" \
    --with-machinename="${MACHINE}" \
    --with-machinebuild="${MACHINE}" \
    --with-machinemake="${MACHINE}" \
    --with-imageversion="${DISTRO_VERSION}" \
    --with-imagebuild="N/A" \
    --with-imagedevbuild="N/A" \
    --with-imagetype="${DISTRO_TYPE}" \
    --with-feedsurl=${DISTRO_FEED_URI} \
    --with-imagedir="${IMAGEDIR}" \
    --with-imagefs="${IMAGE_FSTYPES}" \
    --with-mtdrootfs="${MTD_ROOTFS}" \
    --with-mtdkernel="${MTD_KERNEL}" \
    --with-rootfile="${ROOTFS_FILE}" \
    --with-kernelfile="${KERNEL_FILE}" \
    --with-mkubifs="${MKUBIFS_ARGS}" \
    --with-ubinize="${UBINIZE_ARGS}" \
    --with-driverdate="N/A" \
    --with-arch="${DEFAULTTUNE}" \
    "

do_configure_prepend() {
   sed -i 's/SUBDIRS = lib remotes/SUBDIRS = lib/g' ${S}/BoxBranding/Makefile.am
   sed -i 's/install_PYTHON/#install_PYTHON/g' ${S}/BoxBranding/Makefile.am
}

do_install_prepend() {
   rm -rf ${S}/BoxBranding/*.py*
   rm -rf ${S}/BoxBranding/boxes/
   rm -rf ${S}/BoxBranding/remotes/
}

FILES_${PN}-src += "${libdir}/enigma2/python/Components/*.py"
FILES_${PN} = "${libdir}/enigma2/python/*.so /usr/share ${libdir}/enigma2/python/Components/*.pyo ${libdir}/enigma2/python/Plugins"
FILES_${PN}-dev += "${libdir}/enigma2/python/*.la"
FILES_${PN}-staticdev += "${libdir}/enigma2/python/*.a"
FILES_${PN}-dbg += "${libdir}/enigma2/python/.debug"

