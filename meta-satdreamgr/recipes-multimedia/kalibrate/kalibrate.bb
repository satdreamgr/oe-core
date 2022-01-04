SUMMARY = "Kalibrate PPM frequency"
DESCRIPTION = "Kalibrate, or kal, can scan for GSM base stations in a given frequency band and can use those GSM base stations to calculate the local oscillator frequency offset."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0eae42b21c81e0e7c8c3e8a545e156c9"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/steve-m/kalibrate-rtl.git;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "rtl-sdr fftw"

inherit autotools pkgconfig
