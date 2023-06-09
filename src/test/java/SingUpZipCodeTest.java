import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SingUpZipCodeTest extends BaseTest {

    @Test
    public void zipCodeShouldAccept5Digits() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).sendKeys(Keys.ENTER);
        boolean isDisplayed = driver.findElement(By.cssSelector("[value= Register]")).isDisplayed();

        assertTrue(isDisplayed, "Нужная страница не открылась");
    }

    @Test
    public void afterEnteringZip_codePageUsingEnterButton() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();

        assertTrue(isDisplayed, "Нужная страница не открылась");
    }

        @Test
    public void zipCodeShouldAccept4Digits() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessege = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(errorMessege, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");

    }

    @Test
    public void leaveZip_codeFieldEmpty() {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessege = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(errorMessege, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterLatinLettersZip_codeField() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("abcde");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessege = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(errorMessege, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterCyrillicLettersZip_codeField() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("абвгд");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessege = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(errorMessege, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterNumbersZip_codeFieldWithSpace() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1234 ");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessege = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(errorMessege, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterNumbersWithSymbolsZip_codeField() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1%3*4");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessege = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(errorMessege, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterTextZip_codeField() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("Вы посещали эту страницу несколько раз");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessege = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(errorMessege, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }

    @Test
    public void zipCodeShouldAccept6Digits() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String errorMessege = driver.findElement(By.cssSelector("[class=error_message]")).getText();

        assertEquals(errorMessege, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }

}
