package manager;

import models.User;
import models.UserFirstLoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperLogin extends HelperBase{

    String organization = "OrgIDInput";
    String userName = "UserNameInput";
    String password = "PasswordInput";
    String loginBtn = "login";
    String userMenu = "//*[@class='pl pl-profile pointer']";
    String errorImage = "//*[@class='popover-target']";
    String errorMessage = "//*[text()='The login details you provided are incorrect.']";
    String firsName = "FirstNameInput";
    String lastName = "LastNameInput";
    String dropDown1 = "//form/div[4]/div/div[1]/span/div/div";
    String selectMenu = "//*[@class='css-15k3avv pl-select__menu']";
    String report = "//*[text()='Report']";
    String dropDowm2 = "//form/div[4]/div/div[2]/span";
    String alertedRolls = "//*[text()='Alerted Rolls']";
    String confirmPassword = "ConfirmPasswordInput";
    String submitBtn = "//*[@id='registerSubmit']";
    String logout = "//*[text()='Log Out']";
    String firstLoginForm = "//*[@class='register-body-inline']";

    public HelperLogin(WebDriver driver) {
        super(driver);
    }

    public void signIn(User user) {
        type(By.id(organization), user.getOrganization());
        type(By.id(userName), user.getUserName());
        type(By.id(password), user.getPassword());
        click(By.id(loginBtn));
    }

    public boolean isLoginSuccess() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(userMenu)))).isDisplayed();
    }

    public void fillLoginForm(String org, String user, String pass) {
        type(By.id(organization), org);
        type(By.id(userName), user);
        type(By.id(password), pass);
        click(By.id(loginBtn));
    }

    public boolean isErrorImageDispalyed() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(errorImage)))).isDisplayed();
    }

    public boolean isErroeMessageDispalyed() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(errorMessage)),
                                "The login details you provided are incorrect."));
    }

    public void fillFirstLoginForm(UserFirstLoginForm required) {
        type(By.id(firsName), required.getFirstName());
        type(By.id(lastName), required.getLastName());
        click(By.xpath(dropDown1));
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(selectMenu)));
        click(By.xpath(report));
        click(By.xpath(dropDowm2));
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(selectMenu)));
        click(By.xpath(alertedRolls));
        type(By.id(password), required.getPassword());
        type(By.id(confirmPassword), required.getConfirmPassword());
        click(By.xpath(submitBtn));

    }

    public void logOut() {
        click(By.xpath(userMenu));
        click(By.xpath(logout));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(String.format("window.localStorage.clear();"));
        driver.navigate().refresh();
    }

    public boolean isSignInSiccess() {
        return new WebDriverWait(driver,  10)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(firstLoginForm))))
                .isDisplayed();
    }

    public boolean isOrganizationfieldPresent() {
        return new WebDriverWait(driver,  10)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id(organization))))
                .isDisplayed();
    }
}
