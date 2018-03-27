package com.shangyao.screenshot;

/**
 * 
 * @description
 * @author shangyao
 * @date 2018年3月27日
 */
public class Test {

	public static void main(String[] args) {
		String url = "https://www.zappos.com/p/nike-cotton-cushion-crew-with-moisture-management-3-pair-pack-black-white/product/8068305/color/151";
		String fileName = "D:/zappos.jpg";
		// ScreenshotByDJNSwing
		ScreenshotByDJNSwing.printUrlScreen2jpg(fileName, url, 1000, 1000);
		// ScreenshotByRobot
		ScreenshotByRobot.run(url, fileName);
		// ScreenshotByPhantomjs
		ScreenshotByPhantomjs screenshotByPhantomjs = new ScreenshotByPhantomjs(fileName, "1000*1000");
		screenshotByPhantomjs.printurl(url);
	}

}
