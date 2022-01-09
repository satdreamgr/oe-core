SUMMARY = "Drivers for Realtek 8821CU/8811CU"
HOMEPAGE = "http://www.realtek.com.tw"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://wlan0dhcp;md5=069fc07a0c587af26235837dc342eb25"

inherit module

BRANCH = "master"

SRC_URI = " \
    git://github.com/brektrou/rtl8821CU.git;branch=${BRANCH} \
    file://0001-disable-mp-hw-tx-mode-for-vht.patch \
    file://0002-adjust-policy-kernelversion.patch \
    file://support-kernel-5.1-to-5.9.patch \
    file://restore_support_for_kernels_older_than_420.patch \
"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR} KDIR=${STAGING_KERNEL_DIR} KSRC=${STAGING_KERNEL_DIR}"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/8821cu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}

do_package_qa() {
}
