package com.epoint.android.customui.listview;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class FileListView extends ListView {
	protected Context con;
	protected String pathname;
	protected String root;

	protected List<FileInfo> fileInfos = null;
	protected List<Map<String, Object>> mdata = null;

	protected Bitmap fileIcon;
	protected Bitmap folderIcon;
	protected Bitmap back2ParentIcon;

	public FileListView(Context context, String pathname) {
		super(context);
		this.con = context;// 特别注意这边的上下文
		this.root = this.pathname = pathname;
		fileInfos = listFileInfos(pathname);

		try {
			fileIcon = BitmapFactory.decodeStream(this.con.getAssets().open(
					"file32x32.png"));
			folderIcon = BitmapFactory.decodeStream(this.con.getAssets().open(
					"folder32x32.png"));
			back2ParentIcon = BitmapFactory.decodeStream(this.con.getAssets()
					.open("parent32x32.png"));
		} catch (IOException e) {
			Toast.makeText(con, e.toString(), Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		// Display all files under root.
		setAdapter(new FileListAdp(con, dealFileInfos(fileInfos)));

		setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				OnItemClickProcess(arg0, arg1, arg2, arg3);
			}
		});
	}

	public List<Map<String, Object>> dealFileInfos(List<FileInfo> fileInfos) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < fileInfos.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", fileInfos.get(i).filename);
			map.put("isParent", fileInfos.get(i).isParent);
			map.put("isFile", fileInfos.get(i).isFile);
			list.add(map);
		}
		return list;
	}

	protected void OnItemClickProcess(AdapterView<?> listView, View item,
			int position, long time) {
		FileInfo fileInfo = fileInfos.get(position);

		if (!fileInfo.isFile) {
			if ("..".equals(fileInfo.filename)) {
				pathname = pathname.substring(0, pathname.lastIndexOf('/'));
			} else {
				pathname += "/" + fileInfo.filename;

			}
			fileInfos = listFileInfos(pathname);
			if (!root.equals(pathname)) {
				fileInfos.add(0, new FileInfo("..", 0, false, true));
			}
			setAdapter(new FileListAdp(con, dealFileInfos(fileInfos)));
		}
	}

	protected List<FileInfo> listFileInfos(String pathname) {
		File parent = new File(pathname);
		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		for (File file : parent.listFiles()) {
			fileInfos
					.add(new FileInfo(file.getName(), 0, file.isFile(), false));
		}
		Collections.sort(fileInfos);
		return fileInfos;
	}

	public void refresh() {
		fileInfos = listFileInfos(pathname);
		setAdapter(new FileListAdp(con, dealFileInfos(fileInfos)));
	}

	public String getCurrentDirectory() {
		return pathname;
	}

	public void setRoot(String root) {
		this.root = root;
	}

}
