# Spring schema 扩展

## 基本实现

### 定义实体类

```java
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Data
public class User {
    private  String userName;
    private  String email;
    
}
```

### 定义xsd

```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsd:schema
        xmlns:xsd="http://www.w3.org/2001/XMLSchema"
        xmlns="http://www.learn.com/xml-tags/user"
        targetNamespace="http://www.learn.com/xml-tags/user"
        elementFormDefault="qualified" attributeFormDefault="unqualified"
>
    <xsd:element name="user">
        <xsd:complexType>
            <xsd:attribute name="id" type="xsd:string" />
            <xsd:attribute name="userName" type="xsd:string" />
            <xsd:attribute name="email" type="xsd:string" />

        </xsd:complexType>
    </xsd:element>

</xsd:schema>
```

### 定义Parser

```java
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        if(StringUtils.hasText(userName)){
            builder.addPropertyValue("userName",userName);
        }
        if(StringUtils.hasText(email)){
            builder.addPropertyValue("email",email);
        }
    }
}
```

### 定义节点和处理Parser的映射

```java
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class CustomizeNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("user", new UserDefinitionParser());
    }
}
```

### 在META-INF注册shcemas xsd文件 和 命名空间handler

```properties
# spring.handlers 文件
http\://www.learn.com/xml-tags/user=com.learn.customizetags.singlebean.CustomizeNamespaceHandler

# spring.schemas 文件
http\://www.learn.com/xml-tags/user.xsd=/META-INF/user.xsd
```



## 参考

原理(wait)

https://blog.csdn.net/lilongjiu/article/details/76695310

xmlns 和 targetNameSpace的差别

https://stackoverflow.com/questions/4126919/what-is-the-difference-between-targetnamespace-and-xmlnstarget

https://stackoverflow.com/questions/7190572/targetnamespace-and-xmlns-without-prefix-what-is-the-difference