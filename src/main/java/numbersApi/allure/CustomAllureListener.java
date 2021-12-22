package numbersApi.allure;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import numbersApi.parallel_run.BrowserFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class CustomAllureListener implements ITestListener {

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot(){
        return ((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "DOM", type = "text/html", fileExtension = "html")
    public String htmlSource(){
        return BrowserFactory.getDriver().getPageSource();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES)));
        Allure.addAttachment("HTML", BrowserFactory.getDriver().getPageSource());
        System.out.println("Test Success"+"\r\n");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
        ITestListener.super.onTestFailure(result);
    }
}