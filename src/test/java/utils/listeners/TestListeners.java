
package utils.listeners;


import com.aventstack.extentreports.Status;


import lombok.extern.slf4j.Slf4j;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.extentreports.ExtentManager;
import utils.extentreports.ExtentTestManager;





@Slf4j
public class TestListeners implements ITestListener {


    public void onStart(ITestContext context) {
        log.info("*** Test Suite " + context.getName() + " started ***");
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName());
        ExtentTestManager.getTest().assignCategory(iTestResult.getMethod().getGroups());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed").assignCategory(iTestResult.getMethod().getGroups());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        // attach screenshots to report
        if (ExtentTestManager.getTest() == null) {
            ExtentTestManager.startTest(iTestResult.getMethod().getMethodName());
        }

        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed:" + iTestResult.getThrowable().toString());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //Do tier down operations for ExtentReports reporting!
        log.info(("*** Test Suite " + iTestContext.getName() + " ending ***"));
        ExtentManager.extentReports.flush();

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //ExtentReports log operation for skipped tests.
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped" + iTestResult.getThrowable().toString())
                .assignCategory(iTestResult.getMethod().getGroups());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }




}
