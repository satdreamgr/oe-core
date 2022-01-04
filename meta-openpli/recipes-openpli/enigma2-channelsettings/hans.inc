LICENSE = "CLOSED"

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/haroo/HansSettings.git;protocol=https"
S = "${WORKDIR}/git"

PACKAGES = "${PN}"
PACKAGE_ARCH = "all"
inherit gitpkgv allarch

FILES_${PN} = "${sysconfdir}/enigma2/"

do_install () {
	install -d ${D}${sysconfdir}/enigma2
	cp -r --preserve=mode,links ${S}/${SETTINGS_FILENAME}/* ${D}${sysconfdir}/enigma2
	if [ -e ${D}/etc/enigma2/satellites.xml ]; then
		rm -f ${D}/etc/enigma2/satellites.xml
	fi
}
