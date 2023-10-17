import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Header {
    private WebDriver driver;

    @FindBy(how = How.CSS, using = ".Header__LogoImage.Header__LogoImage--primary")
    private WebElement logoImage;
    @FindBy(className = "HorizontalList")
    private WebElement horizontalList;


    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getHorizontalList() {
        return horizontalList;
    }
    public void testLogoImage() {
        //WebElement logoImage = driver.findElement(By.cssSelector(".Header__LogoImage.Header__LogoImage--primary"));
        String srcValue = logoImage.getAttribute("src");
        System.out.println("Logo Image Source: " + srcValue);

    }

    public void testMainManu() {


        List<WebElement> listItems = horizontalList.findElements(By.tagName("li"));

        if (!listItems.isEmpty()) {
            for (WebElement listItem : listItems) {
                WebElement link = listItem.findElement(By.tagName("a"));
                String linkText = link.getText();
                System.out.println("Link Text: " + linkText);
            }
        } else {
            System.out.println("No list items found on the page.");
        }
        int numberOfLiElements = listItems.size();
        System.out.println("Number of <li> elements: " + numberOfLiElements);

    }
}