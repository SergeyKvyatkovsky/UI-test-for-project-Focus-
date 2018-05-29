package Core;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener{

    WebDriver driver=null;
    //String filePath = ".//Files//Screenshots//";
    String filePath = ".//Files//Screenshots//";


    //@Step("Test fail")
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("[Error] "+iTestResult.getName()+" test has failed *****");
        String methodName = iTestResult.getName().toString().trim();
        //takeScreenshot(methodName);
        takeScreenshot(iTestResult);
    }

    public void takeScreenshot(String methodName){
        driver = ITest.driver;

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot(ITestResult result){
        //Object currentClass = result.getInstance();
        driver = ITest.driver;
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    public void onTestStart(ITestResult iTestResult) {

    }


    public void onTestSuccess(ITestResult iTestResult) {

    }





    public void onTestSkipped(ITestResult iTestResult) {

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


    public void onStart(ITestContext iTestContext) {

    }


    public void onFinish(ITestContext iTestContext) {

    }
}
