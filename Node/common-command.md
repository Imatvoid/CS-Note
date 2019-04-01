## 常用命令


#### 安装相关
```
# 查看全局安装包
npm list -g -depth 0


# 本地安装
npm install module_name 

npm install module_name --save      /  -s

会在package.json的dependencies属性下添加X
之后运行npm install命令时，会自动安装X到node_modules目录中
之后运行npm install 
–production或者注明NODE_ENV变量值为production时，会自动安装msbuild到node_modules目录中


npm install module_name –save-dev   / -d

会在package.json的devDependencies属性下添加X
之后运行npm install命令时，会自动安装X到node_modules目录中
之后运行npm install 
–production或者注明NODE_ENV变量值为production时，不会自动安装X到node_modules目录中


# 全局安装
npm install -g module_name


# 查看包版本信息
npm view module_name versions

```
#### 


https://www.coolecho.net/article/av51