import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practicesoftwaretesting.com/auth/login");

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("test123@gmail.com");

        driver.findElement(By.id("password")).sendKeys("Test@123098");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(3000);

        System.out.println("Login Test Executed Successfully");

        driver.quit();
    }
}