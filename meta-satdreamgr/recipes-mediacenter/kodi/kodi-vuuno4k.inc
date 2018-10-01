DEPENDS += "kodiegl"
RDEPENDS_${PN} += "kodiegl"

EXTRA_OECONF += " \
    --with-platform=vuplus-cortexa15 \
    --with-ffmpeg=stb \
"
