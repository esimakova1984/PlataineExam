package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithValidCredentials extends TestBase{

    User user1 = User.builder()
            .organization("ekaterina1")
            .userName("admin5")
            .password("A12345a")
            .build();

   @Test
    public void RegisteredLoginWithCorrectCredentials(){
       logger.info("The test starts positive login with valid registered data");
       app.getHelperLogin().signIn(user1);
       logger.info("The login form is filled with data: " + user1);
       Assert.assertTrue(app.getHelperLogin().isLoginSuccess());
       logger.info("Test passed successfully");
   }
}
