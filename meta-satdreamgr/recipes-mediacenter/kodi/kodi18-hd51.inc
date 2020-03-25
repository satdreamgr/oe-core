RDEPENDS_${PN} += "hd-v3ddriver-${MACHINE}"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=v3d-cortexa15 \
    -DWITH_FFMPEG=stb \
"

