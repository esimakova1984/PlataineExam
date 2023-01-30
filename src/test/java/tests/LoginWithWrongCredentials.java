package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithWrongCredentials extends TestBase {

    @Test
    public void LoginWithEmptyOrganizationField(){
        app.getHelperLogin().fillLoginForm("", "admin", "Qwerty123");
        Assert.assertTrue(app.getHelperLogin().isErrorImageDispalyed());
    }
    @Test
    public void LoginWithEmptyUserNameField(){
        app.getHelperLogin().fillLoginForm("ekaterina1", " ", "Qwerty123");
        Assert.assertTrue(app.getHelperLogin().isErrorImageDispalyed());
    }
    @Test
   public void LoginWithEmptyPasswordField(){
        app.getHelperLogin().fillLoginForm("ekaterina1", "admin", " ");
       Assert.assertTrue(app.getHelperLogin().isErrorImageDispalyed());
    }

    @Test
    public void LoginWithWrongPassword(){
        app.getHelperLogin().fillLoginForm("ekaterina12", "admin", "123");
        Assert.assertTrue(app.getHelperLogin().isErroeMessageDispalyed());

    }

    @Test
    public void LoginWithWrongUserName(){
        app.getHelperLogin().fillLoginForm("ekaterina2", "adin", "123");
        Assert.assertTrue(app.getHelperLogin().isErroeMessageDispalyed());

    }
    @Test
    public void LoginWithWrongOrganization(){
        app.getHelperLogin().fillLoginForm("ekaterina342", "admin", "123");
        Assert.assertTrue(app.getHelperLogin().isErroeMessageDispalyed());
    }

    @Test
    public void LoginWithUnauthorizedUser(){
        app.getHelperLogin().fillLoginForm("simakova", "katya", "Qwerty123");
        Assert.assertTrue(app.getHelperLogin().isErroeMessageDispalyed());
    }





}
