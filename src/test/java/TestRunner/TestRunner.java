package TestRunner;

import io.appium.java_client.AppiumDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
        glue= {"StepDef"},
        plugin ={"pretty","json:target/cucumber.json"})

public class TestRunner {

    static AppiumDriver driver;

    public static void main(String[] args) {
        try {
            openTheApp();
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void openTheApp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName",  "SM-A530F");
        caps.setCapability("udid", "52007f9fea0825eb");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9");

        caps.setCapability("appPackage", "com.saucelabs.mydemoapp.android");
        caps.setCapability("appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url, caps);
        System.out.println("Application started");
    }
}
