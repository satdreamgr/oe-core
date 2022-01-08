SUMMARY = "Python Radio Interface Controller"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a756f433cda3b32df08555bc02207cc1"

inherit pypi setuptools3

PYPI_PACKAGE = "PyRIC"

PACKAGES = "${PN}"

SRC_URI[md5sum] = "c711069b2c1cb4fcc16312fed9b4d287"
SRC_URI[sha256sum] = "b539b01cafebd2406c00097f94525ea0f8ecd1dd92f7731f43eac0ef16c2ccc9"

BBCLASSEXTEND = "native nativesdk"
