package test;

import org.junit.Test;
import main.User;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class UserTest {
    @Test
    public void valid_card_number() {
        assertTrue(User.validLibraryNumber("111-1111"));
    }

    @Test
    public void invalid_card_number() {
        assertFalse(User.validLibraryNumber("abc"));
    }

    @Test
    public void valid_password() {
        assertTrue(User.validPassword("bhaisahab"));
    }

    @Test
    public void invalid_password() {
        assertFalse(User.validPassword("abc"));
    }
}
