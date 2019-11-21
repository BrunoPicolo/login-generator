package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    LoginGenerator loginGenerator;
    LoginService loginService;

    @Before
    public void setup(){
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void generateLoginForNomAndPrenom() {
        // GIVEN
        final String n1 = "Durant";
        final String p1 = "Paul";
        // WHEN
        final String login1 = loginGenerator.generateLoginForNomAndPrenom(n1,p1);
        // THEN
        Assert.assertEquals("New login", "PDUR", login1);
    }
}