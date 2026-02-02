package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.HtmlReportUtil;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) { }

    @Override
    public void onFinish(ITestContext context) { }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        HtmlReportUtil.generateReport("<p style='color:green;'>PASSED: " + result.getName() + "</p>");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), result.getName());
        HtmlReportUtil.generateReport("<p style='color:red;'>FAILED: " + result.getName() +
                " <a href='screenshots/" + result.getName() + ".png'>Screenshot</a></p>");
    }
}
