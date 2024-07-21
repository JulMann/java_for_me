import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ContactRemovalTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1552, 840));
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//form[@id=\'LoginForm\']/input[3]")).click();

    }

    @AfterEach
    public void tearDown() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test
    public void canRemoveContact() {
        driver.findElement(By.linkText("home")).click();
        if (!isElementPresent(By.xpath("//table[@id=\'maintable\']/tbody/tr[2]/td/input"))) {
            driver.findElement(By.linkText("add new")).click();
            driver.findElement(By.name("firstname")).click();
            driver.findElement(By.name("firstname")).sendKeys("First_name_contact");
            driver.findElement(By.name("lastname")).click();
            driver.findElement(By.name("lastname")).sendKeys("Last_Name_contact");
            driver.findElement(By.name("address")).click();
            driver.findElement(By.name("address")).click();
            driver.findElement(By.name("address")).sendKeys("Address_contact");
            driver.findElement(By.name("home")).click();
            driver.findElement(By.name("home")).sendKeys("Telephone_home_contact");
            driver.findElement(By.name("mobile")).click();
            driver.findElement(By.name("mobile")).sendKeys("Telephone_mobile_contact");
            driver.findElement(By.name("email")).click();
            driver.findElement(By.name("email")).sendKeys("e-mail1_contact");
            driver.findElement(By.name("email2")).click();
            driver.findElement(By.name("email2")).sendKeys("e-mail2_contact");
            driver.findElement(By.name("home")).click();
            driver.findElement(By.name("home")).sendKeys("Telephone_home_contact");
            driver.findElement(By.name("mobile")).click();
            driver.findElement(By.name("mobile")).sendKeys("Telephone_mobile_contact");
            driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        }
        driver.findElement(By.linkText("home")).click();
        driver.findElement(By.xpath("//table[@id=\'maintable\']/tbody/tr[2]/td/input")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();

    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
