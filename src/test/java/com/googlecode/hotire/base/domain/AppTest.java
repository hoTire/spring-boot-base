package com.googlecode.hotire.base.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author : hotire
 */
@TestPropertySource(properties = "app.name=ho")
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "app.name=test")
@Slf4j
public class AppTest {

    @Autowired AppProperties appProperties;

    @Autowired
    Environment environment;

    @Test
    public void test() {
        assertThat(appProperties.getName()).isEqualTo("ho");
        assertThat(appProperties.getCreator()).isEqualTo("tire.ho");
    }
}