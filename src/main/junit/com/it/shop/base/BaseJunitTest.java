package com.it.shop.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringJunit测试的基本类
 *
 * Junit启动时加载Spring的IOC容器
 *
 * 所有测试类文件都需要继承此类
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/applicationContext.xml")
public class BaseJunitTest {

}
