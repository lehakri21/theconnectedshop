import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class RegistrationSteps {
    private final   WebDriver driver = new ChromeDriver();
    private SignUp signUp;
    @Given("I am on the registration page")
    public void iAmOnRegistrationPage() {
        driver.get("https://theconnectedshop.com/account/register");
        signUp = new SignUp(driver);
    }

    @When("I enter the following details:")
    public void iEnterDetails(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        signUp.enterFirstName(data.get("First Name"));
        signUp.enterLastName(data.get("Last Name"));
        signUp.enterEmail(data.get("Email"));
        signUp.enterPassword(data.get("Password"));

    }
    @And("I click on the Register button")
    public void click_registerButton(){
        signUp.clickRegisterButton();
    }
    @Then("Model windows is display")
        public void modelWindowsDisplay(){
        signUp.modelWindowsDisplay();


        }
        @Then("It is displayed error validation that email is unique")
       public void validation_email_Is_Unique(){
            signUp.checkErrorAlertMessage();
        }
        @Then("It is displayed error validation that password is invalid")
        public void it_is_displayed_error_validation_that_password_is_invalid() throws InterruptedException {
            Thread.sleep(7000);
        signUp.alertPasswordInvalid();
        }

}

