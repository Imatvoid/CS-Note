# 能力扩展点





## 介绍

将散落着,隐藏在各种系统间,不同TOB商家的各种业务逻辑, 归纳整合.让业务能力现身,统一管理.



### 业务能力拓展点相关

- 业务能力扩展点(能力点/扩展点)

  实现一种业务能力,比如xxxx业务

- 具体功能点

  业务能力点的一部分,在代码维度可能是能力点中的一个方法,实现某个具体功能.

- 插件(Plugin)，是能力点的一个实现，一个能力点可能对应多个插件,有多种实现,多态地满足不同的业务场景需求.由插件微内核根据业务身份进行路由和加载.

  比如xxxxx,我有A公司,B公司.

  

能力点是 被嵌入宿主系统的.它本身是跨系统的.

能力点有默认的基础能力实现,每个业务方的特性业务可以实现隔离.



能力点不会因为宿主系统的不同而产生不同的结果
能力点的接口、指令，是由业务抽取开发人员提出的，由业务能力开发人员实现.





## 领域驱动设计([Domain Driven Design](https://en.wikipedia.org/wiki/Domain-driven_design)) 

业务能力可以使用通用语言描述,比如创建一个订单(而不是往订单表插入一条数据)

#### 通用语言（Ubiquitous Language）

其实写软件就像是翻译，把领域上的业务需求翻译成软件的各个功能。业务需求来自领域专家（Domain Expert），程序员们需要把领域专家的语言翻译成程序。如果程序员们翻译的时候使用的是自己的语言，而领域专家使用自己的行话，导致术语不一致，就会使得沟通不顺畅，难于消化知识。所以团队需要一种通用语言来进行沟通。这样的通用语言尽量以业务语言为主，而非技术语言。一开始的通用语言可能不尽完美，但它就像是代码一样，经常需要重构。例如：“创建一个订单”就比“插入一条订单数据”更容易让领域专家明白谈话的背景。







## 后续维护

随着业务变化

多个业务能力可能会合并成一个
一个业务能力可能会拆分成多个更细粒度的业务能力
一个业务能力也可能演化成独立的应用系统，有自己的页面、MQ、JSF，甚至自己的复杂流程

可能产生复合能力，将多个业务能力组织协调工作



## 使用示范

```java
// 创建业务能力指令
ValidateCmd cmd = new ValidateCmd(); 
Dept dept = deptService.getDept(deptId);
cmd.setReturnSignature(dept.returnSignature);
Warehouse warehouse = warehouseService.getWarehouse(warehouseId);
cmd.setWarehouseType(warehouse.type);

// 构建业务身份
IAM iam = IAM.build().withDeptNo(order.getDeptNo());

// 插件微内核通过业务身份标识加载扩展点(接口)
SignBillReturnExtPt ext = pluginContext.load(SignBillReturnExtPt.class, iam);

// 给扩展点下发指令，扩展点执行
ext.validate(cmd);
// 得到扩展点的返回值
System.out.println(cmd.getReply());

```



## 路由匹配

有且只有一个默认实现(@RegisterExt注解不配置deptNoKeys和sellerNoKeys)
@RegisterExt配置


@RegisterExt注解支持deptNoKeys和sellerNoKeys两个条件进行一级路由，如果扩展点中有需要根据其他条件有不同实现的情况，扩展点自行实现二级路由
通过IAM进行路由查找时优先匹配deptNo，如果匹配不上则使用sellerNo匹配(只匹配未指定deptNokeys的实现)，如果还没匹配到则使用默认实现
扩展点的多个实现配置的deptNoKeys和sellerNoKeys不能互相冲突，比如同一个事业部编号在两个实现都配置了
sellerNoKeys和deptNoKeys对应的key必须以'iam.'开头，定义在配置文件properties里，支持一个key对应多个值







