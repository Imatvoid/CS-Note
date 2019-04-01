## MacOS 安装npm以及淘宝镜像以及环境变量配置

#### brew安装 
```
brew install node
```

#### 校验 

```
node -v
v11.12.0

npm -v
6.9.0
```
#### 更改环境变量

修改 PATH 时要把 ~/.npm-global/bin 放到 $PATH 的前面，让系统先在这个文件夹里找，才能避免先找到 /usr/local 下的 npm

```
mkdir ~/.npm-global

vim ~/.npmrc  # prefix=~/.npm-global

vim ~/.bash_profile # export PATH=$HOME/.npm-global/bin:$PATH

source ~/.bash_profile

npm i -g npm

which npm
/Users/yangxu/.npm-global/bin/npm

```

#### 更换淘宝镜像
```
npm config set registry https://registry.npm.taobao.org  # npm config delete registry  / npm config edit

npm config get registry
https://registry.npm.taobao.org/

npm install -g cnpm 

cnpm -v


```






参考 https://kylehe.me/blog/2018/03/27/how-to-install-nodejs-on-macos.html