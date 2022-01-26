DESCRIPTION = "Handle your EPG on enigma2 from various sources (opentv, xmltv, custom sources)"
HOMEPAGE = "https://github.com/oe-alliance/e2openplugin-CrossEPG"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=4fbd65380cdd255951079008b364516c"

DEPENDS += "libxml2 zlib swig-native curl ${PYTHON_PN}"
RDEPENDS_${PN} += "libcurl ${PYTHON_PN}-compression xz ${PYTHON_PN}-core"

inherit gitpkgv

SRC_URI = " git://github.com/oe-alliance/e2openplugin-CrossEPG.git;protocol=https;branch=dev \
			file://add-dummy-boxbranding.patch \
			file://make-huffman-root-structure-variable-extern.patch \
			"

PV = "0.8.6+gitr${SRCPV}"
PKGV = "0.8.6+gitr${GITPKGV}"
PR = "r0"

inherit ${PYTHON_PN}-dir ${PYTHON_PN}native

ALLOW_EMPTY_${PN} = "1"

CFLAGS_append = " -I${STAGING_INCDIR}/libxml2/ -I${STAGING_INCDIR}/${PYTHON_DIR}/"

# prevent lots of QA warnings
INSANE_SKIP_${PN} += "already-stripped"

S = "${WORKDIR}/git"

do_compile() {
    echo ${PV} > ${S}/VERSION
    oe_runmake SWIG="swig"
}

do_install() {
    find ${S} -name __pycache__ -type d -exec rm -rf {} +
    oe_runmake 'D=${D}' install 'PYTHON_BASEVERSION=${PYTHON_BASEVERSION}'
}

pkg_postrm_${PN}() {
    rm -fr ${libdir}/enigma2/python/Plugins/SystemPlugins/CrossEPG > /dev/null 2>&1
}

# Just a quick hack to "compile" the python parts.
do_compile_append() {
    ${PYTHON_PN} -O -m compileall ${S}
}

python populate_packages_prepend() {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', '%s', recursive=True, match_path=True, prepend=True, extra_depends='')
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', '%s (source files)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', '%s (debug)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\/.*\.po$', 'enigma2-plugin-%s-po', '%s (translations)', recursive=True, match_path=True, prepend=True)
}

FILES_${PN}_append = " ${prefix}/crossepg ${libdir}/libcrossepg.so ${libdir}/${PYTHON_DIR}"
FILES_${PN}-src_append = " ${libdir}/${PYTHON_DIR}/crossepg.py"
FILES_${PN}-dbg_append = " ${prefix}/crossepg/scripts/mhw2epgdownloader/.debug"
FILES_${PN}-dbg += "${prefix}/crossepg/scripts/mhw2epgdownloader/.debug"
