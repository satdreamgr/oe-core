RDEPENDS_${PN} += "v3d-libgles-osmega"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=xcore-mipsel \
    -DWITH_FFMPEG=stb \
"

