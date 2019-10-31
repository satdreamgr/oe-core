##################
### SatDreamGR ###
##################

require ../../../meta-openpli/recipes-openpli/images/openpli-enigma2-image.bb

#PR = "r20180111"
#PR = "r${DATE}"
#PR[vardepsexclude] = "DATE"

ENIGMA2_PLUGINS_remove = "enigma2-plugin-softcams-oscam"

IMAGE_INSTALL_remove = "openpli-bootlogo"
IMAGE_INSTALL_remove = "enigma2-plugin-extensions-ppanel"
IMAGE_INSTALL_remove = "enigma2-plugin-softcams-oscam"
IMAGE_INSTALL_remove = "3rd-party-feed-configs"

IMAGE_INSTALL += " \
	${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbs", "enigma2-plugin-systemplugins-blindscan" , "", d)} \
	dabstreamer \
	enigma2-plugin-extensions-backupsuite \
	enigma2-plugin-extensions-devicemanager \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-foreca \
	enigma2-plugin-extensions-greeknetradio \
	enigma2-plugin-extensions-greekstreamtv \
	enigma2-plugin-extensions-sdgradio \
	enigma2-plugin-extensions-xmltvimport-greekepg \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-skins-satdreamgr-hd-transpba \
	enigma2-plugin-systemplugins-mphelp \
	glibc-gconv-iso8859-7 \
	glibc-gconv-utf-16 \
	livestreamersrv \
	rtl8192eu \
	satdreamgr-bootlogo \
	satdreamgr-extra-feed-configs \
	satdreamgr-panel \
	softcam-support \
"

DEPENDS += " \
	${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbs", "enigma2-plugin-systemplugins-satscan" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "chromiumos", "enigma2-plugin-extensions-chromium", "", d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'kodi', 'enigma2-plugin-extensions-kodi', '', d)} \
	${@bb.utils.contains('OPENPLI_FEATURES', 'kodi', 'enigma2-plugin-extensions-kodi', '', d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "webkithbbtv", "enigma2-plugin-extensions-webkithbbtv", "", d)} \
	${@bb.utils.contains('TARGET_FPU', 'soft', '', 'nodejs', d)} \
	\
	astra-sm \
	bluez-hidd \
	ccextractor \
	dreambox-buildimage \
	dvb-apps \
	dvb-usb-drivers-meta \
	dvblast \
	dvbsnoop \
	edid-decode \
	enigma2-plugin-extensions-bitrate \
	enigma2-plugin-extensions-blackoutblind \
	enigma2-plugin-extensions-btdevicesmanager \
	enigma2-plugin-extensions-dlnaserver \
	enigma2-plugin-extensions-e2iplayer \
	enigma2-plugin-extensions-hdmitest \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-lcd4linux \
	enigma2-plugin-extensions-openmultiboot \
	enigma2-plugin-extensions-oscamstatus \
	enigma2-plugin-extensions-permanentvfdclock \
	enigma2-plugin-extensions-ppanel \
	enigma2-plugin-extensions-subssupport \
	enigma2-plugin-extensions-tmbd \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-skins-glamouraurafhd \
	enigma2-plugin-skins-octagoneightfhd \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-pli-hd-fullnight \
	enigma2-plugin-skins-satdreamgr-hd \
	enigma2-plugin-skins-simple-gray-hd \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugin-systemplugins-crossepg \
	enigma2-plugin-systemplugins-quadpip \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugins \
	eti-tools \
	evtest \
	exteplayer3 \
	gstplayer \
	htop \
	inadyn-mt \
	iptables \
	iw \
	libcec \
	ltrace \
	megatools \
	meta-enigma2-dvdburn \
	minisatip \
	net-tools \
	ntp \
	oe-satipclient \
	ofgwrite \
	openvpn \
	p7zip \
	pcsc-lite \
	pointercal \
	python-bluetool \
	python-cfscrape \
	python-dbus \
	python-js2py \
	python-mechanize \
	python-pycrypto \
	python-pycurl \
	python-pyexecjs \
	python-tcpbridge \
	redsea \
	rt8812au \
	rt8814au \
	rtl-sdr \
	satipclient \
	softcams-enigma2-meta \
	strace \
	tcpdump \
	tsduck \
	tsniv2ni \
	v4l-utils \
	udpxy \
	wscan \
"
