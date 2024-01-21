SUMMARY = "Fast closed captions extractor for MPEG and H264 files"
DESCRIPTION = "CCExtractor is a tool used to produce subtitles for TV recordings from almost anywhere in the world."
MAINTAINER = "https://www.ccextractor.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../LICENSE.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit gitpkgv

PV = "0.94+git${SRCPV}"
PKGV = "0.94+git${GITPKGV}"
PR = "r0"

SRC_URI = "git://github.com/ccextractor/ccextractor.git;protocol=https"
SRCREV = "97b381a2b0bee35d3b22411772329eb540ee511b"


S = "${WORKDIR}/git/linux"

DEPENDS = "virtual/libiconv libpng"

inherit autotools-brokensep pkgconfig gettext

do_configure_prepend() {
	./pre-build.sh
}

EXTRA_OECONF_append = " --with-rust=no "
CPPFLAGS_append = " -DPNG_ARM_NEON_OPT=0"
INSANE_SKIP_${PN} = "already-stripped"
