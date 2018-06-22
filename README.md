# blog
## 一、关于项目的说明
### 1、对原工程的修改内容
这是一个多用户的blog项目，基于原作者老卫的项目做的开发，原项目地址https://github.com/waylau/new-star-blog。

（1）、将gradle项目改成了maven项目；

（2）、原项目是分为new-star-blog（blog项目），mongodb-file-server（文件上传下载服务）两个项目，我将这两个项目合并为一个项目；

（3）、原mongodb-file-server项目地址为 https://github.com/waylau/mongodb-file-server

### 2、我的想法
（1）、想为自己为公司的兄弟们创建一个可以分享自己知识的平台，增强我们的交流与沟通。

（2）、尊重原作者的初衷，这个项目也是开源。

（3）、这仅仅是一个开始，如果项目运行过程中有什么问题请联系我zongxingh@163.com。

## 二、项目运行
项目用到了springboot作为基础框架，同时后端用到了oracle、mongodb，以及elasticsearch，所以在运行项目之前先安装好这些组件。在这个项目里我提供了一个mongodb安装后的启动脚本和配置文件，把这些文件拷贝到mongodb安装后的bin的同级目录下，左后的目录结构如下所示：


```
   mongodb-4.1.0
   ├── bin
   ├── db
   ├── etc
   ├── GNU-AGPL-3.0
   ├── logs
   ├── MPL-2
   ├── README
   └── THIRD-PARTY-NOTICES
```
按照项目里提供的 install-mongodb.md 和 install-es.md 来安装 mongodb 以及 es。

安装es的中文分词器 IK Analysis for Elasticsearch。

下载分词器，下载的分词器的版本一定要与es的版本一致，我这里使用的es是v5.4.1，所以下载的对应的ik版本。
下载地址：https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v5.4.1/elasticsearch-analysis-ik-5.4.1.zip

在es的安装目录的plugins文件下新建目录 ik，并解压刚刚下好的ik到该目录下，重启 es 即可。

安装好的目录结构如下：
```
plugins/
└── ik
    ├── commons-codec-1.9.jar
    ├── commons-logging-1.2.jar
    ├── config
    ├── elasticsearch-analysis-ik-5.4.1.jar
    ├── elasticsearch-analysis-ik-5.4.1.zip
    ├── httpclient-4.5.2.jar
    ├── httpcore-4.4.4.jar
    └── plugin-descriptor.properties
```