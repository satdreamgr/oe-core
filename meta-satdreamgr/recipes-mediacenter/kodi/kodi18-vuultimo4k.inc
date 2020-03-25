DEPENDS += "kodiegl"
RDEPENDS_${PN} += "kodiegl"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=vuplus-cortexa15 \
    -DWITH_FFMPEG=stb \
"

