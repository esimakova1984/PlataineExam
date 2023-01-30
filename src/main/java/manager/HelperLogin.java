package manager;

import models.User;
import models.UserRegistrationRequired;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperLogin extends HelperBase{



    public HelperLogin(WebDriver driver) {
        super(driver);
    }

    public void signIn(User user) {
        type(By.id("OrgIDInput"), user.getOrganization());
        type(By.id("UserNameInput"), user.getUserName());
        type(By.id("PasswordInput"), user.getPassword());
        click(By.id("login"));
    }


    public boolean isLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='register-body-inline']"))));
        return driver.findElement(By.xpath("//*[@class='register-body-inline']")).isDisplayed();
    }




    public void fillLoginForm(String organization, String userName, String password) {
        type(By.id("OrgIDInput"), organization);
        type(By.id("UserNameInput"), userName);
        type(By.id("PasswordInput"), password);
        click(By.id("login"));

    }

    public boolean isErrorImageDispalyed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='popover-target']"))));
        return driver.findElement(By.xpath("//*[@class='popover-target']")).isDisplayed();
    }

    public boolean isErroeMessageDispalyed() {
        Boolean errorText = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[text()='The login details you provided are incorrect.']")), "The login details you provided are incorrect."));
        return errorText;
    }

    public void fillRegistrationForm(UserRegistrationRequired required) {
        type(By.id("FirstNameInput"), required.getFirstName());
        type(By.id("LastNameInput"), required.getLastName());
        click(By.xpath("//form/div[4]/div/div[1]/span/div/div"));
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='css-15k3avv pl-select__menu']")));
        click(By.xpath("//*[text()='Report']"));
        click(By.xpath("//form/div[4]/div/div[2]/span"));
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='css-15k3avv pl-select__menu']")));
        click(By.xpath("//*[text()='Alerted Rolls']"));
        type(By.id("PasswordInput"), required.getPassword());
        type(By.id("ConfirmPasswordInput"), required.getConfirmPassword());
        //click(By.xpath("//*[@id='registerSubmit']"));
    }

    public void logOut() {
        click(By.xpath("//*[@class='pl pl-profile pointer']"));
        click(By.xpath("//*[text()='Log Out']"));


    }
}
