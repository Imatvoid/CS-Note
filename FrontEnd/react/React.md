# React

## 对比

###  需求才是决定性

- 大型超大型（后端开发） - Angular

- 中型 - react  最正确的思想

- 小型 + 求简单，求成本 -  Vue  个人不太看好 ，但是确实快，要求要低一些（比如优化）

详细对比待补充

https://www.cnblogs.com/hellohello/p/8073215.html

vue 和 react 都使用虚拟dom



## React特性

- 虚拟dom

  react不得不提的是虚拟DOM(Virtual DOM)，当页面初次加载的时候会产生一颗dom树，内存中会产生一颗render树，当数据发生更改的时候，会将更改的内容和存有的render树进行对比，找出最优的算法，然后更改render树，最后重新生成页面的dom树，有了虚拟dom，前端的性能提高了很多，不用每次都渲染，react还会对操作做合并。

- 最彻底的组件化
  react的组件化思想尤为体现，将view层分成各个独立的组件，降低耦合度，组件化使得组件间可组合，可重用，可维护，从而大大提高开发效率

- 灵活性（有时候希望库能少一点，来几个一统天下的）

  react是基于view层的**UI框架**，要想发挥他的作用，必须配合一些插件，例如redux等，当然，可以配合更多的库来达到更好的效果。

- 使用场景 - 中大型




### 虚拟dom

#### DOM（Document Object Model）

DOM是HTML源文档的基于对象的表示。它有一些差异，我们将在下面看到，但它本质上是一种尝试将HTML文档的结构和内容转换为可供各种程序使用的**内存对象模型**。

DOM不是HTML文档的本质等价，JS可以动态改变它。

DOM不是渲染树（在浏览器中看到的）。

![img](https://pic3.zhimg.com/80/c582b0e4d8034f9994b174d3a5cd4056_hd.jpg)



1）浏览器会解析三个东西：
一个是HTML/SVG/XHTML，事实上，Webkit有三个C++的类对应这三类文档。解析这三种文件会产生一个DOM Tree。
CSS，解析CSS会产生CSS规则树。
Javascript，脚本，主要是通过DOM API和CSSOM API来操作DOM Tree和CSS Rule Tree.

2）解析完成后，浏览器引擎会通过DOM Tree 和 CSS Rule Tree 来构造 Rendering Tree。注意：
Rendering Tree 渲染树并不等同于DOM树，因为一些像Header或display:none的东西就没必要放在渲染树中了。
CSS 的 Rule Tree主要是为了完成匹配并把CSS Rule附加上Rendering Tree上的每个Element。也就是DOM结点。也就是所谓的Frame。
然后，计算每个Frame（也就是每个Element）的位置，这又叫layout和reflow过程。

3）最后通过调用操作系统Native GUI的API绘制。

[@知乎阿安](https://www.zhihu.com/question/20117417/answer/22359160)



#### 虚拟DOM

虚拟DOM是react框架里的DOM，是抽象的抽象（DOM本身就是抽象），它模拟页面上的DOM来实现页面中DOM的高效更新（合并操作 + diff）。



1. 用 JavaScript 对象结构表示 DOM 树的结构；然后用这个树构建一个真正的 DOM 树，插到文档当中
2. 当状态变更的时候，重新构造一棵新的对象树。然后用新的树和旧的树进行比较，记录两棵树差异
3. 把2所记录的差异应用到步骤1所构建的真正的DOM树上，视图就更新了



[虚拟DOM的原理](http://codehao.com/2018/06/07/React虚拟DOM的原理/)
[虚拟DOM简单实现](https://www.zhihu.com/question/29504639)

层级的比较

[LeetCode-Edit Distance ](https://leetcode.com/problems/edit-distance/)



PS

ReactElement是一个轻量的，无状态的，不可变的，DOM元素的虚拟表示。

**ReactElement存在于虚拟DOM中。**在这里它们构成了基本的节点。其不可变性使其更易于和快速比较和更新。这也是React性能优越的原因之一。

那么*ReactElement*具体是什么呢？答案是几乎所有的的HTML标签——*div*，*table*，*strong*等，只要你想用，[这里](https://facebook.github.io/react/docs/tags-and-attributes.html)查看整个列表。

https://www.html.cn/archives/4991







取消了函数的自动绑定。以前是为何？？

**React 的最大价值？**
1.高性能虚拟 DOM 【★★】
2.声明式的、直观的编程方式（别样的组件化、JSX也不是核心）【★】
3.封装过的事件机制
4.服务器端 Reader（忽略，不是核心，锦上添花）
5.完善的错误提示信息

http://anjia.github.io/2015/07/24/fe_react/

















## 打包

### 为什么打包？

- 编译ES6(将ES6转化为ES5),编译JSX

- 整合资源比如Less,Sass

- 优化代码体积

### 工具-WebPack







注意事项:

- 检查nodejs为producton

- 禁用开发代码 比如redux-logger,只在开发环境才需要

- 设置应用根路径

  