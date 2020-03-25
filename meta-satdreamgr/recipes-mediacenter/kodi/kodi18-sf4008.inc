RDEPENDS_${PN}_append = "nextv-v3ddriver-${MACHINE} platform-util-${MACHINE} octagon-dvb-modules-kodi-${MACHINE}"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=nextv-cortexa15 \
    -DWITH_FFMPEG=stb \
"

