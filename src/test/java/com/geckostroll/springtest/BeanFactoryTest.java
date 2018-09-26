/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.geckostroll.springtest;

import com.geckostroll.springtest.pojo.Car;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 *
 * @author yanhuai
 * @version $Id: BeanFactoryTest.java, v 0.1 2018年09月26日 上午10:24 yanhuai Exp $
 */
public class BeanFactoryTest {

    @Test
    public void test1() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beans.xml");
        BeanFactory beanFactory = new XmlBeanFactory(res);
        System.out.println("init bean factory");

        Car car = beanFactory.getBean("car1", Car.class);
        System.out.println(car);
        Assert.assertEquals(car.getBrand(), "红旗");
        Car anotherCar = beanFactory.getBean(Car.class);
        System.out.println(anotherCar);
        Assert.assertEquals(car, anotherCar);

    }
}
