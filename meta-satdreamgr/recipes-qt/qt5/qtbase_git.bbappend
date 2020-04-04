FILESEXTRAPATHS_prepend := "${THISDIR}/qtbase:"

SRC_URI_append = " file://0001-implement-openssl111.patch"
SRC_URI_append = " file://mkspecs-fix-build-with-gcc9.patch"

INSANE_SKIP_${PN} += "file-rdeps"
INSANE_SKIP_${PN}-plugins += "file-rdeps"

# Qt packages are machine specific
#QT_PACKAGES_ARCH = "${MACHINE_ARCH}"
PACKAGE_ARCH := "${MACHINE_ARCH}"

PACKAGECONFIG_GL = "gles2"
PACKAGECONFIG_FB = ""
PACKAGECONFIG_X11 = ""
