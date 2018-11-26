SUMMARY = "Megatools - command line client for Mega.nz"
DESCRIPTION = "Megatools is a collection of programs for \
		accessing Mega.nz service from a command line \
		of your desktop or server."

HOMEPAGE = "https://megatools.megous.com/"
SECTION = "console/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=457c4466c2c0b6c226463fa63d34ca0d"

DEPENDS = "asciidoc-native curl glib-2.0 openssl"

inherit autotools-brokensep pkgconfig

SRC_URI = "https://megatools.megous.com/builds/megatools-${PV}.tar.gz"
SRC_URI[md5sum] = "b9c7e18b4daf48867d7c669a674744b0"
SRC_URI[sha256sum] = "179e84c68e24696c171238a72bcfe5e28198e4c4e9f9043704f36e5c0b17c38a"

S = "${WORKDIR}/megatools-${PV}"
