package Utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {
	
	static LocalDateTime now = LocalDateTime.now();
	static String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

	public static String TakeScreenshot(String TCname,WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourse = ts.getScreenshotAs(OutputType.FILE);
		String ScreenShotstrotePath=System.getProperty("user.dir")+"//ScreenShots//"+TCname+" "+timestamp+".png";
		File dest=new File(ScreenShotstrotePath);
		FileUtils.copyFile(sourse, dest);
		return ScreenShotstrotePath;
		
	}
	
}
