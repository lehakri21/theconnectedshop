import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OpenHomePage {
    @Test
    public void openSite() {
        DriverInstall  initializer = new DriverInstall();
        WebDriver driver = initializer.initializeDriver();

        //System.setProperty("webdriver.chrome.driver","/src/driver/chromedriver");
        // Создаем экземпляр WebDriver для управления браузером Chrome.
        //WebDriver driver = new ChromeDriver();
       // driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(800, 600));
        // Открываем страницу "https://theconnectedshop.com/"
        //driver.get("https://theconnectedshop.com/");


        // Закрываем браузер после выполнения теста./
        // Получение заголовка страницы
        String actualTitle = driver.getTitle();


        // Ожидаемое значение заголовка
        String expectedTitle = "The Connected Shop - Smart Objects, Connected Devices and IoT Gadgets";
        // Сравнение полученного заголовка с ожидаемым
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Заголовок страницы совпадает с ожидаемым.");
        } else {
            System.out.println("Заголовок страницы НЕ совпадает с ожидаемым.");
            System.out.println("Actual Title:" + actualTitle);

        }
        // Получение текущего URL страницы
        String currentURL = driver.getCurrentUrl();

        // Ожидаемый URL
        String expectedURL = "https://theconnectedshop.com/";

        // Сравнение текущего URL с ожидаемым
        if (currentURL.equals(expectedURL)) {
            System.out.println("Текущий URL совпадает с ожидаемым.");
        } else {
            System.out.println("Текущий URL НЕ совпадает с ожидаемым.");
            System.out.println("Actual Url:" + currentURL);
        }
        //WebElement headerWrapper = driver.findElement(By.cssSelector(".Header__Wrapper"));
        //WebElement headerWrapper = driver.findElement(By.xpath("//div[contains(@class, " + "'Header__Wrapper')]//div[contains(@class, 'Header__FlexItem') and contains(@class, 'Header__FlexItem--fill')]"));
        //headerWrapper.isDisplayed();
        // Поиск батьківського елемента <div class="Header__Wrapper">
        WebElement headerWrapper = driver.findElement(By.cssSelector("div.Header__Wrapper"));

        // Пошук піделементів всередині батьківського елемента <div class="Header__Wrapper">
        WebElement flexItemFill = headerWrapper.findElement(By.cssSelector("div.Header__FlexItem.Header__FlexItem--fill"));
        WebElement flexItemLogo = headerWrapper.findElement(By.cssSelector("div.Header__FlexItem.Header__FlexItem--logo"));


// Перевірка наявності елементів всередині батьківського елемента
        //Assert.assertTrue(flexItemFill.isDisplayed(), "Елемент з класом \"Header__FlexItem--fill\" не знайдений.");
        //Assert.assertTrue(flexItemLogo.isDisplayed(), "Елемент з класом \"Header__FlexItem--logo\" не знайдений.");
        if (flexItemFill != null) {
            if (flexItemFill.isDisplayed()) {
                System.out.println("Елемент з класом \"Header__FlexItem--fill\" знайдений і відображається.");
            } else {
                System.out.println("Елемент з класом \"Header__FlexItem--fill\" знайдений, але не відображається.");
            }
        } else {
            System.out.println("Елемент з класом \"Header__FlexItem--fill\" не знайдений.");
        }
        if (flexItemLogo != null) {
            if (flexItemLogo.isDisplayed()) {
                System.out.println("Елемент з класом \"Header__FlexItem--Logo\" знайдений і відображається.");
            } else {
                System.out.println("Елемент з класом \"Header__FlexItem--Logo\" знайдений, але не відображається.");
            }
            System.out.println("Елемент з класом \"Header__FlexItem--Logo\" не знайдений.");
        }
        WebElement logoImage = driver.findElement(By.cssSelector(".Header__LogoImage.Header__LogoImage--primary"));
        String srcValue = logoImage.getAttribute("src");
        System.out.println("Logo Image Source: " + srcValue);
        driver.quit();
    }
    @Test
    public void testLogoImage() {
        DriverInstall  initializer = new DriverInstall();
        WebDriver driver = initializer.initializeDriver();
        //String baseUrl = "https://theconnectedshop.com";
        //driver.get(baseUrl + "/");
        WebElement logoImage = driver.findElement(By.cssSelector(".Header__LogoImage.Header__LogoImage--primary"));
        String srcValue = logoImage.getAttribute("src");
        System.out.println("Logo Image Source: " + srcValue);
        // You can add assertions or other verifications here
        initializer.quitDriver();


    }
    @Test
    public void testMainManu() {
        DriverInstall  initializer = new DriverInstall();
        WebDriver driver = initializer.initializeDriver();
        //driver.get("https://theconnectedshop.com");
        WebElement horizontalList = driver.findElement(By.className("HorizontalList"));
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
        initializer.quitDriver();
    }
    @Test
    public void mainManu(){
        DriverInstall  initializer = new DriverInstall();
        WebDriver driver = initializer.initializeDriver();
        driver.findElement(By.cssSelector("button.NewsletterPopup__Close")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[contains(text(), \"NEW IN\")]")).click();
        System.out.println("Link is opened");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Label: collections
        driver.findElement(By.xpath("//header/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")).click();
        System.out.println("Link is opened");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Label: personal
        driver.findElement(By.xpath("//a[contains(text(),'Personal')]")).click();
        System.out.println("Link is opened");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        initializer.quitDriver();//gi


    }

}








