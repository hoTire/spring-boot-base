package com.googlecode.hotire.base.utils;

import com.googlecode.hotire.base.domain.Person;
import me.xdrop.jrand.JRand;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * Passey
 */
public class RandomUtils {
    private static final List rules =  Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
            new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 1));

    public static String generatePassword() {
        return new PasswordGenerator().generatePassword(8, rules);
    }
    public static Person createRandomPerson() {return  PersonFactory.createRandomPerson();}

    static class PersonFactory {
        private PersonFactory(){}
        public static Person createRandomPerson() {
            Person instance = new Person();
            instance.setAge(JRand.age().gen());
            instance.setName(JRand.name().gen());
            instance.setGender(JRand.gender().gen());
            return instance;
        }
    }
}
