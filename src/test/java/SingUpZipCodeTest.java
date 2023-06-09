import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SingUpTest extends BaseTest {
    @Test
    public void zipCodeShouldAccept5Digits() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("12345");

        driver.findElement(By.cssSelector("[value=Continue]")).click();

        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        assertTrue(isDisplayed, "Нужная страница не открылась");

    }
}

