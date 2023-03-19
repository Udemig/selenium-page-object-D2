package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver =  driver;
    }

    public HomePage userNameDoldur(String text){
        driver.findElement(By.name("username")).sendKeys(text);
        return this;
    }

    public HomePage passwordDoldur(String pass){
        driver.findElement(By.name("password")).sendKeys(pass);
        return this;
    }

    public HomePage login(){
        driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(5) > input")).click();
        return this;
    }

    public HomePage errorKontrolu(String text){
        String value =  driver.findElement(By.cssSelector("#rightPanel > p")).getText();
        Assert.assertEquals(text, value);
        return this;
    }

}
