PACKAGE_ARCH = "${MACHINE}"
PROVIDES += "virtual/kodi"
RPROVIDES_${PN} += "virtual/kodi"
INSANE_SKIP_${PN} += "file-rdeps"

RDEPENDS_${PN}_hd51 += "hd-v3ddriver-hd51"
EXTRA_OECONF_hd51 += "--with-platform=v3d-cortexa15 --with-ffmpeg=stb"

RDEPENDS_${PN}_osmega += "v3d-libgles-osmega"
EXTRA_OECONF_osmega += "--with-platform=xcore-mipsel --with-ffmpeg=stb"

RDEPENDS_${PN}_et10000 += "xtrend-v3ddriver-et10000"
EXTRA_OECONF_et10000 += "--with-platform=v3d-mipsel --with-ffmpeg=stb"

RDEPENDS_${PN}_sf4008 += "nextv-v3ddriver-sf4008 platform-util-sf4008 octagon-dvb-modules-kodi-sf4008"
EXTRA_OECONF_sf4008 += "--with-platform=nextv-cortexa15 --with-ffmpeg=stb"

include kodi-${MACHINE}.inc
