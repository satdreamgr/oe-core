DESCRIPTION = "Weather forecast for 5 days"
SUMMARY = "Weather MSN"
MAINTAINER = "Sirius"
LICENSE = "GPLv3+"
HOMEPAGE = "www.gisclub.tv"
LIC_FILES_CHKSUM = "file://python/Plugins/Extensions/WeatherMSN/plugin.py;beginline=3;endline=19;md5=ffc4a5bf0cc661f90242506d3c0fed50"

inherit gitpkgv ${PYTHON_PN}native allarch

PV = "0.7+git${SRCPV}"
PKGV = "0.7+git${GITPKGV}"
PR = "r5"

PACKAGE_DEBUG_SPLIT_STYLE = "debug-without-src"
PACKAGES = "${PN}-src ${PN}"

SRC_URI = "git://github.com/Sirius0103/enigma2-plugins.git;protocol=https"
SRCREV = "a704ae5593144142c9dd9091e68a540809a4aea7"

FILES_${PN}-src += "/usr/lib/enigma2/python/Plugins/Extensions/*/*.py /usr/lib/enigma2/python/Plugins/Extensions/*/*/*.py"
FILES_${PN} = "/usr/lib/enigma2/"

S = "${WORKDIR}/git"

do_compile() {
	${PYTHON_PN} -O -m compileall -d /usr/lib/enigma2/python/ ${S}/python/Plugins/Extensions/WeatherMSN/
}

do_install() {
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions
	cp -r --preserve=mode,links ${S}/python/Plugins/Extensions/WeatherMSN ${D}/usr/lib/enigma2/python/Plugins/Extensions/
	chmod -R a+rX ${D}/usr/lib/enigma2/
}

