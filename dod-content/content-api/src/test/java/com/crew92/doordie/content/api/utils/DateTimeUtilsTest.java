package com.crew92.doordie.content.api.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class DateTimeUtilsTest {

    @Test
    public void testToString() {
        System.out.println(DateTimeUtils.toString(new Date()));
    }

}