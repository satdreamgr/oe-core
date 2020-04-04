BBCLASSEXTEND = "native"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI_append = " \
    file://input_for_hbbtv.patch \
"

EXTRA_OECONF_append = "\
    --with-inputdrivers=linuxinput \
    --disable-video4linux \
    --without-tools \
"

#EXTRA_DIRECTFB ?= "empty"
#EXTRA_DIRECTFB_vusolo4k = "vuplus"
#EXTRA_DIRECTFB_vuultimo4k = "vuplus"
#EXTRA_DIRECTFB_vuuno4k = "vuplus"
#EXTRA_DIRECTFB_vuuno4kse = "vuplus"
#EXTRA_DIRECTFB_vuzero4k = "vuplus"
#
#EXTRA_DIRECTFB_sf4008 = "octagon"
#
#require directfb-${EXTRA_DIRECTFB}_1.7.7.inc
