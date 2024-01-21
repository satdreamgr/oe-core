SUMMARY = "Versioning It with your Version In Git"
HOMEPAGE = "https://github.com/jwodder/versioningit"
AUTHOR = "John Thorvald Wodder II <versioningit@varonathe.org>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f50f611f98ab86be42339ced21a10fdc"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

RDEPENDS_${PN} += "${PYTHON_PN}-packaging ${PYTHON_PN}-tomli"

SRC_URI[sha256sum] = "4e3ce47a6424d850ae9e55e1b134a020e9fcbcb895338f107f2b5c51d34c9c1b"

PYPI_PACKAGE = "versioningit"

inherit pypi python_setuptools_build_meta

require python3-package-split.inc

FILES_${PN}-src += "${bindir}/versioningit"

BBCLASSEXTEND = "native"
