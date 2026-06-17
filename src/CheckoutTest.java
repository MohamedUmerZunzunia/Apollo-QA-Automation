import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class CheckoutTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.manage().window().maximize();

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(20));

            driver.get("https://practicesoftwaretesting.com");

            // Open Combination Pliers
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[contains(text(),'Combination Pliers')]")
            )).click();

            System.out.println("Combination Pliers page opened");

            // Add To Cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(.,'Add to cart')]")
            )).click();

            System.out.println("Added to cart");

            Thread.sleep(2000);

            // Open Cart
            WebElement cartIcon = driver.findElement(
                    By.xpath("//span[text()='1']")
            );

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", cartIcon);

            System.out.println("Cart opened");

            // Checkout
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[contains(text(),'Proceed to checkout')]")
            )).click();

            System.out.println("Checkout page opened");

            // Login
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("email")
            )).sendKeys("test123@gmail.com");

            driver.findElement(By.id("password"))
                    .sendKeys("Test@123098");

            driver.findElement(
                    By.xpath("//input[@value='Login' or @type='submit'] | //button[@type='submit']")
            ).click();

            System.out.println("Login successful");

            Thread.sleep(1000);

            // Proceed to checkout after login
            WebElement checkoutBtn = driver.findElement(
                    By.cssSelector("button.btn.btn-success")
            );

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", checkoutBtn);

            System.out.println("Second checkout clicked");

            Thread.sleep(2000);

            // House Number
            WebElement houseNo = driver.findElement(
                    By.xpath("//input[@placeholder='e.g. 42 *']")
            );

            houseNo.clear();
            houseNo.sendKeys("42");

            System.out.println("House number entered");

            Thread.sleep(3000);

            // Proceed to checkout after address
            WebElement addressCheckout = driver.findElement(
                    By.xpath("//button[contains(text(),'Proceed to checkout')]")
            );

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", addressCheckout);

            System.out.println("Moved to payment page");
            // Wait a bit after payment page loads
            Thread.sleep(2000);

            // Locate payment dropdown by ID
            WebElement paymentDropdown =
                    driver.findElement(By.id("payment-method"));

            // Create Select object
            Select payment = new Select(paymentDropdown);

            // Select Cash on Delivery
            payment.selectByValue("cash-on-delivery");

            System.out.println("Cash on Delivery selected");

            Thread.sleep(2000);

            // Click Confirm
            WebElement confirmBtn =
                    driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", confirmBtn);

            System.out.println("Order confirmed");}
        catch (Exception e) {
            e.printStackTrace();
        }

        // driver.quit();
    }
}