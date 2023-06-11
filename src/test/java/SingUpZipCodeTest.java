import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SingUpZipCodeTest extends BaseTest {

    String URL = "https://www.sharelane.com/cgi-bin/register.py";
    String ZipCodeInputLocator = "zip_code";
    String ContinueButtonLocator = "[value=Continue]";
    String ErrorMessageLocator = "[class=error_message]";

    @Test
    public void afterEnteringZip_codePageUsingEnterButton() {

        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).sendKeys(Keys.ENTER);
        boolean isDisplayed = driver.findElement(By.cssSelector("[value= Register]")).isDisplayed();

        assertTrue(isDisplayed, "Нужная страница не открылась");
    }

    @Test
    public void PageUsingEnterButton() {

        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("12345");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).click();
        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();

        assertTrue(isDisplayed, "Нужная страница не открылась");
    }

        @Test
    public void zipCodeShouldAccept4Digits() {

        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("1234");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).click();
        String errorMessage = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");

    }

    @Test
    public void leaveZip_codeFieldEmpty() {
        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).click();
        String errorMessage = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterLatinLettersZip_codeField() {

        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("abcde");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).click();
        String errorMessage = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterCyrillicLettersZip_codeField() {

        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("абвгд");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).click();
        String errorMessage = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterNumbersZip_codeFieldWithSpace() {

        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("1234 ");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).click();
        String errorMessage = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterNumbersWithSymbolsZip_codeField() {

        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("1%3*4");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).click();
        String errorMessage = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }
    @Test
    public void enterTextZip_codeField() {

        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("Вы посещали эту страницу несколько раз");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).click();
        String errorMessage = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }

   /* @Test
    public void zipCodeShouldAccept6Digits() {

        driver.get(URL);
        driver.findElement(By.name(ZipCodeInputLocator)).sendKeys("123456");
        driver.findElement(By.cssSelector(ContinueButtonLocator)).click();
        String errorMessage = driver.findElement(By.cssSelector(ErrorMessageLocator)).getText();

        assertEquals(errorMessage, "Oops, error on page. ZIP code should have 5 digits",
                "Текст сообщения не совпадает");
    }*/

}
