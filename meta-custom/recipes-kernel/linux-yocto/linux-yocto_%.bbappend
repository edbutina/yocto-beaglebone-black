FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-add-uart4-dtsi-2.patch"
SRC_URI += "file://modem.cfg"

do_configure:append(){
    cat ${WORKDIR}/*.cfg >> ${B}/.config
}
