package manager;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    WebDriver driver;
    HelperLogin helperLogin;

    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://iot-staging.plataine.com/#/Login");
        helperLogin = new HelperLogin(driver);
    }

    public void stop(){
       driver.quit();
    }

    public HelperLogin getHelperLogin() {
        return helperLogin;
    }
}
