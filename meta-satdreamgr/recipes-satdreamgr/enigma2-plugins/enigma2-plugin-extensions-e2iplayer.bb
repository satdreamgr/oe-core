SUMMARY = "E2iPlayer oe-mirrors fork"
DESCRIPTION = "Watch Videos Online"
HOMEPAGE = "https://gitlab.com/zadmario/e2iplayer"
SECTION = "multimedia"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://README.md;md5=894bd5e61984ba24c3bb18f88f69130f"
SRC_URI = "git://github.com/oe-mirrors/e2iplayer.git;branch=python3;protocol=https file://e2io.patch"
S = "${WORKDIR}/git"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"
PR = "r8"

inherit distutils-openplugins

DEPENDS = "gettext-native ${PYTHON_PN}-future-native ${PYTHON_PN}"

RDEPENDS_${PN} = " \
	enigma2-plugin-extensions-e2iplayer-deps \
	${PYTHON_PN}-compression \
	${PYTHON_PN}-core \
	${PYTHON_PN}-e2icjson \
	${PYTHON_PN}-html \
	${PYTHON_PN}-json \
	${PYTHON_PN}-shell \
	"

RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
	"

deltask package_qa
