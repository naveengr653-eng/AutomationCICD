package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
	static LocalDateTime now = LocalDateTime.now();
	static String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	
	public static ExtentReports getReportObj(String Browser) {
		
		
		String ReportPath=System.getProperty("user.dir")+"//Reports//Report_"+" "+timestamp+".html";
		ExtentSparkReporter Reporter= new ExtentSparkReporter(ReportPath);
		Reporter.config().setReportName("Test Ecom Appliaction");		
		Reporter.config().setDocumentTitle("Report Test Naveen");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(Reporter);
		extent.setSystemInfo("Browser", Browser);
		return extent;
		
	}

}
