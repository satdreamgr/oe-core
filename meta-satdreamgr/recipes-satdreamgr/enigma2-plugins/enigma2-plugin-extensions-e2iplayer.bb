SUMMARY = "E2iPlayer zadmario fork"
DESCRIPTION = "Watch Videos Online"
HOMEPAGE = "https://gitlab.com/zadmario/e2iplayer"
SECTION = "multimedia"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://README.md;md5=02f735bad3e90ba91c281a94ae92a684"
SRC_URI = "git://gitlab.com/zadmario/e2iplayer.git;protocol=http file://e2i.patch"
S = "${WORKDIR}/git"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"
PR = "r6"

inherit distutils-openplugins


RCONFLICTS_${PN} = "enigma2-plugin-extensions-iptvplayer"
RREPLACES_${PN} = "enigma2-plugin-extensions-iptvplayer"

RDEPENDS_${PN} = " \
	enigma2-plugin-extensions-e2iplayer-deps \
	python-compression \
	python-core \
	python-e2icjson \
	python-html \
	python-json \
	python-shell \
	python-subprocess \
	python-textutils \
	"

#PACKAGES =+ " ${PN}-src"
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
