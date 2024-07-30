import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (isContactPresent()) {
            driver.findElement(By.linkText("add new")).click();
            // Заполняем фио
            driver.findElement(By.name("firstname")).click();
            driver.findElement(By.name("firstname")).sendKeys("firstname");
            driver.findElement(By.name("middlename")).click();
            driver.findElement(By.name("middlename")).sendKeys("middlename");
            driver.findElement(By.name("lastname")).click();
            driver.findElement(By.name("lastname")).sendKeys("lastname");
            driver.findElement(By.name("nickname")).click();
            driver.findElement(By.name("nickname")).sendKeys("nickname");
            // Заполняем e-mail
            driver.findElement(By.name("email")).click();
            driver.findElement(By.name("email")).sendKeys("email");
            driver.findElement(By.name("email2")).click();
            driver.findElement(By.name("email2")).sendKeys("email2");
            driver.findElement(By.name("email3")).click();
            driver.findElement(By.name("email3")).sendKeys("email3");
            // Заполняем Адрес
            driver.findElement(By.name("address")).click();
            driver.findElement(By.name("address")).sendKeys("address");
            // Заполняем Телефоны
            driver.findElement(By.name("home")).click();
            driver.findElement(By.name("home")).sendKeys("home_tel");
            driver.findElement(By.name("mobile")).click();
            driver.findElement(By.name("mobile")).sendKeys("mobile_tel");
            driver.findElement(By.name("work")).click();
            driver.findElement(By.name("work")).sendKeys("work_tel");
            driver.findElement(By.name("fax")).click();
            driver.findElement(By.name("fax")).sendKeys("fax");
            // Заполняем День рождения
            driver.findElement(By.name("bday")).click();
            {
                WebElement dropdown = driver.findElement(By.name("bday"));
                dropdown.findElement(By.xpath("//option[. = '1']")).click();
            }
            driver.findElement(By.name("bmonth")).click();
            {
                WebElement dropdown = driver.findElement(By.name("bmonth"));
                dropdown.findElement(By.xpath("//option[. = 'January']")).click();
            }
            driver.findElement(By.name("byear")).click();
            driver.findElement(By.name("byear")).sendKeys("2001");
            driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        }
        removeContact();
    }

}
