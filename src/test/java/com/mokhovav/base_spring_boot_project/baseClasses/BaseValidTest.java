package com.mokhovav.base_spring_boot_project.baseClasses;

import com.mokhovav.base_spring_boot_project.BaseSpringBootProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { BaseSpringBootProject.class })
@SpringBootTest
public class BaseValidTest {
    @Autowired
    private BaseValid baseValid;

    @Autowired
    private Logger logger;

    @Test
    public void nullOrEmpty(){
        logger.info("nullOrEmpty test");
        assertTrue(baseValid.nullOrEmpty(null));
        assertTrue(baseValid.nullOrEmpty(new String()));
        assertTrue(!baseValid.nullOrEmpty(new String("test String")));
    }
}