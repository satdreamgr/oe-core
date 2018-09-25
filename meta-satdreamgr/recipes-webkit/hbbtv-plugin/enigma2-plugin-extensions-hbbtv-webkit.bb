DESCRIPTION = "E2 Webkit HbbTV Plugin"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

RDEPENDS_${PN} = "dumpait-legacy \
    webkit-hbbtv-plugin \
"

inherit gitpkgv

SRCREV = "${AUTOREV}"
PKGVERSION = "2.0-r0"
PV = "${PKGVERSION}-${SRCPV}"
PKGV = "${PKGVERSION}-${GITPKGV}"
PR = "r0"

INSANE_SKIP_${PN} += "already-stripped arch"

SRC_URI = "git://github.com/oe-alliance/enigma2-plugin-extensions-hbbtv-webkit.git;protocol=https"

S = "${WORKDIR}/git"

do_package_qa() {
}

DESTDIR = "enigma2/python/Plugins/Extensions/HbbTV"

do_install_append() {
    install -d ${D}${libdir}/${DESTDIR}
    
    # Python Files
    cp -aRf ${S}/HbbTV/* ${D}${libdir}/${DESTDIR}
    python -O -m compileall ${D}${libdir}/${DESTDIR}
    rm -rf ${D}${libdir}/${DESTDIR}/*.py
}

FILES_${PN} = "/"
