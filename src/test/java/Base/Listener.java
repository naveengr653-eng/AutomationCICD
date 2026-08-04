package Base;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;

import Utils.ExtentReportUtil;
import Utils.ScreenShotUtil;

public class Listener extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReportUtil.getReportObj(BaseTest.browser);
	ThreadLocal<ExtentTest> extendTest=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
	    // not implemented
		test = extent.createTest(result.getMethod().getMethodName());
		extendTest.set(test);
	  }

	@Override 
	public void onTestSuccess(ITestResult result) {
	    // not implemented
		extendTest.get().log(Status.PASS, "Test Pass");
	  }

	@Override
	public void onTestFailure(ITestResult result) {
	    // not implemented
		extendTest.get().fail(result.getThrowable());
		//get path of screenshot
		String filePath = null;
		try {
			WebDriver driver = (WebDriver) result.getTestClass()
	                .getRealClass()
	                .getField("driver")
	                .get(result.getInstance());
			filePath = ScreenShotUtil.TakeScreenshot(result.getMethod().getMethodName(),driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		extendTest.get().addScreenCaptureFromPath( filePath, result.getMethod().getMethodName());
	  }
	
	@Override
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	
	@Override
	public void onFinish(ITestContext context) {
		    // not implemented
		extent.flush();
		  }  
	  
//	ExtentReports extent = ExtentReportUtil.getReportObj(browser);
//	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
//
//	@Override
//	public void onTestStart(ITestResult result) {
//	    ExtentTest test = extent.createTest(result.getMethod().getMethodName());
//	    extentTest.set(test);
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//	    extentTest.get().log(Status.PASS, "Test Passed");
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//	    extentTest.get().fail(result.getThrowable());
//
//	    try {
//	        Field field = result.getTestClass().getRealClass().getField("driver");
//	        WebDriver driver = (WebDriver) field.get(result.getInstance());
//
//	        String filePath = ScreenShotUtil.TakeScreenshot(
//	                result.getMethod().getMethodName(), driver);
//
//	        extentTest.get().addScreenCaptureFromPath(filePath);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//	    extent.flush();
//	}

}
