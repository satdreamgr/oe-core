SUMMARY = "IPTV Player for E2"
DESCRIPTION = "IPTV Player for E2"
HOMEPAGE = "https://gitlab.com/iptvplayer-for-e2/"
SECTION = "multimedia"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://IPTVPlayer/plugin.py;md5=180a6bea75d2e48955fe9166eb94f095"
SRC_URI = "git://gitlab.com/iptvplayer-for-e2/iptvplayer-for-e2.git;protocol=http"
S = "${WORKDIR}/git"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

inherit allarch distutils-openplugins

RDEPENDS_${PN} = " \
	python-compression \
	python-core \
	python-html \
	python-json \
	python-shell \
	python-subprocess \
	python-textutils \
	"

PACKAGES =+ " ${PN}-src"
RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
	"

deltask package_qa
