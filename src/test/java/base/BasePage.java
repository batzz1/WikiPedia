package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    public AppiumServiceBuilder appiumServiceBuilder;
    public AppiumDriverLocalService appiumDriverLocalService;
    public static AppiumDriver<MobileElement> driver;
    public Properties properties = new Properties();
    public InputStream inputStream;


    public void startServer(){
        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withIPAddress("127.0.0.1");
        appiumServiceBuilder.usingPort(4723);
        appiumServiceBuilder.withCapabilities(desiredCapabilities);
        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);

        appiumDriverLocalService.start();
    }

    public void stopServer() {
        appiumDriverLocalService.stop();
    }


    @BeforeSuite
    public AppiumDriver<MobileElement> getDriver() {
        startServer();
        setupDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private void setupDriver() {
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,getPropertyValue("APP_ACTIVITY"));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,getPropertyValue("APP_PACKAGE"));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
      //  desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"AUTOMATION_NAME");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,false);
        driver = new AndroidDriver<MobileElement>(appiumDriverLocalService.getUrl(),desiredCapabilities);

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        stopServer();
    }

    public String getPropertyValue(String property) {
        try {
            inputStream = new FileInputStream("property/config.properties");
            properties.load(inputStream);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }
}
