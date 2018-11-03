SRC_URI_append = "file://0001-osmio4k-support.patch"

INSANE_SKIP_${PN} += "file-rdeps"

EXTRA_OECONF += " \
    --with-platform=edision-aarch64 \
    --with-ffmpeg=stb \
"
