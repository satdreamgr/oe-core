SUMMARY = "ISO 8601 date/time parser"
DESCRIPTION = "This module implements ISO 8601 date, time and duration parsing. The implementation follows ISO8601:2004 standard, and implements only date/time representations mentioned in the standard. If something is not mentioned there, then it is treated as non existent, and not as an allowed option."
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://setup.py;md5=a3690c6598d9f9f3a8b3c7145275b2bc;beginline=1;endline=26"

inherit pypi setuptools

PACKAGES = "${PN}"

SRC_URI[md5sum] = "0e1203fce27ce65e2d01c5f21c4d428f"
SRC_URI[sha256sum] = "2e364a3d5759479cdb2d37cce6b9376ea504db2ff90252a2e5b7cc89cc9ff2d8"

BBCLASSEXTEND = "native nativesdk"
