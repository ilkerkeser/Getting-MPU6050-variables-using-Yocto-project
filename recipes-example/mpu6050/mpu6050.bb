SUMMARY = "Getting MPU6050 values using Yocto"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

#Source file destination
SRC_URI = "file://mpu6050.c"

# Set S to WORKDIR since no unpacked directory is created
S = "${WORKDIR}/build"

#Compiling process
do_compile(){
    ${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/mpu6050.c -o mpu6050
}

#Installing process
do_install(){
    #create /usr/bin
    install -d ${D}${bindir}
    #Copying executed file to /usr/bin and let it launch
    install -m 0755 ${S}/mpu6050 ${D}${bindir}
}

# * **Fetch** (do_fetch) :   Fetches the source code
# * **Unpack** (do_upack) : Unpacks the source code into a working directory
# * **Patch** (do_patch) : Locates patch files and applies them to the source code
# * **Configure** (do_configure) : Configures the source by enabling and disabling any build-time and configuration options for the software being built.
# * **Compile** (do_compile) : Compiles the source in the compilation directory
# * **Install** (do_install) : Copies files from the compilation directory to a holding area