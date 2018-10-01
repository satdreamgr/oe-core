DESCRIPTION = "Satdreamgr bootlogo"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "SatDreamGR"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=eb723b61539feef013de476e68b5c50a"

RDEPENDS_${PN} += "showiframe"

RREPLACES_${PN} = "openpli-bootlogo"
RCONFLICTS_${PN} = "openpli-bootlogo"

PV = "6"

S = "${WORKDIR}/"

INITSCRIPT_NAME = "bootlogo"
INITSCRIPT_PARAMS = "start 21 S ."

inherit update-rc.d allarch

SRC_URI = " \
	file://bootlogo.mvi \
	file://bootlogo.sh \
	"

MVI = "bootlogo.mvi"
MVISYMLINKS = "bootlogo_wait backdrop switchoff"

do_install() {
	if [ -n "${BRANDINGDIR}" -a -d "${BRANDINGDIR}/bootlogo" ] ; then
		cp --preserve=mode,links ${BRANDINGDIR}/bootlogo/* ${S}/.
	fi
	install -d ${D}/boot
	install -d ${D}/usr/share
	for i in ${MVI}; do
		install -m 0755 ${S}/$i ${D}/usr/share/
		ln -sf /usr/share/$i ${D}/boot/$i
	done;
	for i in ${MVISYMLINKS}; do
		ln -sf /boot/bootlogo.mvi ${D}/boot/$i.mvi
		ln -sf /usr/share/bootlogo.mvi ${D}/usr/share/$i.mvi;
	done;
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${S}/bootlogo.sh ${D}/${sysconfdir}/init.d/bootlogo
}

FILES_${PN} = "/boot /usr/share /etc/init.d"
