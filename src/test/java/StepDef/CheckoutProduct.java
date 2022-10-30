package StepDef;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CheckoutProduct {

    WebDriver driver;

    @Given("user open the app")
    public void userOpenTheApp() throws Exception {
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

    @When("user select Sauce Lab Back Packs on product page")
    public void userSelectSauceLabBackPacksOnProductPage() {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Sauce Lab Back Packs\"]")).click();
    }

    @And("user select color blue")
    public void userSelectColorBlue() {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0, 1000);");
        driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays available colors of selected product\"]/android.view.ViewGroup[2]")).get(1).click();
    }

    @And("user increase quantity")
    public void userIncreaseQuantity() {
        driver.findElement(By.id("plusIV")).click();
    }

    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.id("cartBt")).click();
    }

    @And("user click shopping cart button")
    public void userClickShoppingCartButton() {
        driver.findElement(By.id("cartIV")).click();
    }

    @And("user see the detail product checkout")
    public void userSeeTheDetailProductCheckout() {
        driver.findElement(By.id("productTV")).getText();
        driver.findElement(By.id("titleTV")).getText();
        driver.findElement(By.id("noTV")).getText();
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("cartBt")).click();
    }

    @And("user add username and password")
    public void userAddUsernameAndPassword() {
        driver.findElement(By.id("nameET")).sendKeys("bod@example.com");
        driver.findElement(By.id("passwordET")).sendKeys("10203040");
    }

    @Then("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("loginBtn")).click();
    }
}
