### ShardingSphere-Proxy的使用

---

#### 基本使用

1. 下载二进制包：https://archive.apache.org/dist/shardingsphere/

2. 解压到任意目录

3. 把数据库驱动jar包加入到lib目录：ShardingSphere-Proxy默认支持Postgresql，若要使用Mysql或是其他数据库，则需要导入jar包

4. 配置 `server.yaml` 
   1.  `orchestration` ：连接zookeeper注册中心相关，使用注册中心才需要
   2.  `authentication` ：配置用户，密码，以及授权的数据库；`authorizedSchemas` 属性省略默认授权所有数据库
   3.  `props` ：其他的一些配置

5. 配置 `config-xxx.yaml` 
   1.  `schemaName` ：逻辑数据库的名称；逻辑数据库相当于是一个Proxy实例**==^?^==**
   2.  `dataSources` ：配置实际数据源
   3.  `Rules` ：配置分片规则、读写分离、影子库、加密规则等具体策略

6. 运行 `/bin/start.bat` （win） `/bin/start.sh` （linux）开启proxy服务

   https://www.sohu.com/a/389465088_411876（sharding-proxy核心原理）

7. 使用sharding-proxy：访问proxy服务，当作一个普通的DB

   1. host：proxy运行的host
   2. port：默认3307，在运行proxy服务的命令后增加端口参数可修改
   3. username：server.yaml配置
   4. password：server.yaml配置
   5. Driver类型与DataSources保持一致（如果DataSources有多种DB==**^?^**==）

#### 通过zookeeper管理sharding-proxy配置文件

1. 完成基本步骤1-5

2. 配置 `server.yaml` 
   1.  配置 `orchestration` ：使用默认就可以

3. 下载并在任意目录解压zookeeper

   http://archive.apache.org/dist/zookeeper/

   将 `/conf/zoo_sample.cfg` 拷贝一份 `/conf/zoo.cfg` ，更改 `dataDir=` 为自定义目录，用来存放zookeeper管理的文件节点

4. 下载并在任意目录解压shardingsphere-ui

   https://archive.apache.org/dist/shardingsphere/

5. 开启zookeeper服务

   windows运行：`zookeeper/bin/zkServer.cmd` 

6. 开启sharding-proxy服务

   windows运行：`proxy/bin/start.bat` 

   由于server.yaml的配置，zookeeper会自动注册proxy

7. 开启sharding-ui服务

   windows运行：`ui/bin/start.bat` 

   使用ui界面来管理proxy注册到zookeeper中的配置文件

8. 浏览器访问http://localhost:8088/，admin/admin登录

9. 添加注册中心**并激活**

   ![image-20210706145453267](C:\Users\LMD\AppData\Roaming\Typora\typora-user-images\image-20210706145453267.png)

10. 添加配置中心**并激活**

    同上

11. 在配置中心/配置管理中管理配置文件

    ![image-20210706145712982](C:\Users\LMD\AppData\Roaming\Typora\typora-user-images\image-20210706145712982.png)

12. 使用sharding-proxy：访问proxy服务，当作一个普通的DB

    1. host：proxy运行的host
    2. port：默认3307，在运行proxy服务的命令后增加端口参数可修改
    3. username：server.yaml配置
    4. password：server.yaml配置
