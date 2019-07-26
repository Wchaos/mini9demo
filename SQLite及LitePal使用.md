### SQLite及LitePal使用

1、app的gradle中添加依赖：`implementation 'com.google.android.material:material:1.0.0'`

2、manifests的<application>中添加`android:name="org.litepal.LitePalApplication"`组件声明

3、在`app/src/main`中新建`assets`文件夹，在文件夹中新建`litepal.xml`配置文件

4、新建对应数据表的`POJO`类，继承`LitePalSupport`基类

5、调用`Connector.getDataBase()`即可，无则创建数据库，有则直接获得数据库引用

6、CURD对应用法，百度即可


#### 查看数据库方法
数据存储文件夹：`data/data/包名(com.****)/工程名/databases`
查看工具：`view/Tool window/Divice File Ecplore`

1、下载`database navigator`插件
2、右键点击'table_name.db'文件，`saveas`保存到电脑上
3、使用插件连接上一步中的数据库文件，即可用SQL查看数据


