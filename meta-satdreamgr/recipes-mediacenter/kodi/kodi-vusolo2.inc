EXTRA_OECMAKE_append = " -DWITH_PLATFORM=vuplus-mipsel  -DWITH_FFMPEG=stb"

GLPR = "20160331_r0"
SRC_URI_append = " http://code.vuplus.com/download/release/kodi/xbmc-support_${MACHINE}_${GLPR}.tar.gz;name=xbmc-support"

SRC_URI[xbmc-support.md5sum] = "e29a91b185133ec60a59e94a8229d2b4"
SRC_URI[xbmc-support.sha256sum] = "3c56b7ee890b3e21f378acd79db3752d721de0880b6d763bbd37fa942c2ae2b5"

include kodi-vuplus.inc
