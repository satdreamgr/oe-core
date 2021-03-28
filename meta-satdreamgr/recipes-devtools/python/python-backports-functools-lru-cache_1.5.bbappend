do_install_append() {
	# python-lzma already provides __init__.py(o) files
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/backports/__init__.py*
}
