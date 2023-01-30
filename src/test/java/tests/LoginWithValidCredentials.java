package tests;


import models.User;
import models.UserRegistrationRequired;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWithValidCredentials extends TestBase{

    User user1 = User.builder()
            .organization("ekaterina2")
            .userName("admin1")
            .password("Qwerty123")
            .build();

    UserRegistrationRequired required = UserRegistrationRequired.builder()
            .firstName("Katya")
            .lastName("Sim")
            .password("A12345a")
            .confirmPassword("A12345a")
            .build();

    @BeforeMethod
    public void precondition(){
        if(app.getHelperLogin().isLoginSuccess()){
            app.getHelperLogin().fillRegistrationForm(required);
        }
        app.getHelperLogin().logOut();


    }



   @Test
    public void loginWithCorrectCredentials(){
       app.getHelperLogin().signIn(user1);
       Assert.assertTrue(app.getHelperLogin().isLoginSuccess());
   }





}
