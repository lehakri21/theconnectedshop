import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class SignUp {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "customer[first_name]")
    private WebElement firstNameInput;


    @FindBy(name = "customer[last_name]")
    private WebElement lastNameInput;

    @FindBy(name = "customer[email]")
    private WebElement emailInput;

    @FindBy(name = "customer[password]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Create my account']")
    private WebElement registerButton;

    @FindBy(id = "id=identity-verification-code")
    private WebElement verificationCode;

    @FindBy(className = "Alert__ErrorItem")
            private WebElement errorAlertElement;

    public SignUp(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);

    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);

    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);

    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);

    }
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void clickRegisterButton() {
        registerButton.isDisplayed();
        registerButton.isEnabled();
        registerButton.click();
    }
    public void modelWindowsDisplay(){
        verificationCode.isDisplayed();

    }
    public void checkErrorAlertMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorAlertElement));
        String actualMessage = errorAlertElement.getText();
        String expectedMessage = ("This email address is already associated with an account. If this account is yours, you can ");
        Assert.assertEquals("Error message doesn't match", expectedMessage, actualMessage);
    }
    public void alertPasswordInvalid() {
        wait.until(ExpectedConditions.visibilityOf(errorAlertElement));
        String actualMessage = errorAlertElement.getText();
        String expectedMessage = ("password is too short (minimum is 5 characters)");
        Assert.assertEquals("Error message doesn't match", expectedMessage, actualMessage);
    }

}



