package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class ExampleDaoGenerator {
    public static void main(String[] args) throws Exception {
        // 正如你所见的，你创建了一个用于添加实体（Entity）的模式（Schema）对象。
        // 两个参数分别代表：数据库版本号与自动生成代码的包路径。
        Schema schema = new Schema(1, "me.redbaby.greendao");
//      当然，如果你愿意，你也可以分别指定生成的 Bean 与 DAO 类所在的目录，只要如下所示：
//      Schema schema = new Schema(1, "me.itangqi.bean");
//      schema.setDefaultJavaPackageDao("me.itangqi.dao");

        // 模式（Schema）同时也拥有两个默认的 flags，分别用来标示 entity 是否是 activie 以及是否使用 keep sections。
        // schema2.enableActiveEntitiesByDefault();
        // schema2.enableKeepSectionsByDefault();

        // 一旦你拥有了一个 Schema 对象后，你便可以使用它添加实体（Entities）了。
        addNote(schema);

        // 最后我们将使用 DAOGenerator 类的 generateAll() 方法自动生成代码，此处你需要根据自己的情况更改输出目录（既之前创建的 java-gen)。
        // 其实，输出目录的路径可以在 build.gradle 中设置，有兴趣的朋友可以自行搜索，这里就不再详解。

//        new DaoGenerator().generateAll(schema, "/Users/tangqi/android-dev/AndroidStudioProjects/MyGreenDAO/app/src/main/java-gen");
        new DaoGenerator().generateAll(schema, "C:/team/RedBaby/app/src/main/java-gen");
    }

    /**
     * @param schema
     */
    private static void addNote(Schema schema) {
        // 一个实体（类）就关联到数据库中的一张表，此处表名为「Note」（既类名）
        Entity note = schema.addEntity("Table_shopping");
        // 你也可以重新给表命名
        // note.setTableName("NODE");

        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        note.addIdProperty();
        note.addIntProperty("shopping_id").notNull();   //商品id(唯一的) ??唯一如何弄？
        note.addStringProperty("shopping_name ").notNull();//商品名称
        // 与在 Java 中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        // For example, a property called “creationDate” will become a database column “CREATION_DATE”.
        note.addFloatProperty("shopping_price").notNull();//商品价格
        note.addStringProperty("shopping_url");//商品url
        note.addStringProperty("shopping_pic");//商品图片
        note.addIntProperty("shopping_count").notNull();   //商品数量
        note.addIntProperty("shopping_state").notNull();   //商品状态
    }
}
/*
//1.在主类中，与java包同级，建立java-gen文件夹
//2.主类资源配置信息，在build.gradle中
//3.映射地址记得修改为java-gen地址
//4.主类添加依赖 compile 'de.greenrobot:greendao:2.1.0'
//5.主类添加 Module
 sourceSets{
            main{
            java.srcDirs=['src/main/java','src/main/java-gen']
            }
            }
            */

//app 全局配置
/*
    public class Myapp extends Application{
    public DaoSession daoSession;
    public SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;
    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }
    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        helper = new DaoMaster.DevOpenHelper(this,"Cart", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return daoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }
}*/
