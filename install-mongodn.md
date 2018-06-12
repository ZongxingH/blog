### 1、下载mongodb
对应自己的服务器系统，去官网下载对应版本的mongodb，我是CentOS 7.4的，由于没找到CentOS的，我下载的是 
```
mongodb-linux-x86_64-amazon-3.6.0.tgz
```

### 2、上传解压
将下载好的安装包上传到 /data/mongodb 目录下，上传后，执行解压命令：
```
tar -zxvf mongodb-linux-x86_64-amazon-3.6.0.tgz
```

解压后我将它重命名为：
```
mongodb-3.6.0
```

### 3、创建配置文件
在mongodb-3.6.0文件夹再里创建三个文件夹：
```
mkdir data   //用来存放数据库数据
mkdir logs   //用来存放日志文件
mkdir etc    //用来存放配置文件
```

接下来，进入到logs文件夹里创建 mongo.log文件：
```
touch mongo.log
```

再到etc文件夹里创建 mongo.conf文件：
```
touch mongo.conf
```

通过vim编辑mongo.conf编辑内容：

```
vi mongo.conf
```

输入的内容为：
```
# 保存数据的路径
dbpath=/data/mongodb/mongodb-4.1.0/db
# 日志文件
logpath=/data/mongodb/mongodb-4.1.0/logs/mongo.log
# 日志写入文件的模式
logappend=true
journal=true
quiet=true
# 是否后台运行，true为后台运行
fork=true
# 监听的端口
port=20117
# 绑定IP地址
bind_ip=0.0.0.0
```

### 4、启动mongodb
```
./bin/mongod -f /data/mongodb/etc/mongo.conf
```


### 5、进入mongodb数据库

```
./bin/mongo --port 20117
```
