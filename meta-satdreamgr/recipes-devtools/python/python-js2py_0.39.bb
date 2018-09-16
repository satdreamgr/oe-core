SUMMARY  = "JavaScript to Python Translator & JavaScript interpreter written in 100% pure Python."
DESCRIPTION = "Translates JavaScript to Python code. Js2Py is able to translate and execute virtually any JavaScript code."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=0e657c467f9c43e1e317b1ff5bef6c80"

PYPI_PACKAGE = "Js2Py"

RRECOMENDS_${PN} += "python-six"

inherit pypi setuptools

SRC_URI[md5sum] = "c40b07dc7e8e51d268a70146e32b0603"
SRC_URI[sha256sum] = "3bdc8c57518a21cec2cb97a922ecaeb826471d5e13de45a63a91a2b16ad3a1ac"
