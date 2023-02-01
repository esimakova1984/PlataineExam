package tests;

import models.User;
import models.UserFirstLoginForm;
import org.testng.Assert;
import org.testng.annotations.Test;


     public class LoginE2E extends TestBase{

        User user1 = User.builder()
                .organization("ekaterina1")
                .userName("admin6")
                .password("Qwerty123")
                .build();
         User user2 = User.builder()
                 .organization("ekaterina2")
                 .userName("admin5")
                 .password("Qwerty123")
                 .build();

        UserFirstLoginForm userFirstLoginForm = UserFirstLoginForm.builder()
                .firstName("Katya")
                .lastName("Sim")
                .password("A12345a")
                .confirmPassword("A12345a")
                .build();


        @Test
        public void loginE2Etest(){
            logger.info("The test starts e2e test");
            app.getHelperLogin().signIn(user1);
            logger.info("The login form is filled with data: " + user1);
            Assert.assertTrue(app.getHelperLogin().isSignInSiccess());
            logger.info("The First Login form is opened");
            app.getHelperLogin().fillFirstLoginForm(userFirstLoginForm);
            logger.info("The First Login form is filled with data: " + userFirstLoginForm + ". Predefined views page is opened.");
            app.getHelperLogin().logOut();
            logger.info("The user logged out");
            Assert.assertTrue(app.getHelperLogin().isOrganizationfieldPresent());
            logger.info("The Login form for new organization is opened");
            app.getHelperLogin().signIn(user2);
            logger.info("The login form is filled with data: " + user2);
            Assert.assertTrue(app.getHelperLogin().isSignInSiccess());
            logger.info("The First Login form is opened");
            app.getHelperLogin().fillFirstLoginForm(userFirstLoginForm);
            logger.info("The First Login form is filled with data: " + userFirstLoginForm + ". Predefined views page is opened.");
            logger.info("Test passed successfully");

        }








    }

