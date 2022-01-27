DESCRIPTION = "Configuration files for satdreamgr-extra feeds"
PR = "r7"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${OPENPLI_BASE}/LICENSE;md5=eb723b61539feef013de476e68b5c50a"

#FEEDS = "satdreamgr-extra satdreamgr-extra-${MACHINE} satdreamgr-extra-${TUNE_PKGARCH} picons"
FEEDS = "picons"

do_compile() {
    [ ! -d ${S}/${sysconfdir}/opkg ] && mkdir -p ${S}/${sysconfdir}/opkg
    for feed in ${FEEDS}; do
        echo "src/gz ${feed} http://${DISTRO_HOST}/feeds/${feed}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
    done
}
do_install () {
        install -d ${D}${sysconfdir}/opkg
        install -m 0644 ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

CONFFILES_${PN} += '${@ " ".join( [ ( "${sysconfdir}/opkg/%s-feed.conf" % feed ) for feed in "${FEEDS}".split() ] ) }'
