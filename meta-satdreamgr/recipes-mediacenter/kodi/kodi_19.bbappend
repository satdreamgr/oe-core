
EXTRA_OECMAKE_append_osmio4k = " -DWITH_PLATFORM=edision-cortexa15 -DWITH_FFMPEG=stb"
EXTRA_OECMAKE_append_osmio4kplus = " -DWITH_PLATFORM=edision-cortexa15 -DWITH_FFMPEG=stb"
EXTRA_OECMAKE_append_osmini4k = " -DWITH_PLATFORM=edision-cortexa15 -DWITH_FFMPEG=stb"
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
