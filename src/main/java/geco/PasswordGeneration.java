package geco;


import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGeneration {
    final String getRandomPassword() {
        return RandomStringUtils.random(8, true, true);
    }
}
