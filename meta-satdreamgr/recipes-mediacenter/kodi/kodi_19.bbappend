
EXTRA_OECMAKE_append_osmio4k = " -DWITH_PLATFORM=edision-cortexa15 -DWITH_FFMPEG=stb"
SRC_URI_append_osmio4k = " file://0001-Add-initial-support-for-V4L2-mem2mem-decoder.patch"

EXTRA_OECMAKE_append_osmio4kplus = " -DWITH_PLATFORM=edision-cortexa15 -DWITH_FFMPEG=stb"
SRC_URI_append_osmio4kplus = " file://0001-Add-initial-support-for-V4L2-mem2mem-decoder.patch"

EXTRA_OECMAKE_append_osmini4k = " -DWITH_PLATFORM=edision-cortexa15 -DWITH_FFMPEG=stb"
SRC_URI_append_osmini4k = " file://0001-Add-initial-support-for-V4L2-mem2mem-decoder.patch"

EXTRA_OECMAKE_append_osmega = " -DWITH_PLATFORM=xcore-mipsel -DWITH_FFMPEG=stb"

SRC_URI_append_sf8008 = " file://hiplayer-19.patch"
SRC_URI_remove_sf8008 = "file://0009-e2-player.patch"
SRC_URI_remove_sf8008 = "file://0010-gst-player.patch"
DEPENDS_append_sf8008 = " octagon-libs-${MACHINE}"
RDEPENDS_${PN}_append_sf8008 = " octagon-libs-${MACHINE}"
RDEPENDS_${PN}_append_sf8008 = " octagon-opengl-${MACHINE}"
EXTRA_OECMAKE_append_sf8008 = " -DWITH_PLATFORM=clap-cortexa15 -DWITH_FFMPEG=stb"

RDEPENDS_${PN}_append_sf4008 = "nextv-v3ddriver-${MACHINE} platform-util-${MACHINE} octagon-dvb-modules-kodi-${MACHINE}"
EXTRA_OECMAKE_append_sf4008 = " -DWITH_PLATFORM=nextv-cortexa15 -DWITH_FFMPEG=stb"
INSANE_SKIP_${PN}_sf4008 += "file-rdeps"

EXTRA_OECMAKE_append_hd51 = " -DWITH_PLATFORM=v3d-cortexa15 -DWITH_FFMPEG=stb"
RDEPENDS_${PN}_append_hd51 = " hd-v3ddriver-${MACHINE}"

#include kodi-${MACHINE}.inc
SRC_URI_remove_vusolo2 = "file://0005-stb-support-19.patch"
SRC_URI_remove_vusolo2 = "file://0006-stb-settings-19.patch"
SRC_URI_remove_vusolo2 = "file://0007-add-winsystemfactory-windowing-init.patch"
SRC_URI_remove_vusolo2 = "file://0008-adapt-window-system-registration.patch"
SRC_URI_remove_vusolo2 = "file://0010-gst-player.patch"
SRC_URI_append_vusolo2 = " file://pli-stb-support-19.patch"
SRC_URI_append_vusolo2 = " file://0007-add-winsystemfactory-windowing-init.patch"
SRC_URI_append_vusolo2 = " file://0008-adapt-window-system-registration.patch"
SRC_URI_append_vusolo2 = " file://0001-EGLNativeTypeVuplus.patch"
EXTRA_OECMAKE_append_vusolo2 = " -DWITH_PLATFORM=vuplus-mipsel"
DEPENDS_append_vusolo2 = " vuplus-kodi-${MACHINE}"
RDEPENDS_${PN}_append_vusolo2 = " vuplus-kodi-${MACHINE}"

SRC_URI_append_vuduo4kse = " file://vuplus-fix-exception-duo4k.patch"
DEPENDS_append_vuduo4kse = " kodiegl"
RDEPENDS_${PN}_append_vuduo4kse = " kodiegl"
EXTRA_OECMAKE_append_vuduo4kse = " -DWITH_PLATFORM=vuplus-cortexa15 -DWITH_FFMPEG=stb"

