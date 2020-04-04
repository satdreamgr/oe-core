SRC_URI += " \
        file://0001-Expose-WebSecurityEnabled-via-Qt.patch \
        file://0002-Add-HbbTV-Mimetypes.patch \
        file://0003-always-emit-keypress-event-with-keycode.patch \
        file://0004-Enable-NPAPI-for-Qt-without-X11.patch \
        file://u16_next.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/qtwebkit-git:"

INSANE_SKIP_${PN} += "file-rdeps ldflags"

# Qt packages are machine specific
#QT_PACKAGES_ARCH = "${MACHINE_ARCH}"
PACKAGE_ARCH := "${MACHINE_ARCH}"

DEPENDS += " bison-native"
