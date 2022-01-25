DESCRIPTION = "Weather forecast for 5 days"
SUMMARY = "Weather MSN"
MAINTAINER = "Sirius"
LICENSE = "GPLv3+"
HOMEPAGE = "www.gisclub.tv"
LIC_FILES_CHKSUM = "file://python/Plugins/Extensions/WeatherMSN/plugin.py;beginline=3;endline=19;md5=ffc4a5bf0cc661f90242506d3c0fed50"

inherit gitpkgv ${PYTHON_PN}native allarch

PV = "0.7+git${SRCPV}"
PKGV = "0.7+git${GITPKGV}"
PR = "r7"

PACKAGES = "${PN}"
SRC_URI = "git://github.com/satdreamgr/enigma2-plugin-extensions-weathermsn.git;protocol=https;branch=python3-fixes"
SRCREV = "${AUTOREV}"

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

FILES_${PN}-src += "${libdir}/enigma2/python/Plugins/Extensions/*/*.py ${libdir}/enigma2/python/Plugins/Extensions/*/*/*.py"
