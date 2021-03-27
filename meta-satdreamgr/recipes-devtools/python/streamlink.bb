SUMMARY = "CLI for extracting streams from various websites to a video player of your choosing"
DESCRIPTION = "Streamlink is a command-line utility that pipes video streams from various services into a video player, such as VLC."
HOMEPAGE = "https://streamlink.github.io/"
SECTION = "devel/python"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://LICENSE;md5=7c0be52291b7252b878da806d185b1d1"

inherit setuptools

RDEPENDS_${PN} = " \
	python-argparse \
	python-backports-functools-lru-cache \
	python-backports-shutil-which \
	python-ctypes \
	python-futures \
	python-iso3166 \
	python-iso639 \
	python-isodate \
	python-misc \
	python-parse \
	python-pkgutil \
	python-pycrypto \
	python-requests \
	python-shell \
	python-singledispatch \
	python-subprocess \
	python-websocket-client \
	"

SRC_URI = "git://github.com/Billy2011/streamlink-27.git;protocol=git"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git/"

inherit gitpkgv python-dir

PV = "2.0.0+git${SRCPV}"
PKGV = "2.0.0+git${GITPKGV}"
PR = "r0"

do_install_append() {
	rm -rf ${D}${bindir}
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/streamlink_cli
}

PACKAGES = "${PN}-src ${PN}"

FILES_${PN} = " \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*.pyo \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*.pyo \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*/*.pyo \
    "

FILES_${PN}-src += " \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink-*.egg-info/* \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*.py \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*.py \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*/*.py \
    "

