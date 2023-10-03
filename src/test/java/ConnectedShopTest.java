import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ConnectedShopTest {
    private WebDriver driver;
    private ConnectedShopHomePage homePage;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        homePage = new ConnectedShopHomePage(driver);
    }

    @Test
    public void testConnectedShopMainPage() {
        driver.get("https://theconnectedshop.com");


        String expectedTitle = "The Connected Shop - Smart Locks, Smart Sensors, Smart Home &amp; Office";
        String actualTitle = homePage.getTitle();
        assertEquals(expectedTitle, actualTitle);

        String expectedUrl = "https://theconnectedshop.com/";
        String actualUrl = homePage.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}