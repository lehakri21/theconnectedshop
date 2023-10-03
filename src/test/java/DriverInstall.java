import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverInstall {
    private WebDriver driver;
    public WebDriver initializeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://theconnectedshop.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}