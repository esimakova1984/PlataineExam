package tests;

import models.User;
import models.UserRegistrationRequired;
import org.testng.Assert;
import org.testng.annotations.Test;


import models.User;
import models.UserRegistrationRequired;
import org.testng.annotations.Test;

     public class LoginE2E extends TestBase{

        User user1 = User.builder()
                .organization("ekaterina2")
                .userName("admin3")
                .password("Qwerty123")
                .build();

        UserRegistrationRequired required = UserRegistrationRequired.builder()
                .firstName("Katya")
                .lastName("Sim")
                .password("A12345a")
                .confirmPassword("A12345a")
                .build();


        @Test
        public void loginE2Etest(){
            app.getHelperLogin().signIn(user1);
            app.getHelperLogin().fillRegistrationForm(required);
            //app.getHelperLogin().logOut();
        }

//    @AfterMethod
//    public void postCondition(){
//        if(app.getHelperLogin().isLoginSuccess()){
//            app.getHelperLogin().fillRegistrationForm(required);
//        }else {
//            app.getHelperLogin().logOut();
//        }
//    }





    }

