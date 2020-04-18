DESCRIPTION = "meta file for dab-cmdline-sdgradio"
require conf/license/openpli-gplv2.inc

PV = "1.3"

inherit allarch

RDEPENDS_${PN} = "\
	dab-cmdline-sdgradio-aac \
	dab-cmdline-sdgradio-pcm \
	dab-cmdline-sdgradio-raw-aac \
	dab-cmdline-sdgradio-raw-pcm \
	dab-cmdline-sdgradio-rtltcp-aac \
	dab-cmdline-sdgradio-rtltcp-pcm \
	"

PACKAGES = "${PN}"
ALLOW_EMPTY_${PN} = "1"

# We only need the packaging tasks - disable the rest
do_fetch[noexec] = "1"
do_unpack[noexec] = "1"
do_patch[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install[noexec] = "1"
