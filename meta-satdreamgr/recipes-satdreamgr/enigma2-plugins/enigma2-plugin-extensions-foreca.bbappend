FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-Satdreamgr-Foreca-Changes.patch"
CONFFILES_${PN} += "/etc/enigma2/Foreca/GreekCity.cfg"
PR="r3"
