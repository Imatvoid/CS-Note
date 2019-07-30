> https://yarnpkg.com/zh-Hans/docs/cli/list

## 初始化

```shell
yarn init
```



## 包管理

### 安装包

```shell
yarn add  pkg_name
yarn add package-name@1.2.3 # 指定版本

yarn global add pkg_name  # 全局

yarn  add pkg_name -D
yarn  add pkg_name --dev # 添加到开发者依赖
```



### 卸载包

```shell
yarn remove pkg_name
```



### 升级包

```shell
yarn upgrade # 升级全部包
```

### 查看包

```shell
yarn list --depth=0
yarn list --pattern "gulp|grunt" --depth=1


# 全局查看
yarn global list
npm list -g --depth 0
```



## 缓存

```shell
yarn cache dir # 会打印出当前的 yarn 全局缓存在哪里
yarn cache clean # 清理
```



## yarn信息

```shell
yarn global bin # 查看yarn 全局安装的根目录
```

