## 单元测试方法执行顺序

- 一个JUnit4的单元测试用例执行顺序为:

  @BeforeClass -> @Before -> @Test -> @After -> @AfterClass; 


- 每一个测试方法的调用顺序为:

  @Before -> @Test -> @After;
  
  
  
  
  
  ### 注意
  1.@BeforeClass 和 @AfterClass
  对于那些比较“昂贵”的资源的分配或者释放来说是很有效的，因为他们只会在类中被执行一次。
  相比之下对于那些需要在每次test运行之前都要初始化或者在运行之后
  都需要被清理的资源来说使用@Before和@After同样是一个比较明智的选择；
  
  2.如果类里面可以有多个注解过@Before和@After的方法，它们的执行顺序是未知的；
  
  
  3.@BeforeClass  @AfterClass注解是junit提供的另外的两个注解，
  必须设置在public 静态方法之上，表示在class加载之前执行，这样设置的方法只会执行一次，而@Before @After则会再每次test之前/之后执行；
  
  
  
  4.在JUnit4中，如果测试类继承了TestCase类，那么所有的Annotation都不会起作用。