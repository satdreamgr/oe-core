SUMMARY = "EDID decoder and conformance tester"
DESCRIPTION = "edid-decode decodes EDID monitor description data in human-readable format"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://edid-decode.cpp;beginline=1;endline=1;md5=6ec41034e04432ee375d0e14fba596f4"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://linuxtv.org/edid-decode.git;protocol=git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig
