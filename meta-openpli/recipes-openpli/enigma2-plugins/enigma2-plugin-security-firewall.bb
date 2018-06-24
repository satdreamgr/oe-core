DESCRIPTION = "Firewall"

require conf/license/openpli-gplv2.inc

RDEPENDS_${PN} = "iptables kernel-module-ip-tables kernel-module-ip-conntrack kernel-module-ipt-reject kernel-module-ipt-state kernel-module-iptable-filter"

SRC_URI = "file://firewall.sh file://firewall.users"

PV = "1.0"

S = "${WORKDIR}"

INITSCRIPT_NAME = "firewall"
INITSCRIPT_PARAMS = "defaults"

inherit update-rc.d allarch

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/firewall.sh ${D}${sysconfdir}/init.d/firewall
	install -d ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/firewall.users ${D}${sysconfdir}/firewall.users
}
