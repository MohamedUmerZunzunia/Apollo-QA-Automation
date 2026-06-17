import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practicesoftwaretesting.com/auth/register");

        Thread.sleep(2000);

        driver.findElement(By.id("first_name")).sendKeys("Umar");
        driver.findElement(By.id("last_name")).sendKeys("Zunzunia");

        driver.findElement(By.id("dob")).sendKeys("2004-01-15");

        driver.findElement(By.id("street")).sendKeys("Ebert Wall");
        driver.findElement(By.id("postal_code")).sendKeys("1234");
        driver.findElement(By.id("house_number")).sendKeys("12");
        driver.findElement(By.id("city")).sendKeys("Hamilchester");
        driver.findElement(By.id("state")).sendKeys("Rhode Island");
        driver.findElement(By.id("country")).sendKeys("Aland Islands");

        driver.findElement(By.id("phone")).sendKeys("37064360360");

        driver.findElement(By.id("email")).sendKeys("test123@gmail.com");

        driver.findElement(By.id("password")).sendKeys("Test@123098");

        driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();

        Thread.sleep(3000);

        System.out.println("Registration Test Executed");

        driver.quit();
    }
}