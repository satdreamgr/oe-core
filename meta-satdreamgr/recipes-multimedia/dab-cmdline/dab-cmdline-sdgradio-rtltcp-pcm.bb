require dab-cmdline-sdgradio.inc

EXTRA_OECMAKE = "-DRTL_TCP=ON -DCMAKE_INSTALL_PREFIX=/usr/bin"

do_install_append() {
	mv ${D}/usr/bin/dab-rtl_tcp-sdgradio ${D}/usr/bin/dab-rtl_tcp-sdgradio-pcm
}
