import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectedShopHomePage {
    private WebDriver driver;
    @FindBy(xpath = "//title")
    private WebElement title;
    //подключаем конструктор
    public ConnectedShopHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTitle() {
        return title.getText();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
