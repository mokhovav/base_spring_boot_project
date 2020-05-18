package com.mokhovav.base_spring_boot_project;

import com.mokhovav.base_spring_boot_project.annotations.Tracking;
import com.mokhovav.base_spring_boot_project.baseClasses.BaseValid;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { BaseSpringBootProject.class })
@SpringBootTest
public class BaseSpringBootProjectTest {
    @Autowired
    private Logger logger;

    @Before
    public void autowiredTest(){
        logger.info("Start base_spring_boot_project tests");
    }

    @After
    public void endOfTests() {
        logger.info("Stop base_spring_boot_project tests");
    }

    @Test
    public void trackingTest(){
        logger.info("Tracking test");
    }

}
