SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_FEATURES += "splash"
IMAGE_FEATURES += "ssh-server-dropbear"
IMAGE_FEATURES += "tools-debug"

IMAGE_INSTALL:append = " picocom "
IMAGE_INSTALL:append = " libftdi "
IMAGE_INSTALL:append = " usbutils "
IMAGE_INSTALL:append = " util-linux "
IMAGE_INSTALL:append = " util-linux-libuuid "
IMAGE_INSTALL:append = " busybox "
IMAGE_INSTALL:append = " ntp "

LICENSE = "MIT"

inherit core-image features_check

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"
