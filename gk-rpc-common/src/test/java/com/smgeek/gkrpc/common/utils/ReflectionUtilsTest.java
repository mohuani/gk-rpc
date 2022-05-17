package com.smgeek.gkrpc.common.utils;

import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Ref;

import static org.junit.Assert.*;

public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestCase t = ReflectionUtils.newInstance(TestCase.class);
        assertNotNull(t);
    }

    @Test
    public void getPublicMethods() {
        Method[] mname = ReflectionUtils.getPublicMethods(TestCase.class);
        assertEquals(1, mname.length);

        String name = mname[0].getName();
        assertEquals("b", name);
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestCase.class);
        Method b = methods[0];

        TestCase t = new TestCase();
        Object r = ReflectionUtils.invoke(t, b);
        assertEquals("b", r);
    }
}