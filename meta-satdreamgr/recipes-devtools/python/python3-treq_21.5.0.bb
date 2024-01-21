SUMMARY = "treq is an HTTP library inspired by requests but written on top of Twisted’s Agents"
HOMEPAGE = "https://github.com/twisted/treq"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a5dd67fd17479587f7093769d95ef186"

SRC_URI[md5sum] = "7d85acfb986192e2e1c42cb49e4ab478"
SRC_URI[sha256sum] = "02ea86383fc4b57539c45a965eaa1e9fd28302cdf382d21da8430050c97be9b8"

inherit pypi setuptools3

PYPI_PACKAGE = "treq"

PACKAGES = "${PN} ${PN}-test"

DEPENDS += "${PYTHON_PN}-pip-native"
RDEPENDS_${PN} += "${PYTHON_PN}-twisted"
RDEPENDS_${PN}-test = "${PN}"

FILES_${PN}-test = " \
    ${libdir}/${PYTHON_DIR}/site-packages/treq/test \
    ${libdir}/${PYTHON_DIR}/site-packages/treq-*.egg-info \
"
