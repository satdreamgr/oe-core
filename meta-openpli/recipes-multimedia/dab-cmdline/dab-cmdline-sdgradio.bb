SUMMARY = "DAB decoding library with example of its use"
SECTION = "libs/multimedia"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "fftw libusb1 faad2 zlib rtl-sdr"
RDEPENDS_${PN} = "rtl-sdr"

inherit gitpkgv

PV = "1.3+git${SRCPV}"
PKGV = "1.3+git${GITPKGV}"

SRC_URI = "git://github.com/satdreamgr/dab-cmdline.git;protocol=https;branch=sdgradio"

EXTRA_OECMAKE = "-DAAC_OUT=ON -DRTLSDR=ON -DCMAKE_INSTALL_PREFIX=/usr/bin"

S = "${WORKDIR}/git/sdgradio"

inherit cmake pkgconfig

do_configure_prepend() {
	sed -i -e 's:librtlsdr.so:librtlsdr.so.0:g' ${WORKDIR}/git/devices/rtlsdr-handler/rtlsdr-handler.cpp
}
