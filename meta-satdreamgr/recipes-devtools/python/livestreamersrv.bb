DESCRIPTION = "Livestreamersrv is a helper deamon for livestreamer"
SECTION = "devel/python"
MAINTAINER = "SatDreamGR"
HOMEPAGE = "www.satdreamgr.com"
inherit allarch

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

RDEPENDS_${PN} = "livestreamer streamlink"

SRC_URI = "git://github.com/athoik/livestreamersrv.git"
S = "${WORKDIR}/git/"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "0.4+git${SRCPV}"
PKGV = "0.4+git${GITPKGV}"

PACKAGES = "${PV}"

do_install_append() {
	install -d ${D}${sbindir}
	install -d ${D}${datadir}
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rc3.d
	install -d ${D}${sysconfdir}/rc4.d
	install -m 0755 ${S}/livestreamersrv ${D}${sbindir}
	install -m 0644 ${S}/offline.mp4 ${D}${datadir}
	ln -sf ${sbindir}/livestreamersrv ${D}${sysconfdir}/init.d/livestreamersrv
	ln -sf ../init.d/livestreamersrv ${D}${sysconfdir}/rc3.d/S50livestreamersrv
	ln -sf ../init.d/livestreamersrv ${D}${sysconfdir}/rc4.d/S50livestreamersrv
}

FILES_${PN} = "/"
