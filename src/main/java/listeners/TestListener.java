package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.ScreenshotUtil;
import baseclass.Base;

public class TestListener extends Base implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String path = ScreenshotUtil.captureScreenshot(driver, testName);

        System.out.println("❌ Test Failed: " + testName);
        System.out.println("📸 Screenshot saved at: " + path);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("▶ Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("✔ Test Execution Completed");
    }
}
