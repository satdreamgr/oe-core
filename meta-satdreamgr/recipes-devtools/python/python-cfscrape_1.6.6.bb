SUMMARY  = "A simple Python module to bypass Cloudflare's anti-bot page."
DESCRIPTION = "See https://github.com/Anorov/cloudflare-scrape for more information."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=879c38f03989886f224a4f30c989b15a"

RDEPENDS_${PN} += "python-js2py"

inherit pypi allarch setuptools

SRC_URI[md5sum] = "7f600f894975f69bf1d9177c4f11fce1"
SRC_URI[sha256sum] = "2e4af33b357f04a88eb976a0490318c87776a1057f99606e9795714c077a7ae1"
