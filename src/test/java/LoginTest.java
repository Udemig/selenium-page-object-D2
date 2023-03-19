import Pages.AccountPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class LoginTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.get("https://parabank.parasoft.com");
        driver.manage().window().maximize();
    }

    @Test
    public void TC0001(){
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("Test")
                .passwordDoldur("Test123456")
                .login();
        accountPage
                .accountSayfaKontrolu("Accounts Overview");
    }

    @Test
    public void TC0002(){
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("")
                .passwordDoldur("Test123456")
                .login()
                .errorKontrolu("Please enter a username and password.");
    }

    @Test
    public void TC0003(){
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("Test")
                .passwordDoldur("")
                .login()
                .errorKontrolu("Please enter a username and password.");
    }
    @Test
    public void TC0004(){

        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("")
                .passwordDoldur("")
                .login();
        accountPage
                .accountSayfaKontrolu("Accounts Overview");
    }
    @Test
        public void TC0005() {
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);

        homePage
                .userNameDoldur("")
                .passwordDoldur("")
                .login()
                .errorKontrolu("Please enter a username and password.");

        }

    @AfterTest
    public void afterDown(){
        //driver.quit();
    }
}
