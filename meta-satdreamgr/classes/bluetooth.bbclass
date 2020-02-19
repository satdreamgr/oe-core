# compatibility need to remove the inherit and use directly bluez5
#BLUEZ ?= "${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', bb.utils.contains('DISTRO_FEATURES', 'bluez5', 'bluez5', 'bluez4', d), '', d)}"
BLUEZ ?= "${@bb.utils.contains('DISTRO_FEATURES', 'bluetooth', 'bluez5', '', d)}"
