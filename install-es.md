### 安装ES前先安装好jdk 8
### 1、下载ES
下载地址
```
https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.4.1.tar.gz
```
### 2、解压
将 elasticsearch-5.4.1.tar.gz 上传到 /data/elasticsearch 目录下并解压。解压后的目录结构为：

```
elasticsearch-5.4.1
|- bin
|- config
|- lib
|- modules
|- plugins
|- LICENSE.txt
|- NOTICE.txt
|- README.txt
```
### 3、修改配置文件
由于部署单节点所以只做简单的配置
修改 elasticsearch.yml 文件，vim config/elasticsearch.yml，修改内容如下：


```
# ----------------------- Paths -------------------------
#
# Path to directory where to store the data (separate multiple locations by comma):
#
path.data: /data/elasticsearch/data
#
# Path to log files:
path.logs: /data/elasticsearch/elasticsearch-5.4.1/logs
# --------------------- Network -------------------------
#
# Set the bind address to a specific IP (IPv4 or IPv6):
#
network.host: 0.0.0.0
#
# Set a custom port for HTTP:
#
http.port: 9200

```

修改 jvm.options 文件，vim configjvm.options，修改内容如下：

```
# 由于是虚机，所以这两个值改小一点，我改为768m
-Xms768m
-Xmx768m
```
### 4、启动elasticsearch
首先es不能用 root 用户启动
启动命令,-d表示后台启动

```
./bin/elasticsearch -d
```
### 5、安装过程中可能遇到的问题


```
#这个是linux内核不支持 syscall filter,centos 7以上据说没这个问题,但是不影响使用 
unable to install syscall filter: 
java.lang.UnsupportedOperationException: seccomp unavailable: CONFIG_SECCOMP not compiled into kernel, CONFIG_SECCOMP and CONFIG_SECCOMP_FILTER are needed 
#通过配置后面第[4]个好像就没有报错了 
#linux max file配置过低 
[1]: max file descriptors [4096] for elasticsearch process is too low, increase to at least [65536] 
#通过配置 /etc/security/limits.conf 解决，* 表示启动ES的用户
* soft nofile 65536 
* hard nofile 65536 
* soft nproc 2048 
* hard nproc 4096 
#使用最大线程数过低 
[2]: max number of threads [1024] for user [search] is too low, increase to at least [2048] 
#通过配置/etc/security/limits.d/90-nproc.conf 解决 
*softnproc 2048 
#虚拟内存配置太低 
[3]: max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144] 
#通过配置 /etc/sysctl.conf 追加一行如下解决 
vm.max_map_count=655360 
#system call filters安装失败 
[4]: system call filters failed to install; check the logs and fix your configuration or disable system call filters at your own risk 
#解决办法通过配置 /opt/elasticsearch/config/elasticsearch.yml参数解决 
bootstrap.memory_lock: false 
bootstrap.system_call_filter: false 
```