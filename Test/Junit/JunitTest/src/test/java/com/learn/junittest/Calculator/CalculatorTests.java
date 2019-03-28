package com.learn.junittest.Calculator;


import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTests {

    /*
    一个JUnit4的单元测试用例执行顺序为:
    @BeforeClass -> @Before -> @Test -> @After -> @AfterClass;
    */


    /**
     * 测试类加载时候的静态方法
     */
    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }



    @Before
    public void before(){
        System.out.println("before");
    }

    @Test
    public  void  test(){
        // 构造器
        System.out.println("test:"+new Calculator().add(1,2));
    }



    @After
    public void after(){
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }
}
