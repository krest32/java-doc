# SORM框架（练习）

## 原理

### 基本原理

增加、删除、修改

​		对象->SQL语句

查询

+ 查询结果分类
  + 多行多列
    + List<JavaBean>
  + 一行多列
    + JavaBean
  + 一行一列
    + 普通对象
    + 数字：Number

### 核心架构

+ Query 接口
  + 负责查询
+ QueryFactory类
  + 负责根据配置信息创建Query对象
+ TypeConvertor类
  + 负责类型转换
+ TableContext类
  + 负责获取管理数据库所有表结构和类结构的关系，可以根据表结构生成类结构
+ DBManager
  + 根据配置信息，维持链接对象的管理
+ 工具类
  + JDBCUtils 封装JSBC操作
  + StringUtils 封装常用字符串操作
  + JavaFileUtils 封转Java文件操作
  + ReflectUtils 封装常用反射操作
+ 核心Bean，封装相关数据
  + ColumInfo  表头信息
  + Configuration  文件配置信息
  + TableInfo   封装表的信息

### 框架说明

+ 配置文件：目前使用资源文件，后期可以使用Xml文件或注解
+ 类名由表名生成
+ 目前表中只有一个主键，联合主键不支持
+ 使用简单、性能高、易上手



## 核心功能

### 1. 与数据库建立链接

+ 通过读取配置文件的信息，然后与数据库建立链接

#### 流程

##### 添加配置文件

application.properties

~~~properties
# 数据库驱动驱动
driver-class-name=com.mysql.cj.jdbc.Driver
# Url地址
url=jdbc:mysql://192.168.254.134:3306/demo_project1?serverTimezone=GMT%2B8
# 用户名
username=root
# 用户密码
password=123456
# 数据库类型
dbType=mysql
#路径地址（生成代码时使用）
srcPath=E:\\open_source_project\\SORM\\src\\main\\java
# 包路径（生成代码时使用）
poPackage=com.krest.sorm
# 表名（生成代码时使用）
tableName=demo_people
# 表名之间的间隔符号
tableNameSign=_
# 列名之间的间隔符号
columnNameSign=_
# Query对象类
queryClass=com.krest.sorm.core.MySqlQuery
# 数据库连接池最小数量
poolMinSize=10
# 数据库连接池最大数量
poolMaxSize=100
~~~

##### 添加数据库链接池

~~~java
public class DBConnPool {
    /**
     *     连接对象的集合
     */
    private static List<Connection> pool;
    /**
     *     最大连接数，在配置文件中进行配置，使用final进行修饰，所以配置文件中一定要配置这个数据
     */
    private static final int POOL_MAX_SIZE = DBManager.getConf().getPOOL_MAX_SIZE();
    /**
     *     最小连接数，在配置文件中进行配置，使用final进行修饰，所以配置文件中一定要配置这个数据
     */
    private static final int POOL_MIN_SIZE = DBManager.getConf().getPOOL_MIN_SIZE();

	// 初始化连接池
    public void initPool(){
        if (pool==null){
            pool= new ArrayList<Connection>();
        }
        while (pool.size()<DBConnPool.POOL_MIN_SIZE){
            Connection con = DBManager.createCon();
            pool.add(con);
        }
    }

    /**
     * 通过无参数的构造方法，在调用初期就默认创建好连接池。
     */
    public DBConnPool() {
        initPool();
    }
    
    /**
     * 从pool中获取一个链接对象，同时加上同步锁，避免多线程的情况
     */
    public synchronized Connection getConnection(){
        int lastIndex = pool.size()-1;
        // 当使用使用对象的个数超过容器存储的数量是，遍执行新建功能
        if (lastIndex==0){
            // 如果链接池中没有对象，那么就新建一个链接对象进行返回
            return DBManager.createCon();
        }else{
            Connection connection = pool.get(lastIndex);
            // 当获取该连接后，从池中删除，避免被其他对象再次调用
            pool.remove(lastIndex);
            return connection;
        }
    }

    /**
     * 将连接放回pool中，达到重读利用的目的
     * @param connection
     */
    public synchronized void close(Connection connection){
        // 如果链接池中的对象数量超过了最大值，执行关闭操作
        if (pool.size()>POOL_MAX_SIZE){
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            pool.add(connection);
        }
    }
}
~~~



##### 添加配置文件实体类

~~~java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configuration {

    /**
     * 数据库链接Driver
     */
    private String driver;

    /**
     * 数据库链接url
     */
    private String url;

    /**
     * 数据库用户名
     */
    private String user;


    /**
     * 数据库链接密码
     */
    private String pwd;


    /**
     * 数据库类型
     */
    private String dbType;

    /**
     * 数据库pojo文件生成地址
     */
    private String srcPath;

    /**
     * 数据库名称
     */
    private String dBase;


    /**
     * 数据表名称
     */
    private String tableName;


    /**
     * 数据库pojo文件生成的包名
     */
    private String poPackage;

    /**
     * 表名之间的间隔符号
     */
    private String tableNameSign;

    /**
     * 列名之间的间隔符号
     */
    private String columnNameSign;

    /**
     * 列名之间的间隔符号
     */
    private String queryClass;

    /**
     *     最大连接数
     */
    private int POOL_MAX_SIZE =100;

    /**
     *     最小连接数
     */
    private int POOL_MIN_SIZE =10;
}

~~~

##### 读取配置信息（建立连接）

~~~java
@Data
public class DBManager {

    private static Configuration conf;
    // 静态内部类，在调用程序的时候，遍建立连接
    static {
        Properties properties = new Properties();
        try {
            //通过相对路径读取文件
            InputStream in=new BufferedInputStream(new FileInputStream("src\\main\\resources\\application.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf = new Configuration();
        //根据属性进行赋值
        String url = properties.getProperty("url");
        String[] split = url.split("/");
        String s = split[split.length - 1];
        String[] split1 = s.split("\\?");
        conf.setDBase(split1[0]);
        conf.setDriver(properties.getProperty("driver-class-name"));
        conf.setDbType(properties.getProperty("dbType"));
        conf.setUser(properties.getProperty("username"));
        conf.setPwd(properties.getProperty("password"));
        conf.setSrcPath(properties.getProperty("srcPath"));
        conf.setUrl(properties.getProperty("url"));
        conf.setTableName(properties.getProperty("tableName"));
        conf.setPoPackage(properties.getProperty("poPackage"));
        conf.setTableNameSign(properties.getProperty("tableNameSign"));
        conf.setColumnNameSign(properties.getProperty("columnNameSign"));
        conf.setQueryClass(properties.getProperty("queryClass"));
        conf.setPOOL_MAX_SIZE(Integer.parseInt(properties.getProperty("poolMaxSize")));
        conf.setPOOL_MIN_SIZE(Integer.parseInt(properties.getProperty("poolMinSize")));
    }

    private static DBConnPool connPool = new DBConnPool();

    // 从数据库连接池中获取链接对象
    public static Connection getCon(){
        return connPool.getConnection();
    }

    public static Connection createCon(){
        try{
            // 加载驱动对象
            Class.forName(conf.getDriver());
            // 建立链接对象
            Connection connection = DriverManager.getConnection(conf.getUrl(),
                    conf.getUser(), conf.getPwd());
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    // 关闭数据库链接方法
    public static void close(ResultSet rs, Statement ps,Connection conn){
        try{
            if(rs!=null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            if(ps!=null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            // 调用连接池的方法关闭链接
            connPool.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void close(Statement ps,Connection conn){
        try{
            if(ps!=null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
           connPool.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    // 从配置文件中获取配置信息
    public static Configuration getConf(){
        return conf;
    }
}

~~~



### 2. 使用数据表的信息生成实体类

#### 流程

##### `ColumnInfo`封装字段的信息

~~~java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnInfo {
    /**
     * 字段的名称
     */
    private String name;

    /**
     * 字段的数据类型
     */
    private String dataType;
    /**
     * 字段的键类型（0：普通键 1 主键 2 外键）
     */
    private int keyType;
}
~~~

##### `TableInfo`封装表的信息

~~~java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableInfo {

    /**
     * 表名
     */
    private String tname;

    /**
     * 所有字段信息
     */
    private Map<String,ColumnInfo> columns;

    /**
     * 如果有联合主键，那么就在这里存储
     */
    private List<ColumnInfo> priKeys;

    /**
     * 唯一主键信息
     */
    private ColumnInfo onlyKey;
	// 有参构造方法——> 没有添加Key的信息
    public TableInfo(String tableName, ArrayList<ColumnInfo> columnInfos, 
                     HashMap<String, ColumnInfo> stringColumnInfoHashMap) {
    }
}

~~~

##### 根据配置文件读取对应数据表信息

~~~java
public class TableContext {
    /**
     * 表名为Key，表信息为value,可以封装多张数据表的信息
     */
    private static Map<String,TableInfo> tables = new HashMap<String, TableInfo>();
    /**
     * 将实体类和表信息关联起来，放入Map中便于重新使用
     */
    protected static Map<Class,TableInfo> poClassTableMap = new HashMap<Class,TableInfo>();
    /**
     * 无参构造方法
     */
    private TableContext(){}
    /**
     * 在调用TableContext的相关方法是便会执行
     */
    static{
        try{
            // 获取配置信息
            Configuration configuration = DBManager.getConf();
            // 初始化获得链接对象--> 这个过程会消耗很多的资源
            Connection con = DBManager.getCon();
            // 通过链接，得到数据库的元信息
            DatabaseMetaData dbmd = con.getMetaData();
            /**
             * 从url中，获取数据库名称
             */
            String url = dbmd.getURL();
            String[] split = url.split("/");
            String s = split[split.length - 1];
            String[] split1 = s.split("\\?");
            String dBase=split1[0];

            // 获取数据库的基本元信息
            System.out.println("数据库已知的用户: "+ dbmd.getUserName());
            System.out.println("数据库的系统函数的逗号分隔列表: "+ dbmd.getSystemFunctions());
            System.out.println("数据库的时间和日期函数的逗号分隔列表: "+ dbmd.getTimeDateFunctions());
            System.out.println("数据库的字符串函数的逗号分隔列表: "+ dbmd.getStringFunctions());
            System.out.println("数据库供应商用于 'schema' 的首选术语: "+ dbmd.getSchemaTerm());
            System.out.println("数据库URL: " + dbmd.getURL());
            System.out.println("是否允许只读:" + dbmd.isReadOnly());
            System.out.println("数据库的产品名称:" + dbmd.getDatabaseProductName());
            System.out.println("数据库的版本:" + dbmd.getDatabaseProductVersion());
            System.out.println("驱动程序的名称:" + dbmd.getDriverName());
            System.out.println("驱动程序的版本:" + dbmd.getDriverVersion());

            String[] str ={"TABLE"};
            // 显示能够得到的数据库中所有的表格信息
            ResultSet tables1 = dbmd.getTables(null, null, "%", str);
            while (tables1.next()) {
                //表名
                String tableName = tables1.getString("TABLE_NAME");
                //表类型
                String tableType = tables1.getString("TABLE_TYPE");
                //表备注
                String remarks = tables1.getString("REMARKS");
                //显示表信息
                System.out.println(tableName + " - " + tableType + " - " + remarks);
            }


            ResultSet tableRet = null;
            // 判断配置信息中是否有设置单张表的信息，如果没有那就获得数据库中所有的数据表的信息
            if (!StringUtils.isEmpty(configuration.getTableName())){
                tableRet = dbmd.getTables(dBase,"%",configuration.getTableName(),str);
            }else{
                tableRet = dbmd.getTables(null, null, "%", str);
            }
            
            // 开始遍历得到符合条件的表的信息
            while (tableRet.next()){
                String tableName = (String) tableRet.getObject("TABLE_NAME");
                String tableType = tableRet.getString("TABLE_TYPE");
                
                System.out.println("表名： "+tableName + " - 类型： " + tableType );
                TableInfo tableInfo = new TableInfo(tableName,new ArrayList<ColumnInfo>(),new HashMap<String,ColumnInfo>());
                tableInfo.setTname(tableName);
                tables.put(tableName,tableInfo);
                
                // 查询表中所有字段
                ResultSet set = dbmd.getColumns(null,"%",tableName,"%");
                System.out.println(set.toString());
                Map<String,ColumnInfo> map = new HashMap<>();

               // 遍历表头字段信息
                while (set.next()){
                    String columnName = set.getString("COLUMN_NAME");
                    String columnType = set.getString("TYPE_NAME");
                    int datasize = set.getInt("COLUMN_SIZE");
                    int digits = set.getInt("DECIMAL_DIGITS");
                    int nullable = set.getInt("NULLABLE");
                    System.out.println(columnName+" "+columnType+" "+datasize+" "+digits+" "+nullable);

                    ColumnInfo columnInfo = new ColumnInfo();
                    columnInfo.setName(columnName);
                    columnInfo.setDataType(columnType);
                    columnInfo.setKeyType(0);

                    // 将单张表的所有字段存储到Map集合中
                    map.put(columnName,columnInfo);
                    tableInfo.setColumns(map);
                }

                List<ColumnInfo> list = new ArrayList<>();
                ResultSet set2=dbmd.getPrimaryKeys(null,"%",tableName);
                while (set2.next()){
                    Map<String, ColumnInfo> columns = tableInfo.getColumns();
                    String column_name =(String) set2.getObject("COLUMN_NAME");
                    System.out.println("column_name:"+column_name);
                    ColumnInfo columnInfo2 =columns.get(column_name);
                    // 设置位主键类型
                    columnInfo2.setKeyType(1);
                    list.add(columnInfo2);
                }
                tableInfo.setPriKeys(list);
                System.out.println("tableInfo.PriKeys"+tableInfo.getPriKeys());
                  
                  
				// 添加主键信息，只针对表中有一个主键，不支持外键
                if(tableInfo.getPriKeys().size()>0){
                    tableInfo.setOnlyKey(tableInfo.getPriKeys().get(0));
                }
            }
            
            if (tables.isEmpty()){
                throw new RuntimeException("没有找到数据库信息，请检查配置信息");
            }

            // 根据得到的Table信息对应的生成Java实体类文件
            createJavaFile();
            
            //加载类名与表的对应关系
            loadPdTables();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  Map<String,TableInfo> getTableInfos(){
        return tables;
    }
    
    /**
     * 加载实体类，如果还没有生成entity实体类，那么第一次加载会报错，第二次以后就可以正常加载了
     */
    public static void loadPdTables() {
        // 遍历所有的Tables中的信息
        for (TableInfo tableInfo:tables.values()){
            try {
                // 获得Tables中所有对应实体类的名称
                String className=DBManager.getConf().getPoPackage()+".entity."+ 
                    com.krest.sorm.utils.StringUtils.firstChar2UpperCase(
                    com.krest.sorm.utils.StringUtils.replaceStringSign(tableInfo.getTname()));
                className.replaceAll(" ","");
             	
                // 通过反射获取对象
                Class<?> aClass = Class.forName(className);
                poClassTableMap.put(aClass,tableInfo);

                // 测试代码
                for (TableInfo value : poClassTableMap.values()) {
                    System.out.println("poClassTableMap:"+value);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
  	/**
     * 创建与数据表信息对应的实体类文件
     */
    public static void createJavaFile(){
        // 表字段类型装换器
        TypeConvevrtor typeConvevrtor = new TypeConvertorImpl();
        Map<String,TableInfo> tables = getTableInfos();
        // 循环生成Java实体类文件
        for (TableInfo value : tables.values()) {
            JavaFileUtils.createJavaPOFile(value, typeConvevrtor);
        }
    }
}

~~~

##### 配置执行文件

###### 反射工具类

~~~java
public class ReflectUtils {
    public static Object invokeGet(String fileName,Object object){
        //得到主键的Get方法
        Method method = null;
        try {
            Class<?> c = object.getClass();
            method = c.getDeclaredMethod("get"+fileName,null);
            Object keyValue = method.invoke(object, null);
            System.out.println(keyValue);
            return keyValue;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void invokeSet(Object object,String columnLabel,Object columnValue){
        try {
            String fileName = StringUtils.firstChar2UpperCase(StringUtils.replaceStringSign(columnLabel));
            String string = columnValue.getClass().toString();
            // 时间格式的转换
            if (string.contains("Timestamp")){
                Timestamp timestamp = (Timestamp) columnValue;
                java.util.Date tspToDate = new java.util.Date(timestamp.getTime());
                Method m = object.getClass().getDeclaredMethod("set"+ fileName,
                        tspToDate.getClass());
                m.invoke(object,tspToDate);
            }else {
                Method m = object.getClass().getDeclaredMethod("set"+ fileName,
                        columnValue.getClass());
                m.invoke(object,columnValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
~~~



###### 类型转换器--> 接口

~~~java
public interface TypeConvevrtor {
    /**
     * 将数据库的字段类型转化为Java数据类型
     * @param columnType
     * @return 返回java数据类型
     */
    public  String databaseType2JavaType(String columnType);

    /**
     * 将java字段类型转化为数据库类型
     * @param javaType
     * @return 返回java数据类型
     */
    public  String javaType2DatabaseType(String javaType);
}

~~~

###### 类型转换器--> 具体实现类

~~~java
public class TypeConvertorImpl implements TypeConvevrtor {
    @Override
    public String databaseType2JavaType(String columnType) {
        if ("varchar".equalsIgnoreCase(columnType)||
                "char".equalsIgnoreCase(columnType)||
                "LONGTEXT".equalsIgnoreCase(columnType)||
                "TEXT".equalsIgnoreCase(columnType)){
            return "String";
        }else if ("int".equalsIgnoreCase(columnType)||
                    "BIT".equalsIgnoreCase(columnType)||
                    "INT UNSIGNED".equalsIgnoreCase(columnType)||
                    "tinyint".equalsIgnoreCase(columnType)||
                    "tinyint UNSIGNED".equalsIgnoreCase(columnType)||
                    "smallint".equalsIgnoreCase(columnType)||
                    "integer".equalsIgnoreCase(columnType)){
                return "Integer";
        }else if("bigint".equalsIgnoreCase(columnType)||
                "BIGINT UNSIGNED".equalsIgnoreCase(columnType)){
            return "Long";
        }else if("float".equalsIgnoreCase(columnType)||
                "double".equalsIgnoreCase(columnType)){
            return "DOuble";
        }else if("clob".equalsIgnoreCase(columnType)){
            return "java.sql.CLob";
        }else if("blob".equalsIgnoreCase(columnType)||
                "LONGBLOB".equalsIgnoreCase(columnType)) {
            return "java.sql.Blob";
        }else if("date".equalsIgnoreCase(columnType)||"datetime".equalsIgnoreCase(columnType)){
            return "java.util.Date";
        }else if("time".equalsIgnoreCase(columnType)){
            return "java.sql.time";
        }else if("Timestamp".equalsIgnoreCase(columnType)){
            return "java.sql.Timestamp";
        }else {
            throw new RuntimeException(columnType+"没有该数据类型，请添加");
        }
    }
    @Override
    public String javaType2DatabaseType(String javaType) {
        return null;
    }
}

~~~



###### Java每个字段的SetGet

~~~java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JavaFieldGetSet {
    /**
     *  属性源码信息
     */
    private String fieldInfo;

    /**
     * get源码信息，用来封装字段对应的get方法String
     */
    private String getInfo;

    /**
     * set方法源码信息，用来封装字段对应的Set方法String
     */
    private String setInfo;
}

~~~



###### `String`字段转换器工具

~~~java
public class StringUtils {

    /**
     * 将首字母大写
     * @return
     */
    public static String firstChar2UpperCase(String str){
        // abc-> Abc
        return str.toUpperCase().substring(0, 1)+str.substring(1);
    }
    // 将固定的字段格式化
    public static String replaceStringSign(String name){
        String columnNameSign = DBManager.getConf().getColumnNameSign();
        String tableNameSign = DBManager.getConf().getTableNameSign();
        String sign;
        String str=null;
        if (!org.springframework.util.StringUtils.isEmpty(columnNameSign) &&
            !org.springframework.util.StringUtils.isEmpty(tableNameSign)){
            if(columnNameSign.equals(tableNameSign)){
                sign=columnNameSign;
                str=getString(name,sign);
            }else {
                if (name.contains(columnNameSign) && name.contains(tableNameSign)){
                    throw new RuntimeException("数据库或表命名不规范！！！");
                }
                if (name.contains(columnNameSign)){
                    sign=columnNameSign;
                    str=getString(name,sign);
                }
                if (name.contains(tableNameSign)) {
                    sign = tableNameSign;
                    str = getString(name, sign);
                }
            }
        }else {
            if(!org.springframework.util.StringUtils.isEmpty(columnNameSign)){
                sign=columnNameSign;
                str=getString(name,sign);
            }
            if(!org.springframework.util.StringUtils.isEmpty(tableNameSign)){
                sign=tableNameSign;
                str=getString(name,sign);
            }
        }
        return str;
    }
    //去掉表中所有的个字段符号
    private static String getString(String name,String sign) {
        StringBuilder sName = new StringBuilder();
        // 切换大小写
        if (name.contains(sign)){
            String[] s = name.split(sign);
            for (int i = 0; i < s.length; i++) {
                if (i==0){
                    sName.append(s[i]);
                }else{
                    char ch =  s[i].charAt(0);
                    char t = Character.toUpperCase(ch);
                    String rest = s[i].substring(1);
                    s[i] = t+rest ;
                    sName.append(s[i]);
                }
            }
        }else {
            sName.append(name);
        }
        return sName.toString();
    }
}

~~~





###### 实体类文件生成器

~~~java
public class JavaFileUtils {
    
    /**
     * 根据字段信息生成Java属性信息 如var name -》 private String userName，以及相应的 Get和 Set方法
     * @param columnInfo 字段信息
     * @param convevrtor    转换器
     * @return
     */
    public static JavaFieldGetSet createFieldGetSet(ColumnInfo columnInfo, TypeConvevrtor convevrtor){
        // 用来封装每个字段对应的String信息
        JavaFieldGetSet jfgs = new JavaFieldGetSet();、
        // 封转字段信息
        String name = columnInfo.getName();
        String sName = StringUtils.replaceStringSign(name);
        String javaFieldType = convevrtor.databaseType2JavaType(columnInfo.getDataType());
        
        // 行首添加制表符，行尾添加换行符，拼接字符串
        jfgs.setFieldInfo("\tprivate "+ javaFieldType +" " +sName +";\n" );

        // 生成相应的Get 如 public String getYUSerName(){return username}
        StringBuilder getStr = new StringBuilder();
        String sNameToString = sName.toString();
        getStr.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(sNameToString)+"(){\n");
        getStr.append("\t\treturn "+sName+";\n");
        getStr.append("\t}\n");
        jfgs.setGetInfo(getStr.toString());

        //// 生成相应的Set 如 public String getYUSerName(){return username}
        StringBuilder setStr = new StringBuilder();
        setStr.append("\tpublic void set"+StringUtils.firstChar2UpperCase(sNameToString)+"(");
        setStr.append(javaFieldType+" "+sName+"){\n");
        setStr.append("\t\tthis."+sName+"="+sName+";\n");
        setStr.append("\t}\n");
        jfgs.setSetInfo(setStr.toString());
        return jfgs;
    }

    /**
     * 根据表信息，生成Java类的源码信息
     * @param tableInfo 表信息
     * @param convevrtor 数据类类型转化器
     * @return Java类的源码String字段
     */
    public static String createJavaSrc(TableInfo tableInfo,TypeConvevrtor convevrtor){
        StringBuilder srcStr = new StringBuilder();

        Map<String, ColumnInfo> columns = tableInfo.getColumns();
        List<JavaFieldGetSet> javaFields = new ArrayList<>();

        // 得到所有的表信息的Set/Get方法
        for(ColumnInfo c:columns.values()){
            javaFields.add(createFieldGetSet(c,convevrtor));
        };

        // 生成entity   Package语句
        srcStr.append("package "+ DBManager.getConf().getPoPackage()+".entity;\n\n");

        // 生成import语句
        srcStr.append("import java.util.Date;\n");
        srcStr.append("import lombok.AllArgsConstructor;\n");
        srcStr.append("import lombok.Data;\n");
        srcStr.append("import lombok.NoArgsConstructor;\n\n\n");

        // 生成注解
        srcStr.append("@Data\n");
        srcStr.append("@NoArgsConstructor\n");
        srcStr.append("@AllArgsConstructor\n");

        // 生成类名的声明语句
        srcStr.append("public class "+StringUtils.firstChar2UpperCase(StringUtils.replaceStringSign(tableInfo.getTname()))+" {\n");

        // 生成属性列表
        for (JavaFieldGetSet javaField : javaFields) {
            srcStr.append(javaField.getFieldInfo());
        }
        // 添加换行符号
        srcStr.append("\n\n");
        
        //  生成get方法列表
        for (JavaFieldGetSet javaField : javaFields) {
            srcStr.append(javaField.getGetInfo());
        }
        srcStr.append("\n\n");

        //  生成Set方法列表
        for (JavaFieldGetSet javaField : javaFields) {
            srcStr.append(javaField.getSetInfo());
        }
        srcStr.append("\n\n");

        // 生成结束
        srcStr.append("}\n");
        return srcStr.toString();
    }

    /**
     * 新建Java实体类文件
     * @param tableInfo
     * @param convevrtor
     */
    public static void createJavaPOFile(TableInfo tableInfo,TypeConvevrtor convevrtor){
        
        String src = createJavaSrc(tableInfo,convevrtor);
        // 通过流，将生成的String写入到文件中
        StringBuilder srcFinalPath = new StringBuilder();
        // 获取项目目录
        String srcPath = DBManager.getConf().getSrcPath();
        // 获取包路径
        String poPackage = DBManager.getConf().getPoPackage();
        System.out.println(DBManager.getConf().toString());
        String[] poPackages = poPackage.split("\\.");

        // 对包路径进行格式化
        srcFinalPath.append(srcPath);
        for (String aPackage : poPackages) {
            srcFinalPath.append("\\"+aPackage);
        }

        // 生成实体类路径地址
        String entityFilePath=srcFinalPath.append("\\entity").toString();
        File entityFile = new File(entityFilePath);
        if(!entityFile.exists()){
            boolean mkdir = entityFile.mkdir();
        }

        BufferedWriter bw = null;

        try {
            String entityFileName=entityFile.getAbsoluteFile()+"\\"+StringUtils.firstChar2UpperCase(StringUtils.replaceStringSign(tableInfo.getTname()))+".java";
            File f=new File(entityFileName);
            if (!f.isFile()&&!f.exists()){
                System.out.println("************创建Java文件");
                bw = new BufferedWriter(new FileWriter(entityFileName));
                bw.write(src);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

~~~



### 3. 执行数据库的CRUD

说明：直接使用原生的`Sql`语句进行操作

#### 流程

##### 建立查询对象

~~~java
public class QueryFactory  {

    private static QueryFactory queryFactory = new QueryFactory();
    /**
     *     创建原型对象
     */
    private static Query protoTypeObj;

    static {
        // 加载指定 Query 类
        try {
            Class aClass = Class.forName(DBManager.getConf().getQueryClass());
            protoTypeObj = (Query) aClass.newInstance();
            System.out.println("加载Query对象文件");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //私有构造器
    private QueryFactory(){}

    public static Query createQuery() throws CloneNotSupportedException {
        Query clone =(Query) protoTypeObj.clone();
        return clone;
    }
}

~~~

##### 建立查询对象的具体实现

~~~java
public class MySqlQuery extends Query{

    @Override
    public Object pageQery(Long page, Long limit) {
        return null;
    }
}
~~~

##### 测试程序

~~~java

public class test {
    public static void main(String[] args) throws Exception {
        MySqlQuery mySqlQuery = new MySqlQuery();
        // 测试 queryRows
        List<DemoAliAccount> list = mySqlQuery.queryRows("select * from demo_ali_account where money>? and money<?;",
                DemoAliAccount.class, new Object[]{1, 6000});
        for (DemoAliAccount o : list) {
            System.out.println(o.getName()+":"+o.getMoney());
        }
        
        //  测试 queryValue
        Object o = mySqlQuery.queryValue("select money from demo_ali_account where count_id=?;",
                new Object[]{"1"});
        System.out.println(o);
        
        //  测试数据库连接池的效率
        Long start =System.currentTimeMillis();
        for (int i=0 ; i< 1000;i++){
            QueryTest();
        }
        Long end = System.currentTimeMillis();
        // 结果不加连接池花费32s, 加入连接池花费4s；
        System.out.println(end-start);


    }
    private static void QueryTest() throws CloneNotSupportedException {
        Query query = QueryFactory.createQuery();
        List<DemoAliAccount> list = query.queryRows("select * from demo_ali_account where money>? and money<?;",
                DemoAliAccount.class, new Object[]{1, 6000});
        for (DemoAliAccount o : list) {
            System.out.println(o.getName()+":"+o.getMoney());
        }
    }
}

~~~







##### 抽象查询方法（设计模式--模版方法）

~~~java
public abstract class Query implements Cloneable, Serializable {

    //复制对象的Clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        return obj;
    }
    /**
     * 执行查询的模版方法
     * @param sql
     * @param params
     * @param clazz
     * @param callBack
     * @return
     */
    public Object executeQueryTemplate(String sql,Object[] params,Class clazz,CallBack callBack){
        Connection con = DBManager.getCon();
        // 用来存放查询的结果
        List list = null;
        PreparedStatement ps=null;
        Integer integer = 0;
        ResultSet resultSet = null;
        try {
            ps= con.prepareStatement(sql);
            JDBCUtils.handleParams(ps, params);
            resultSet = ps.executeQuery();
            // 显示最终的SQL语句
            System.out.println(ps);
            return callBack.doExcute(con,ps,resultSet);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            DBManager.close(ps,con);
        }
    }

    /**
     * 帮助我们直接执行一个DML语句
     * @param Sql
     * @param params
     * @return 执行Sql影响的数据库行数
     */
    public int executeDML(String Sql,Object[] params){
        Connection con = DBManager.getCon();
        PreparedStatement ps=null;
        Integer integer=0;
        try {
            ps= con.prepareStatement(Sql);
            integer = JDBCUtils.handleParams(ps, params);
            System.out.println(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(ps,con);
        }
        return integer;
    };

    /**
     * 将数据存储到数据库中
     * 将对象中的null元素不进行存储
     * @param object
     */

    public void insert(Object object) {
        //通过反射获取基本的数据信息
        Class<?> aClass = object.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(aClass);
        Map<String, ColumnInfo> columns = tableInfo.getColumns();

        // 开始拼接Sql语句
        StringBuilder sql = new StringBuilder();
        sql.append("insert into "+tableInfo.getTname()+" (");

        // 得到插入的数据信息
        List<Object> params = new ArrayList<>();

        Field[] fs = aClass.getDeclaredFields();
        // 计算不为空的属性值
        int notNullField = 0;

        for (Field f : fs) {
            String fName = StringUtils.firstChar2UpperCase(f.getName());
            Object fValue = ReflectUtils.invokeGet(fName,object);
            if (!org.springframework.util.StringUtils.isEmpty(fValue)){

                notNullField++;
                for (ColumnInfo value : columns.values()) {
                    String columnsName = StringUtils.replaceStringSign(value.getName());
                    if (fName.equalsIgnoreCase(columnsName)){
                        sql.append(value.getName()+",");
                        params.add(fValue);
                    }
                }
            }
        }
        // 替换指定位置的字符
        sql.setCharAt(sql.length()-1,')');

        sql.append(" values ( ");
        for (int i=0; i<notNullField; i++){
            sql.append("?,");
        }
        sql.setCharAt(sql.length()-1,')');
        System.out.println(sql);

        executeDML(sql.toString(),params.toArray());
    }

    /**
     * 根据Id删除数据信息
     * @param clazz
     * @param id
     */
    public void delete(Class clazz, Object id) {
        //通过Class对象绑定tableInfo
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
        // 获得主键信息
        ColumnInfo onlyKey = tableInfo.getOnlyKey();
        // 编写Sql语句的执行String
        String sql="delete from "+tableInfo.getTname()+" where "+onlyKey.getName()+"=? ";
        // 执行Sql
        int i = executeDML(sql, new Object[]{id});
        System.out.println("删除了"+i+"条数据");

    }

    /**
     * 根据对象，删除信息
     * @param object
     * @return
     * @throws Exception
     */
    public Integer delete(Object object) throws Exception {
        // 通过反射获取Table信息
        TableInfo tableInfo = TableContext.poClassTableMap.get(object.getClass());
        // 获得主键信息
        ColumnInfo onlyKey = tableInfo.getOnlyKey();
        //得到反射调用Get方法得到d
        String fileName=StringUtils.firstChar2UpperCase(StringUtils.replaceStringSign(onlyKey.getName()));
        Object keyValue = ReflectUtils.invokeGet(fileName, object);
        //编写Sql语句的执行String
        String sql="delete from "+tableInfo.getTname()+" where "+onlyKey.getName()+"=? ";
        //执行Sql
        int i = executeDML(sql, new Object[]{keyValue});
        System.out.println("删除了"+i+"条数据");
        return i;
    }

    /**
     * update 方法会比较复杂一些
     * 如: mySqlQuery.update(aliAccount,new String[]{"name","peopleId","money"});
     * @param object
     * @param fieldNames
     * @return
     */
    public int update(Object object, String[] fieldNames) {
        // 更新语句模版: UPDATE table_name SET field1=new-value1, field2=new-value2 where id=?
        Class<?> aClass = object.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(aClass);
        List<Object> params = new ArrayList<>();
        Map<String, ColumnInfo> columns = tableInfo.getColumns();
        //获得唯一主键信息
        ColumnInfo onlyKey = tableInfo.getOnlyKey();
        // 获取主键的id值
        String s = StringUtils.firstChar2UpperCase(StringUtils.replaceStringSign(onlyKey.getName()));
        Object id = ReflectUtils.invokeGet(s, object);

        System.out.println("tableInfo:"+tableInfo.toString());

        // 开始拼接Sql语句
        StringBuilder sql = new StringBuilder();
        sql.append("update "+tableInfo.getTname()+" set ");

        for (String fieldName : fieldNames) {
            String fName = StringUtils.firstChar2UpperCase(fieldName);
            Object fValue = ReflectUtils.invokeGet(fName,object);
            // 验证
            for (ColumnInfo value : columns.values()) {
                String columnsName = StringUtils.replaceStringSign(value.getName());
                if (fName.equalsIgnoreCase(columnsName)){
                    sql.append(value.getName()+"=?,");
                    params.add(fValue);
                }
            }
        }

        sql.setCharAt(sql.length()-1,' ');
        sql.append(" where ");
        sql.append(onlyKey.getName()+"="+id);

        System.out.println(sql);
        return executeDML(sql.toString(),params.toArray());
    }

    public List queryRows(final String sql, final Class clazz, final Object[] params) {
        // 用来存放查询的结果


        return (List)executeQueryTemplate(sql, params, clazz, new CallBack() {
            @Override
            public Object doExcute(Connection con, PreparedStatement ps, ResultSet rs) {
                List list = null;
                try {

                    ResultSetMetaData metaData = rs.getMetaData();
                    // 处理返回的多行数据
                    while (rs.next()){
                        if (list == null){
                            list = new ArrayList();
                        }
                        // 调用 entity 实体类的构造函数生成对象
                        Object rowObj = clazz.newInstance();
                        // 处理多行数据中的多列数据
                        for (int i= 0; i<metaData.getColumnCount();i++){
                            // 得到返回值
                            String columnLabel = metaData.getColumnLabel(i+1);
                            Object columnValue = rs.getObject(i+1);

                            if (!org.springframework.util.StringUtils.isEmpty(columnValue)){
                                System.out.println("columnLabel:"+columnLabel);
                                System.out.println("columnValue:"+columnValue);
                                //通过调用set方法，设置对象的值
                                ReflectUtils.invokeSet(rowObj,columnLabel,columnValue);
                            }
                        }
                        list.add(rowObj);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return list;
            }
        });
    }

    public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
        List list = queryRows(sql, clazz, params);
        return (list==null&&list.size()>0)?null:list.get(0);
    }


    public Object queryValue(String sql, Object[] params) {

        // 利用方法模版进行回调，减少重复代码
        return executeQueryTemplate(sql, params, null, new CallBack() {

            @Override
            public Object doExcute(Connection con, PreparedStatement ps, ResultSet rs) {
                Object value=null;
                try {
                    while (rs.next()){
                        value = rs.getObject(1);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return value;
            }
        });

    }


    public Number queryNumber(String sql, Object[] params) {
        return (Number)queryValue(sql,params);
    }

    /**
     * 分页查询方法
     * @param page 第几页
     * @param limit    每页显示几项
     * @return     分页查询内容
     */
    public abstract Object pageQery(Long page, Long limit);
}

~~~



##### 辅助工具类

###### 反射工具类

~~~java
public class ReflectUtils {
    public static Object invokeGet(String fileName,Object object){
        //得到主键的Get方法
        Method method = null;
        try {
            Class<?> c = object.getClass();
            method = c.getDeclaredMethod("get"+fileName,null);
            Object keyValue = method.invoke(object, null);
            System.out.println(keyValue);
            return keyValue;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void invokeSet(Object object,String columnLabel,Object columnValue){
        try {
            String fileName = StringUtils.firstChar2UpperCase(StringUtils.replaceStringSign(columnLabel));
            String string = columnValue.getClass().toString();
            // 时间格式的转换
            if (string.contains("Timestamp")){
                Timestamp timestamp = (Timestamp) columnValue;
                java.util.Date tspToDate = new java.util.Date(timestamp.getTime());
                Method m = object.getClass().getDeclaredMethod("set"+ fileName,
                        tspToDate.getClass());
                m.invoke(object,tspToDate);
            }else {
                Method m = object.getClass().getDeclaredMethod("set"+ fileName,
                        columnValue.getClass());
                m.invoke(object,columnValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
~~~



###### 执行具体`Sql`的回调接口

~~~java
public interface CallBack {
    public Object doExcute(Connection con, PreparedStatement ps, ResultSet rs);
}
~~~

###### `JDBC`执行工具

~~~java
public class JDBCUtils {
    /**
     * 执行参数化的Sql语句
     * @param ps
     * @param params
     */
    public static Integer handleParams(PreparedStatement ps,Object[] params){
        int count = 0;
        if (params!=null){
            try {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(1+i,params[i]);
                    count ++;
                }
                boolean execute = ps.execute();
                if (execute){
                    System.out.println("Sql语句:【"+ps+"】  执行成功");
                }else {
                    throw new RuntimeException("执行错误");
                }
                return count;
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return 0;
    }
}
~~~



