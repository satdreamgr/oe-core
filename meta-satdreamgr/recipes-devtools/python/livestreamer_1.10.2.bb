DESCRIPTION = "Livestreamer is CLI program that extracts streams \
	from various services and pipes them into a video player of choice."
HOMEPAGE = "http://livestreamer.tanuki.se/en/latest/"
SECTION = "devel/python"
LICENSE = "BSD"
PACKAGE_ARCH = "all"

RDEPENDS_${PN} = "python \
	python-ctypes \
	python-misc \
	python-pkgutil \
	python-requests \
	python-shell \
	python-subprocess \
	python-singledispatch \
	python-futures \
	"

PR = "r0"

SRC_URI = "git://github.com/chrippa/livestreamer;protocol=git"

S = "${WORKDIR}/git/"

SRCREV = "v${PV}"

LIC_FILES_CHKSUM = "file://LICENSE;md5=e097640e535ad2547b8d8517410b9ec4"

inherit setuptools

do_install_append() {
   rm -rf ${D}${bindir}
   rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/livestreamer_cli
}

FILES_${PN} = " \
	${libdir}/${PYTHON_DIR}/site-packages/livestreamer/*.pyo \
	${libdir}/${PYTHON_DIR}/site-packages/livestreamer/*/*.pyo \
	${libdir}/${PYTHON_DIR}/site-packages/livestreamer/*/*/*.pyo \
	"

PACKAGES =+ "${PN}-src"

FILES_${PN}-src = " \
	${libdir}/${PYTHON_DIR}/site-packages/livestreamer-${PV}-*.egg-info/* \
	${libdir}/${PYTHON_DIR}/site-packages/livestreamer/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/livestreamer/*/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/livestreamer/*/*/*.py \
	"

