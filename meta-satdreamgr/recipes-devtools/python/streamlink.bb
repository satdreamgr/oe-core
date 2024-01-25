SUMMARY = "CLI for extracting streams from various websites to a video player of your choosing"
DESCRIPTION = "Streamlink is a command-line utility that pipes video streams from various services into a video player, such as VLC."
HOMEPAGE = "https://github.com/streamlink/streamlink"
SECTION = "devel/python"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=15519b204ac11ccc2e4c72b87d310191"

DEPENDS += "${PYTHON_PN}-importlib-metadata-native"

RDEPENDS_${PN} = "${PYTHON_PN}-core \
    ${PYTHON_PN}-ctypes \
    ${PYTHON_PN}-futures3 \
    ${PYTHON_PN}-isodate \
    ${PYTHON_PN}-profile \
    ${PYTHON_PN}-pycountry \
    ${PYTHON_PN}-lxml \
    ${PYTHON_PN}-misc \
    ${PYTHON_PN}-pkgutil \
    ${PYTHON_PN}-pycryptodome \
    ${PYTHON_PN}-pysocks \
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-singledispatch \
    ${PYTHON_PN}-typing-extensions \
    ${PYTHON_PN}-websocket-client \
    "

inherit setuptools3 python3-dir gittag

SRCREV_streamlink = "f868f969598a46f8effd0e25774819f87d73c9f5"
SRCREV_plugins = "${AUTOREV}"
SRCREV_FORMAT = "streamlink_plugins"

PV = "6.0.0+git${SRCPV}"
PKGV = "6.0.0+git${GITPKGV}"
PR = "r2"

SRC_URI = "git://github.com/streamlink/streamlink;protocol=https;branch=master;name=streamlink \
    git://github.com/oe-mirrors/streamlink-plugins;protocol=https;branch=master;name=plugins;destsuffix=additional-plugins \
    file://module.patch \
    file://version.patch \
    "

S = "${WORKDIR}/git"

do_unpack_append() {
    bb.build.exec_func('do_prepare_plugins_dir', d)
}

do_prepare_plugins_dir() {
    cp -f ${WORKDIR}/additional-plugins/*.py ${S}/src/streamlink/plugins
}

do_install_append() {
    rm -rf ${D}${bindir}
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/streamlink_cli
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/*.egg-info
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/streamlink/plugins/.removed
    rm -rf ${D}${datadir}
}

PACKAGES = "${PN}-src ${PN}"
FILES_${PN} = " \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*.pyc \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*.pyc \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*/*.pyc \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*/*/*.pyc \
    "

FILES_${PN}-src += " \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*.py \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*.py \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*/*.py \
    ${libdir}/${PYTHON_DIR}/site-packages/streamlink/*/*/*/*.py \
    "
