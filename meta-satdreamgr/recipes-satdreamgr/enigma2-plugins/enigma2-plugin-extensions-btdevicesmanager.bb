SUMMARY = "Bluetooth Devices Manager"
DESCRIPTION = "Manage your bluetooth devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit gitpkgv distutils-openplugins

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/satdreamgr/BTDevicesManager.git"
S = "${WORKDIR}/git"

RDEPENDS_${PN} = "bluez5 python-bluetool"

PACKAGES =+ "${PN}-src"
RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/BTDevicesManager/*.py"
