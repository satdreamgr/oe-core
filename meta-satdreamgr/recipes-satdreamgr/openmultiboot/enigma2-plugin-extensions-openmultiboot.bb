SUMMARY = "Multi boot loader for enigma2"
MAINTAINER = "oe-alliance"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit gitpkgv ${PYTHON_PN}native gettext python3targetconfig

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r5"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://github.com/oe-alliance/openmultibootmanager.git;protocol=https;branch=main"

S = "${WORKDIR}/git"

inherit autotools-brokensep

DEPENDS = "${PYTHON_PN} lzo"

RDEPENDS_${PN} = "kernel-module-nandsim openmultiboot oe-alliance-branding lzo"

RDEPENDS_${PN}_dm800 = "openmultiboot oe-alliance-branding unjffs2"
RDEPENDS_${PN}_dm500hd = "openmultiboot oe-alliance-branding unjffs2"
RDEPENDS_${PN}_dm800se = "openmultiboot oe-alliance-branding unjffs2"

EXTRA_OECONF = "\
    --with-po \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-arch=${TARGET_ARCH} \
    "

do_install_append() {
    # remove unused .pyc files
    find ${D}${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/ -name '*.pyc' -exec rm {} \;
    
    # remove helper .pyo file
    find ${D}${libdir}/enigma2/python/Plugins/Extensions/${PLUGIN}/ -name '*helper.pyo' -exec rm {} \;
}

# skip this!
install_egg_info() {
}

do_configure_prepend() {
    touch ${S}/NEWS
    touch ${S}/README
    touch ${S}/AUTHORS
    touch ${S}/ChangeLog
}

pkg_preinst_${PN}() {
#!/bin/sh
if mountpoint -q ${libdir}/enigma2/python/Plugins/Extensions/OpenMultiboot; then
    echo "openMultiBoot will only install on main image."
    echo "Child image is running - canceling installation!"
    sleep 3
    exit 1
else
    echo "Main image is running - proceeding installation..."
    exit 0
fi
}

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(?!.*helper\.py).*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}
