package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    LoginService loginService;

    @Before
    public void setUp() {
        String[] existentLogins = new String[]{"toto", "tata", "tete"};
        loginService = new LoginService(existentLogins);
    }

    @Test
    public void testLoginExists() {
        // Given :
        final String login1 = "toto";
        final boolean oracle1 = true;
        // when
        final boolean res1 = loginService.loginExists(login1);
        // then
        Assert.assertEquals("True", oracle1, res1);

        // Given :
        final String login2 = "titi";
        final boolean oracle2 = false;
        // when
        final boolean res2 = loginService.loginExists(login2);
        // then
        Assert.assertEquals("False", oracle2, res2);
    }

    @Test
    public void testAddLogin() {
        // Given
        final String login1 = "titi";
        final boolean oracle1 = true;
        // when
        loginService.addLogin(login1);
        // then
        Assert.assertEquals("True", oracle1, loginService.loginExists(login1));
    }

    @Test
    public void testFindAllLoginsStartingWith() {
        // GIVEN
        final ArrayList<String> lp1 = new ArrayList<>(Arrays.asList("tata", "tete", "toto"));
        // WHEN
        final ArrayList<String> res1 = (ArrayList<String>) loginService.findAllLoginsStartingWith("t");
        // THEN
        Assert.assertEquals("3", lp1.size(), res1.size());
        Assert.assertArrayEquals("[tata, tete, toto]", lp1.toArray(), res1.toArray());

        // GIVEN
        final ArrayList<String> lp2 = new ArrayList<>(Arrays.asList("tata"));
        // WHEN
        final ArrayList<String> res2 = (ArrayList<String>) loginService.findAllLoginsStartingWith("ta");
        // THEN
        Assert.assertEquals("1", lp2.size(), res2.size());
        Assert.assertArrayEquals("[tata]", lp2.toArray(), res2.toArray());
    }

    @Test
    public void testFindAllLogins() {
        // GIVEN
        final ArrayList<String> lp = new ArrayList<>(Arrays.asList("tata", "tete", "toto"));
        // WHEN
        final ArrayList<String> res = (ArrayList<String>) loginService.findAllLogins();
        // THEN
        Assert.assertArrayEquals("[tata, tete, toto]", lp.toArray(), res.toArray());
    }
}