package com.shangyao.screenshot;

import java.io.BufferedReader;

public class ScreenshotByPhantomjs {
	private static final String _shellCommand = "D:/tt/phantomjs-2.1.1-windows/bin/phantomjs D:/tt/phantomjs-2.1.1-windows/bin/rasterize.js ";

	private String _fileName;
	private String _size;

	/**
	 * 构造截图类
	 * 
	 * @parm hash 用于临时文件的目录唯一化
	 */
	public ScreenshotByPhantomjs(String fileName) {
		_fileName = fileName;
	}

	/**
	 * 构造截图类
	 * 
	 * @parm hash 用于临时文件的目录唯一化
	 * @param size
	 *            图片的大小，如800px*600px（此时高度会裁切），或800px（此时 高度最少=宽度*9/16，高度不裁切）
	 */
	public ScreenshotByPhantomjs(String fileName, String size) {
		this(fileName);
		if (size != null)
			_size = " " + size;
	}

	public void printurl(String url) {
		if (exeCmd(_shellCommand + url + " " + _fileName + (_size != null ? _size : ""))) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	/**
	 * 执行CMD命令
	 */
	private static boolean exeCmd(String commandStr) {
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec(commandStr);
			if (p.waitFor() != 0 && p.exitValue() == 1) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}