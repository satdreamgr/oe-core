require dab-cmdline-sdgradio.inc

EXTRA_OECMAKE = "-DRTLSDR=ON -DCMAKE_INSTALL_PREFIX=/usr/bin"

do_install_append() {
	mv ${D}/usr/bin/dab-rtlsdr-sdgradio ${D}/usr/bin/dab-rtlsdr-sdgradio-pcm
}
