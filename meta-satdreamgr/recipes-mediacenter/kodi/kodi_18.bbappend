PACKAGE_ARCH = "${MACHINE}"
PROVIDES += "virtual/kodi"
RPROVIDES_${PN} += "virtual/kodi"
INSANE_SKIP_${PN} += "file-rdeps"

include kodi18-${MACHINE}.inc
