package com.practice.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.utils.FakeDataGenUtils;

public class TestClass extends BaseAbstractTest{

	@Test
	public void test1() {
		FakeDataGenUtils data = new FakeDataGenUtils();
		System.out.println(data.getAddressFakeData());
	}
	

}
