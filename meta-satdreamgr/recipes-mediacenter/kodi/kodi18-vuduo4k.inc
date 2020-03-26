DEPENDS += "kodiegl"
RDEPENDS_${PN} += "kodiegl"

SRC_URI_append = " file://vuplus-fix-exception-duo4k.patch"

EXTRA_OECMAKE += " \
    -DWITH_PLATFORM=vuplus-cortexa15 \
    -DWITH_FFMPEG=stb \
"

