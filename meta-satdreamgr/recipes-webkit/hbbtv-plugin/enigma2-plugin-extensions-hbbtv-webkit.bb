DESCRIPTION = "E2 Webkit HbbTV Plugin"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

RDEPENDS_${PN} = "dumpait-legacy \
    webkit-hbbtv-plugin \
"

inherit gitpkgv python3native

SRCREV = "${AUTOREV}"
PKGVERSION = "2.0-r0"
PV = "${PKGVERSION}-${SRCPV}"
PKGV = "${PKGVERSION}-${GITPKGV}"
PR = "r3"

INSANE_SKIP_${PN} += "already-stripped arch"

SRC_URI = "git://github.com/oe-alliance/enigma2-plugin-extensions-hbbtv-webkit.git;protocol=https;branch=dev \
	file://revert-machine-specific.patch \
"

S = "${WORKDIR}/git"

do_package_qa() {
}

DESTDIR = "enigma2/python/Plugins/Extensions/HbbTV"

do_install_append() {
    install -d ${D}${libdir}/${DESTDIR}
    
    # Python Files
    cp -aRf ${S}/HbbTV/* ${D}${libdir}/${DESTDIR}
    ${PYTHON_PN} -O -m compileall ${D}${libdir}/${DESTDIR}
}

FILES_${PN} = "/"
FILES_${PN}-src = "${libdir}/${DESTDIR}/*.py"
