SUMMARY = "MPEG Transport Stream Toolkit"
DESCRIPTION = "TSDuck is an extensible toolkit for MPEG/DVB transport streams.\
	TSDuck is used in digital television systems for test, monitoring, integration, debug, lab, demo."
MAINTAINER = "https://tsduck.io/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;beginline=1;endline=3;md5=b09fb1a844dc6c73c0bcda8f93defcca"

SRC_URI = "git://github.com/tsduck/tsduck.git"
SRCREV = "${AUTOREV}"

DEPENDS = "gettext curl"

S = "${WORKDIR}/git"

inherit gitpkgv autotools-brokensep pkgconfig gettext

PV = "3.16+gitr${SRCPV}"
PKGV = "3.16+git${GITPKGV}"
PR = "r0"

TARGET_CC_ARCH += "${LDFLAGS}"
EXTRA_OEMAKE = "NOTEST=1 NOPCSC=1 NODTAPI=1 MAIN_ARCH=${TUNE_PKGARCH} SYSROOT=${D}"
