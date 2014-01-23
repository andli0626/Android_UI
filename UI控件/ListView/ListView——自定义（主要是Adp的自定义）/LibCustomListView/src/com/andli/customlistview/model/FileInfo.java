package com.andli.customlistview.model;


public class FileInfo implements Comparable<FileInfo> {
	public final String filename;
	public final long size;
	public final boolean isFile;
	public final boolean isParent;

	public FileInfo(String filename, long size, boolean isFile,
			boolean isParent) {
		this.filename = filename;
		this.size = size;
		this.isFile = isFile;
		this.isParent = isParent;
	}

	public int compareTo(FileInfo other) {
		if (isParent) {
			return 1;
		}
		if (isFile) {
			return other.isFile ? 0 : 1;
		} else {
			return other.isFile ? -1 : 0;
		}
	}
}