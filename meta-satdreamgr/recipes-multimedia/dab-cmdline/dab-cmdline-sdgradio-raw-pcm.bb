require dab-cmdline-sdgradio.inc

EXTRA_OECMAKE = "-DRAWFILES=ON -DCMAKE_INSTALL_PREFIX=/usr/bin"

do_install_append() {
	mv ${D}/usr/bin/dab-raw-sdgradio ${D}/usr/bin/dab-raw-sdgradio-pcm
}
