import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AutomationTest2 {
    private static final String URL = "https://opensource-demo.orangehrmlive.com/";
    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the OrangeHRM demo site
            driver.get(URL);

            // Define locators
            By usernameLocator = By.xpath("//input[@name='username']");
            By passwordLocator = By.xpath("//input[@name='password']");
            By loginButtonLocator = By.xpath("//button[contains(@class, 'orangehrm-login-button')]");
            By adminSidebarLocator = By.xpath("//ul/li/a/span[text()='Admin']");
            By PIMSidebarLocator = By.xpath("//ul/li/a/span[text()='PIM']");
            By leaveSidebarLocator = By.xpath("//ul/li/a/span[text()='Leave']");
            By employeeNameLocator = By.xpath("//div/input[@placeholder='Type for hints...']");
            By resetBtnLocator = By.xpath("//button[contains(., 'Reset')]");
            By searchBtnLocator = By.xpath("//button[contains(., 'Search')]");
            By userManagementLocator = By.xpath("//span[contains(text(), 'User Management')]");

            By selectFirstLocator = By.xpath("//div[contains(@class,'oxd-grid-item') and div/div/label[text()='User Role']]//div[@class='oxd-select-text-input']");
            // By selectFirstLocator = By.xpath("(//div[@class='oxd-select-text-input' and text()='-- Select --'])[1]");
//          By adminSelectLocator = By.xpath("//div[@class='oxd-select-text-input' and text()='Admin']");
//          By adminSelectLocator = By.xpath("//div[contains(@class, 'oxd-input-group') and .//label[text()='User Role']]//div[contains(@class, 'oxd-select-text') and .//div[text()='Admin']]");
//
//          By ESSLocator = By.xpath("//div[contains(@class, 'oxd-input-group') and .//label[text()='User Role']]//div[contains(@class, 'oxd-select-text') and .//div[text()='ESS']]");
            By selectSecondLocaltor = By.xpath("//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters') and div/div/label[text()='Status']]//div[@class='oxd-select-text-input']");
            By AddBtnLocator = By.xpath("//button[i[contains(@class, 'bi-plus')]]");
            By usernameInputLocaltor = By.xpath("//label[text()='Username']/following::input[1]");




            // Wait for the username field to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));

            // Perform login with delay
            performActionWithDelay(() -> driver.findElement(usernameLocator).sendKeys(USERNAME));
            performActionWithDelay(() -> driver.findElement(passwordLocator).sendKeys(PASSWORD));
            performActionWithDelay(() -> driver.findElement(loginButtonLocator).click());

            // Navigate through the sidebar with delay
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(PIMSidebarLocator)).click());
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(leaveSidebarLocator)).click());
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(adminSidebarLocator)).click());
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputLocaltor)).click());

            // Click on User Management with delay
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(userManagementLocator)).click());

            // Click on selectFirstLocator with delay
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(selectFirstLocator)).click());

// Click on

//// Click on Admin option from the dropdown
//            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(adminSelectLocator)).click());
//
//// Click on ESS option from the dropdown
//            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(ESSLocator)).click());

            // Click Reset button with delay
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(resetBtnLocator)).click());

            // Click on the Employee Name input with delay
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameLocator)).click());
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtnLocator)).click());

            // Click on selectSecondtLocator with delay
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(selectSecondLocaltor)).click());

            // Click on AddBtn with delay
            performActionWithDelay(() -> wait.until(ExpectedConditions.visibilityOfElementLocated(AddBtnLocator)).click());

            // Find and click the user name element with delay
            WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Admin_proba1']")));
            performActionWithDelay(userNameElement::click);

            // Highlight the text using JavaScript
            String highlightScript = "arguments[0].style.backgroundColor = 'yellow';";
            ((JavascriptExecutor) driver).executeScript(highlightScript, userNameElement);

            // Optional: Pause to observe the highlight
            Thread.sleep(2000); // Consider removing this in production code

        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("Operation timed out: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error occurred while performing action: " + e.getMessage());
        } finally {
            // Close the browser

        }
    }

    // Helper method to perform an action with a 2-second delay
    private static void performActionWithDelay(Runnable action) {
        try {
            Thread.sleep(2000); // Delay for 2 seconds
            action.run(); // Execute the action
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}

