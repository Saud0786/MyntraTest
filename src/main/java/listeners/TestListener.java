package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;
import utils.ScreenShotUtils;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution Started");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
        //testpass me throwable nahi likhte hai
      //test.pass(result.getThrowable());
        
        
        try {
        	ScreenShotUtils ss = new ScreenShotUtils();
        	String path = ss.captureScreenShot(result.getName());
               
        	test.addScreenCaptureFromPath(path);
        }catch(Exception e) {
                  e.printStackTrace();
        
        
        System.out.println("Test Passed: " + result.getName());
    }
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed");
        test.fail(result.getThrowable());

        try {
            ScreenShotUtils ss = new ScreenShotUtils();
            String path = ss.captureScreenShot(result.getName());

            // attach screenshot in report
            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // IMPORTANT
        System.out.println("Execution Finished");
    }
}