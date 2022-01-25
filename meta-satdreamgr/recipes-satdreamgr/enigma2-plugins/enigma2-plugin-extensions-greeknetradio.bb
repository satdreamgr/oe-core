DESCRIPTION = "GreekNetRadio"
SUMMARY = "Greek web radios"
SECTION = "multimedia"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "http://satdreamgr.com"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://setup.py;beginline=1;endline=7;md5=13b35882afe77ccd62fe14f78592f409"

RDEPENDS_${PN} = "${PYTHON_PN}-core"

PV = "3.1+git${SRCPV}"
PKGV = "3.1+git${GITPKGV}"
PR = "r0"

S="${WORKDIR}/git"

SRC_URI = "git://github.com/satdreamgr/GreekNetRadio;protocol=https"

SRCREV = "${AUTOREV}"

inherit distutils-openplugins gitpkgv

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/GreekNetRadio/*"
FILES_${PN}-src = "${libdir}/enigma2/python/Plugins/Extensions/GreekNetRadio/*.py"
