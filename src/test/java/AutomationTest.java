import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AutomationTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the OrangeHRM demo site
            driver.get("https://opensource-demo.orangehrmlive.com/");

            // Define locators
            By usernameLocator = By.xpath("//input[@name='username']");
            By passwordLocator = By.xpath("//input[@name='password']");
            By loginButtonLocator = By.xpath("//button[contains(@class, 'orangehrm-login-button')]");
            By adminSidebarLocator = By.xpath("//ul/li/a/span[text()='Admin']");
//            By selectElementLoacator = By.xpath("//div[@class='oxd-select-text-input' and text()='-- Select --'])[1]");
            By selectFirstLocator = By.xpath("//div[contains(@class,'oxd-grid-item') and div/div/label[text()='User Role']]//div[@class='oxd-select-text-input']");
            // By selectFirstLocator = By.xpath("(//div[@class='oxd-select-text-input' and text()='-- Select --'])[1]");
//            By adminSelectLocator = By.xpath("//div[@class='oxd-select-text-input' and text()='Admin']");
            By adminSelectLocator = By.xpath("//div[contains(@class, 'oxd-input-group') and .//label[text()='User Role']]//div[contains(@class, 'oxd-select-text') and .//div[text()='Admin']]");


            By ESSLocator = By.xpath("//div[@class='oxd-select-text-input' and text()='ESS']");
            // Wait for the username field to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));

            // Perform login
            WebElement usernameField = driver.findElement(usernameLocator);
            WebElement passwordField = driver.findElement(passwordLocator);
            WebElement loginButton = driver.findElement(loginButtonLocator);

            usernameField.sendKeys("Admin");
            passwordField.sendKeys("admin123");
            loginButton.click();

            // Wait for the Admin sidebar to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(adminSidebarLocator));

            // Click the Admin menu
            WebElement adminSidebar = driver.findElement(adminSidebarLocator);
            adminSidebar.click();
            WebElement Select = driver.findElement(selectFirstLocator);
            Select.click();
            WebElement AdminBtn = driver.findElement(adminSelectLocator);
            AdminBtn.click();
            WebElement ESSBtn = driver.findElement(ESSLocator);
            ESSBtn.click();
            // Pause to observe the result (optional, for debugging only)
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {


        }
    }
}
