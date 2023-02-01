package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithWrongCredentials extends TestBase {

    @Test
    public void LoginWithEmptyOrganizationField(){
        logger.info("The test starts login with empty organization field");
        app.getHelperLogin().fillLoginForm("", "admin", "Qwerty123");
        logger.info("The login form is filled except organization field");
        Assert.assertTrue(app.getHelperLogin().isErrorImageDispalyed());
        logger.info("The error image is displayed");
        logger.info("Test passed successfully");
    }

    @Test
    public void LoginWithEmptyUserNameField(){
        logger.info("The test starts login with empty user name field");
        app.getHelperLogin().fillLoginForm("ekaterina1", " ", "Qwerty123");
        logger.info("The login form is filled except user name field");
        Assert.assertTrue(app.getHelperLogin().isErrorImageDispalyed());
        logger.info("The error image is displayed");
        logger.info("Test passed successfully");
    }

    @Test
   public void LoginWithEmptyPasswordField(){
        logger.info("The test starts login with empty password field");
        app.getHelperLogin().fillLoginForm("ekaterina1", "admin", " ");
        logger.info("The login form is filled except password field");
        Assert.assertTrue(app.getHelperLogin().isErrorImageDispalyed());
        logger.info("The error image is displayed");
        logger.info("Test passed successfully");
    }

    @Test
    public void LoginWithWrongPassword(){
        logger.info("The test starts login with wrong password");
        app.getHelperLogin().fillLoginForm("ekaterina12", "admin", "123");
        logger.info("The login form is filled with valid data and wrong password");
        Assert.assertTrue(app.getHelperLogin().isErroeMessageDispalyed());
        logger.info("The error message is displayed");
        logger.info("Test passed successfully");
    }

    @Test
    public void LoginWithWrongUserName(){
        logger.info("The test starts login with wrong password");
        app.getHelperLogin().fillLoginForm("ekaterina2", "adin", "123");
        logger.info("The login form is filled with valid data and wrong user name");
        Assert.assertTrue(app.getHelperLogin().isErroeMessageDispalyed());
        logger.info("The error message is displayed");
        logger.info("Test passed successfully");

    }
    @Test
    public void LoginWithWrongOrganization(){
        logger.info("The test starts login with wrong password");
        app.getHelperLogin().fillLoginForm("ekaterina342", "admin", "123");
        logger.info("The login form is filled with valid data and wrong organization");
        Assert.assertTrue(app.getHelperLogin().isErroeMessageDispalyed());
        logger.info("The error message is displayed");
        logger.info("Test passed successfully");
    }

    @Test
    public void LoginWithUnauthorizedUser(){
        logger.info("The test starts login with unauthorized user");
        app.getHelperLogin().fillLoginForm("simakova", "katya", "Qwerty123");
        logger.info("The login form is filled with unauthorized user valid data");
        Assert.assertTrue(app.getHelperLogin().isErroeMessageDispalyed());
        logger.info("The error message is displayed");
        logger.info("Test passed successfully");
    }

}
