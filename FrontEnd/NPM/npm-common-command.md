## 常用命令


#### 安装相关
```shell
# 查看全局安装包
npm list -g -depth 0
npm ls -g --depth=0

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




# 本地删除
npm uninstall <package_name>

#删除包,但不会清理package.json中的依赖项,下次npm ls时会报错缺少包

npm uninstall --save <package_name> 这样连依赖一起删掉

#如果只删除了依赖,没有删除包,下次npm ls时会报多了包

#这时应该用npm prune把包也删除掉

#全局删除
npm uninstall -g <package_name>


# 查看包版本信息 
npm view module_name versions

```

https://www.coolecho.net/article/av51

## Node版本升级

第1步:先查看本机node.js版本：

```
node -v
```

第2步:清除node.js的cache：

```
sudo npm cache clean -f
```

第3步:安装 n 工具，这个工具是专门用来管理node.js版本的，别怀疑这个工具的名字，是他是他就是他，他的名字就是 "n"

```
sudo npm install -g n
```

第4步:安装最新版本的node.js

```
sudo n latest
```

安装稳定版本的node.js

```
sudo n stable
```

安装或使用某一个版本的node.js

```
sudo n 8.9.0
```

删除某个版本的node.js

```
sudo n rm 9.0.0
```

第5步:再次查看本机的node.js版本：

```
node -v
```

第6步:更新npm到最新版

```
sudo npm install npm@latest -g
```

第七步:验证

```
node -v
npm -v
```

node 4.0 新特性

npm config set scripts-prepend-node-path true ??



## 查看配置

```shell
npm config get userconfig

npm config get globalconfig
```









