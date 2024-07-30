package manager;

import model.ContactData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    protected static WebDriver driver;

    public void init() {
        if (driver == null) {
            driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1552, 840));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void createContact(ContactData contact) {
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        driver.findElement(By.name("nickname")).click();
        driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(contact.email());
        driver.findElement(By.name("email2")).click();
        driver.findElement(By.name("email2")).sendKeys(contact.email2());
        driver.findElement(By.name("email3")).click();
        driver.findElement(By.name("email3")).sendKeys(contact.email3());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(contact.address());
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys(contact.home_tel());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys(contact.mobile_tel());
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("work")).sendKeys(contact.work_tel());
        driver.findElement(By.name("fax")).click();
        driver.findElement(By.name("fax")).sendKeys(contact.fax());
        driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.day() + "']")).click();
        }
        driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = '" + contact.month() + "']")).click();
        }
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).sendKeys(contact.year());
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }

    public boolean isContactPresent() {
        return !isElementPresent(By.xpath("//table[@id=\'maintable\']/tbody/tr[2]/td/input"));
    }

    public void removeContact() {
        driver.findElement(By.linkText("home")).click();
        driver.findElement(By.xpath("//table[@id=\'maintable\']/tbody/tr[2]/td/input")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }
}
