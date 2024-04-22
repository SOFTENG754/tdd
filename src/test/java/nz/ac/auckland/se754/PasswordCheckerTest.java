package nz.ac.auckland.se754;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * USER STORY:
 * <p>
 * As a user, I am required to enter a strong password when creating my account.
 * <p>
 * ACCEPTANCE CRITERIA
 * <p>
 * - Each acceptance criterion should be independently testable
 * <p>
 * - Each acceptance criterion test should have a clear pass/fail result
 * <p>
 * -  Acceptance criteria should be focused on the end result (functionality), not the mechanism
 * through which it is achieved
 * <p>
 * Requirements of password
 * <p>
 * Must have at least 8 characters
 *
 * cannot contain the name of the user
 * <p>
 * ACs * <p> - A user should be able to set a password of at least 8 characters [POSITIVE]
 * <p>
 * - A user should not be able to set a password of less than 8 characters [NEGATIVE]
 * <p>
 * .....
 */
public class PasswordCheckerTest {

    @Test
    public void When_PasswordLessThan8chars_Expect_Invalid(){
       //ARRANGE
        User user = new User();
        PasswordChecker checker = new PasswordChecker(user);
        String pwd = "234";
        // ACT
        boolean result = checker.isValid(pwd);
        // ASSERT
        assertFalse(result);
    }

    @Test
    public void When_Password8orMoreChars_Expect_Valid(){
        User user = new User();
        PasswordChecker checker = new PasswordChecker(user);
        String pwd = "123456789";

        boolean result = checker.isValid(pwd);

        assertTrue(result);
    }


    @Test
    public void When_PwdContainsUser_Expect_Invalid(){
        User user = new User();
        user.setName("Valerio");
        PasswordChecker checker = new PasswordChecker(user);
        String pwd = "Valerio123";
        boolean result = checker.isValid(pwd);
        assertFalse(result);
    }

    @Test
    public void When_PwdDoesNotContainsUser_Expect_Valid(){
        User user = new User();
        user.setName("Valerio");
        PasswordChecker checker = new PasswordChecker(user);
        String pwd = "bob12345678";
        boolean result = checker.isValid(pwd);
        assertTrue(result);
    }

   // Passwords cannot be identical to any of the previous three passwords.
        @Test
        public void When_PwdSameAsPreviousOne_Expect_Invalid(){
            User user = new User();
            user.setName("Valerio");
            user.addPwd("12345678910");
            PasswordChecker checker = new PasswordChecker(user);
            String pwd = "12345678910";
            boolean result = checker.isValid(pwd);
            assertFalse(result);
        }

    @Test
    public void When_PwdNotTheSameAsPreviousThree_Expect_Valid(){
        User user = new User();
        user.setName("Valerio");
        user.addPwd("12345678910");
        PasswordChecker checker = new PasswordChecker(user);
        String pwd = "123456789";
        boolean result = checker.isValid(pwd);
        assertTrue(result);
    }

    @Test
    public void When_PwdSameAsPreviousTwo_Expect_Invalid(){
        User user = new User();
        user.setName("Valerio");
        user.addPwd("helloworld123");
        user.addPwd("1234567891");
        PasswordChecker checker = new PasswordChecker(user);
        String pwd = "helloworld123";
        boolean result = checker.isValid(pwd);
        assertFalse(result);
    }

}