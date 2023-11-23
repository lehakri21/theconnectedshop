import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ConnectedShopTest {
    private WebDriver driver;
    private ConnectedShopHomePage homePage;
    private Header header;
//    homePage = new ConnectedShopHomePage(driver);
//    header = new Header(driver);




    @Given("I open on theconnectedshop.com homepage")
    public void i_open_on_theconnectedshop_com_homepage() {
        driver = new ChromeDriver();
        homePage = new ConnectedShopHomePage(driver);
        header = new Header(driver);
        driver.manage().window().maximize();
        driver.get("https://theconnectedshop.com");
    }

    @Then("I check Title")
    public void i_check_the_Title() {
        String expectedTitle = "The Connected Shop - Smart Locks, Smart Sensors, Smart Home & Office";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);


    }
    @And("I check qurrent url")
        public void i_check_qurrent_url() {
        String expectedUrl = "https://theconnectedshop.com/";
        String actualUrl = homePage.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
//
//


    }

    @Then("I check the logo")
    public void i_check_the_logo() {
        header.testLogoImage();
    }
    @Then("I check main manu")
    public void i_check_main_manu() {
        header.testMainManu();
    }
    @And("Close browser")
       public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}