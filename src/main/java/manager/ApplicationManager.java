package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    HelperLogin helperLogin;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init(){
        driver = new ChromeDriver();
        logger.info("All tests start with Chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://iot-staging.plataine.com/#/Login");
        helperLogin = new HelperLogin(driver);
    }

    public void stop(){
       //driver.quit();

    }

    public HelperLogin getHelperLogin() {
        return helperLogin;
    }

}
