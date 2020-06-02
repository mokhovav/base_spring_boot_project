package com.mokhovav.base_spring_boot_project.exceptions;

import com.mokhovav.base_spring_boot_project.BaseSpringBootProject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { BaseSpringBootProject.class })
@SpringBootTest
public class ExceptionTest {

    @Test(expected = CriticalException.class)
    public void criticalExceptionTest() throws CriticalException {
        throw new CriticalException("Critical Exception test");
    }

    @Test(expected = LogicalException.class)
    public void logicalExceptionTest() throws LogicalException {
        throw new LogicalException("Logical Exception test");
    }

    @Test(expected = ValidException.class)
    public void validExceptionTest() throws ValidException {
        throw new ValidException("Valid Exception test");
    }
}
