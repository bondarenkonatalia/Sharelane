import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SingUpRegisterTest extends BaseTest{
    @Test
    public void  registrationUserWithValidData(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");
        driver.findElement(By.name("first_name")).sendKeys("Ivan");
        driver.findElement(By.name("last_name")).sendKeys("Petrov");
        driver.findElement(By.name("email")).sendKeys("petrov@mail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        boolean confirMessage = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();

        assertTrue(confirMessage,"Пользователь не перешёл на страницу confirmation_message");

    }

}
