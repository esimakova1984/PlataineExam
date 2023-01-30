package tests;


import models.User;
import models.UserRegistrationRequired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithValidCredentials extends TestBase{

    User user1 = User.builder()
            .organization("ekaterina2")
            .userName("admin3")
            .password("Qwerty123")
            .build();

   @Test
    public void loginWithCorrectCredentials(){
       app.getHelperLogin().signIn(user1);
       Assert.assertTrue(app.getHelperLogin().isLoginSuccess());
   }
}
