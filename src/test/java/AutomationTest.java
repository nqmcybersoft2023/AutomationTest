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

            // Pause to observe the result (optional, for debugging only)
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {


        }
    }
}
