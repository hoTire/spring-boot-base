package com.googlecode.hotire.base.utils;

import com.googlecode.hotire.base.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class RandomUtilsTest {
    @Test
    public void createRandomPerson() {
        Person person = RandomUtils.createRandomPerson();
        log.info(person.toString());
        assertNotNull(person);
    }
}