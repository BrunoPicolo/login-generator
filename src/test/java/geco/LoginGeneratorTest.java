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

        // GIVEN
        final String n2 = "Ralling";
        final String p2 = "John";
        // WHEN
        final String login2 = loginGenerator.generateLoginForNomAndPrenom(n2,p2);
        // THEN
        Assert.assertEquals("New login", "JRAL2", login2);

        // GIVEN
        final String n3 = "Rolling";
        final String p3 = "Jean";
        // WHEN
        final String login3 = loginGenerator.generateLoginForNomAndPrenom(n3,p3);
        // THEN
        Assert.assertEquals("New login", "JROL1", login3);

        // GIVEN
        final String n4 = "Dùrant";
        final String p4 = "Paul";
        // WHEN
        final String login4 = loginGenerator.generateLoginForNomAndPrenom(n4,p4);
        // THEN
        Assert.assertEquals("New login", "PDUR1", login4);
    }
}