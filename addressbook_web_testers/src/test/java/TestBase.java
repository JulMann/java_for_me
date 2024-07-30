import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected static WebDriver driver;

    protected static void createContact(
            String firstname, String middlename, String lastname, String nickname,
            String email, String email2, String email3,
            String address,
            String home_tel, String mobile_tel, String work_tel, String fax,
            String day, String month, String year
            ) {
        driver.findElement(By.linkText("add new")).click();
        // Заполняем фио
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).sendKeys(middlename);
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("nickname")).click();
        driver.findElement(By.name("nickname")).sendKeys(nickname);
        // Заполняем e-mail
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("email2")).click();
        driver.findElement(By.name("email2")).sendKeys(email2);
        driver.findElement(By.name("email3")).click();
        driver.findElement(By.name("email3")).sendKeys(email3);
        // Заполняем Адрес
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(address);
        // Заполняем Телефоны
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys(home_tel);
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys(mobile_tel);
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("work")).sendKeys(work_tel);
        driver.findElement(By.name("fax")).click();
        driver.findElement(By.name("fax")).sendKeys(fax);
        // Заполняем День рождения
        driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath(day)).click();
        }
        driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath(month)).click();
        }
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).sendKeys(year);
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }

    protected static void removalContact() {
        driver.findElement(By.linkText("home")).click();
        driver.findElement(By.xpath("//table[@id=\'maintable\']/tbody/tr[2]/td/input")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
    }

    @BeforeEach
    public void setUp() {
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

    protected boolean isContactPresent() {
        return !isElementPresent(By.xpath("//table[@id=\'maintable\']/tbody/tr[2]/td/input"));
    }
}
