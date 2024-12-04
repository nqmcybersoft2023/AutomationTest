import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AutomationTest2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the OrangeHRM demo site
            driver.get("https://opensource-demo.orangehrmlive.com/");

            // Define locators
            By usernameLocator = By.xpath("//input[@name='username']");
            By passwordLocator = By.xpath("//input[@name='password']");
            By loginButtonLocator = By.xpath("//button[contains(@class, 'orangehrm-login-button')]");
            By adminSidebarLocator = By.xpath("//ul/li/a/span[text()='Admin']");
            By PIMSidebarLocator = By.xpath("//ul/li/a/span[text()='PIM']");
            By leaveSidebarLocator = By.xpath("//ul/li/a/span[text()='Leave']");
            By employeeNameLocator = By.xpath("//div/input[@placeholder='Type for hints...']");
            By addBtnLocator = By.xpath("//button[contains(., 'Add')]"); // Sửa lỗi cú pháp

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

            // Wait for the PIM sidebar to be visible and click it
            wait.until(ExpectedConditions.visibilityOfElementLocated(PIMSidebarLocator));
            driver.findElement(PIMSidebarLocator).click();

            // Wait for the Leave sidebar to be visible and click it
            wait.until(ExpectedConditions.visibilityOfElementLocated(leaveSidebarLocator));
            driver.findElement(leaveSidebarLocator).click();

            // Quay về thanh sidebar Admin và click
            wait.until(ExpectedConditions.visibilityOfElementLocated(adminSidebarLocator));
            driver.findElement(adminSidebarLocator).click();

            // Click vào ô input Employee Name
            wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameLocator));
            WebElement employeeName = driver.findElement(employeeNameLocator);
            employeeName.click();

//            // 21 Wait for the Add button to be visible and click it
//            wait.until(ExpectedConditions.visibilityOfElementLocated(addBtnLocator));
//            WebElement addButton = driver.findElement(addBtnLocator);
//            addButton.click(); // Nhấp vào nút Add

            // Pause to observe the result (optional, for debugging only)
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
