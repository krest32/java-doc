

# Sql查询的基本

## 查询的基本原理

1. 单表查询：根据WHERE条件过滤表中的记录，形成中间表（这个中间表对用户是不可见的）；然后根据SELECT的选择列选择相应的列进行返回最终结果。
2. 两表连接查询：对两表求积（笛卡尔积）并用ON条件和连接连接类型进行过滤形成中间表；然后根据WHERE条件过滤中间表的记录，并根据SELECT指定的列返回查询结果。
3. 多表连接查询：先对第一个和第二个表按照两表连接做查询，然后用查询结果和第三个表做连接查询，以此类推，直到所有的表都连接上为止，最终形成一个中间的结果表，然后根据WHERE条件过滤中间表的记录，并根据SELECT指定的列返回查询结果。
   理解SQL查询的过程是进行SQL优化的理论依据。



# 常用Sql语句

## Select

~~~Sql
SELECT
    column_name,
    column_name
FROM
    table_name;

SELECT
    *
FROM
    table_name;

# DISTINCT 关键词用于返回唯一不同的值。
SELECT
    DISTINCT column_name,
    column_name
FROM
    table_name;

# WHERE 子句用于提取那些满足指定条件的记录。
SELECT
    column_name,
    column_name
FROM
    table_name
WHERE
    column_name operator value;

# AND & OR 运算符用于基于一个以上的条件对记录进行过滤。
SELECT
    *
FROM
    Websites
WHERE
    country = 'CN'
    AND alexa > 50;
    
SELECT
    *
FROM
    Websites
WHERE
    country = 'USA'
    OR country = 'CN';
    
# 结合 and 和 or
SELECT
    *
FROM
    Websites
WHERE
    alexa > 15
    AND (
        country = 'CN'
        OR country = 'USA'
    );

# 选取数据库中的部分数据
SELECT
    *
FROM
    Websites
LIMIT
    2;
    
    
SELECT
    TOP 50 PERCENT *
FROM
    Websites;

# 进行排序
SELECT
    column_name,
    column_name
FROM
    table_name
ORDER BY
    column_name,
    column_name ASC | DESC;
~~~



## INSERT INTO

~~~Sql
# 插入新的数据
INSERT INTO
    table_name (column1, column2, column3,...)
VALUES
    (value1, value2, value3,...);

# 复制 "apps" 中的数据插入到 "Websites" 中：
INSERT INTO
    Websites (name, country)
SELECT
    app_name,
    country
FROM
    apps;
~~~



## Update

~~~sql
# 更新数据库
UPDATE
    Websites
SET
    alexa = '5000',
    country = 'USA'
WHERE
    name = '菜鸟教程';
~~~



## Delete

~~~Sql
# 删除相关信息
DELETE FROM
    table_name
WHERE
    some_column = some_value;
~~~



##  通配符

~~~SQL
# url 以字母 "https" 开始的所有网站：
SELECT
    *
FROM
    Websites
WHERE
    url LIKE 'https%';

# 选取 name 以一个任意字符开始，然后是 "oogle" 的所有客户：
SELECT
    *
FROM
    Websites
WHERE
    name LIKE '_oogle';

~~~



## In

~~~Sql
# IN 操作符允许您在 WHERE 子句中规定多个值。
SELECT
    column_name(s)
FROM
    table_name
WHERE
    column_name IN (value1, value2,...);

SELECT
    *
FROM
    Websites
WHERE
    NAME IN ('Google', '菜鸟教程');
~~~



## BETWEEN 

~~~SQl
# 取介于两个值之间的数据范围内的值。这些值可以是数值、文本或者日期。
SELECT
    column_name(s)
FROM
    table_name
WHERE
    column_name BETWEEN value1
    AND value2;
    
SELECT
    *
FROM
    Websites
WHERE
    alexa BETWEEN 1
    AND 20;

# not Between
SELECT
    *
FROM
    Websites
WHERE
    alexa NOT BETWEEN 1
    AND 20;
    

# IN 的 BETWEEN  alexa 介于 1 和 20 之间但 country 不为 USA 和 IND 的所有网站：
SELECT
    *
FROM
    Websites
WHERE
    (
        alexa BETWEEN 1
        AND 20
    )
    AND country NOT IN ('USA', 'IND');

~~~



## 别名

~~~Sql
# 可以为表名称或列名称指定别名
SELECT
    column_name AS alias_name
FROM
    table_name;
~~~



## Join

~~~sql
# 左连接
SELECT
    Websites.name,
    access_log.count,
    access_log.date
FROM
    Websites
    LEFT JOIN access_log ON Websites.id = access_log.site_id
ORDER BY
    access_log.count DESC;
~~~



## union

~~~sql
# UNION 操作符用于合并两个或多个 SELECT 语句的结果集。
# 请注意，UNION 内部的每个 SELECT 语句必须拥有相同数量的列。列也必须拥有相似的数据类型
SELECT
    country
FROM
    Websites
UNION
ALL
SELECT
    country
FROM
    apps
ORDER BY
    country;
~~~



##  CREATE 

~~~SQl
CREATE TABLE Persons
(
	PersonID int,
	LastName varchar(255),
	FirstName varchar(255),
	Address varchar(255),
	City varchar(255)
);
~~~

~~~Sql
CREATE TABLE `t_order` (
  `id` char(19) NOT NULL DEFAULT ''COMMENT '订单号',
  `order_detail_id` char(19) DEFAULT NULL COMMENT '订单详细Id',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `mobile` varchar(11) DEFAULT NULL COMMENT '会员手机',
  `total_fee` decimal(10,2) DEFAULT '0.01' COMMENT '订单金额（分）',
  `pay_type` tinyint(3) DEFAULT NULL COMMENT '支付类型（1：微信 2：支付宝）',
  `status` tinyint(3) DEFAULT NULL COMMENT '订单状态（0：未支付 1：已支付 2: 超时取消）',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_order_detail_id` (`order_detail_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
~~~





## 约束

~~~SQl
在 SQL 中，我们有如下约束：
NOT NULL - 指示某列不能存储 NULL 值。
UNIQUE - 保证某列的每行必须有唯一的值。
PRIMARY KEY - NOT NULL 和 UNIQUE 的结合。确保某列（或两个列多个列的结合）有唯一标识，有助于更容易更快速地找到表中的一个特定的记录。
FOREIGN KEY - 保证一个表中的数据匹配另一个表中的值的参照完整性。
CHECK - 保证列中的值符合指定的条件。
DEFAULT - 规定没有给列赋值时的默认值。
~~~



## Drop

~~~sql
# 删除某个索引
ALTER TABLE
    table_name DROP INDEX index_name

# 删除表
DROP TABLE table_name

# 删除数据库
DROP DATABASE database_name
~~~



## ALTER 

~~~sql
# 在表中添加列
ALTER TABLE
    table_name
ADD
    column_name datatype
    
# 删除表中的列（某些数据库不允许该操作）
ALTER TABLE
    table_name DROP COLUMN column_name
    
# 改变表中列的数据类型
ALTER TABLE
    table_name
MODIFY
    COLUMN column_name datatype
~~~



## AUTO INCREMENT

~~~sql
# 定义自增
CREATE TABLE Persons
(
	ID int NOT NULL AUTO_INCREMENT,
	LastName varchar(255) NOT NULL,
	FirstName varchar(255),
	Address varchar(255),
	City varchar(255),
	PRIMARY KEY (ID)
)

# 修改每次自增100
ALTER TABLE
    Persons AUTO_INCREMENT = 100
~~~



# 函数



##  AVG() 

~~~sql
# 求取平均值
SELECT AVG(column_name) FROM table_name

# avg应用 —— 选择访问量高于平均访问量的 "site_id" 和 "count"：
SELECT
    *
FROM
    websites
WHERE
    alexa > (
        SELECT
            AVG(alexa)
        FROM
            websites
    );
~~~



## COUNT()

~~~sql
# 返回指定列的值的数目（NULL 不计入）
SELECT COUNT(column_name) FROM table_name;

# count 应用
SELECT
    COUNT(count) AS nums
FROM
    access_log
WHERE
    site_id = 3;
~~~



## FIRST() / LAST() 

（只有 MS Access 支持 FIRST() 函数。）

~~~sql
# 返回指定的列中第一个记录的值。
SELECT column_name FROM table_name ORDER BY column_name ASC LIMIT 1;

# 应用
SELECT
    name AS FirstSite
FROM
    Websites
LIMIT
    1;
~~~



## MAX() 

~~~sql
# 选取在最大值
SELECT
    MAX(alexa) AS max_alexa
FROM
    websites;
~~~



## MIN() 

~~~sql
# 选取最小值
SELECT
    MIN(alexa) AS min_alexa
FROM
    websites;
~~~



## SUM()

~~~sql
# 去取总和
SELECT
    SUM(alexa) AS nums
FROM
    websites;
~~~



## GROUP BY

​		用于结合聚合函数，根据一个或多个列对结果集进行分组。

~~~sql
 # 统计 access_log 各个 site_id 的访问量：
SELECT NAME, SUM(url)  FROM  websites GROUP  BY  NAME


# 多表连接
SELECT
    Websites.name,
    COUNT(access_log.aid) AS nums
FROM
    access_log
    LEFT JOIN Websites ON access_log.site_id = Websites.id
GROUP BY
    Websites.name;
~~~



## HAVING

增加 HAVING 子句原因是，WHERE 关键字无法与聚合函数一起使用。HAVING 子句可以让我们筛选分组后的各组数据。

~~~SQl
# 想要查找总访问量大于 200 的网站
SELECT
    Websites.name,
    Websites.url,
    SUM(access_log.count) AS nums
FROM
    (
        access_log
        INNER JOIN Websites ON access_log.site_id = Websites.id
    )
GROUP BY
    Websites.name
HAVING
    SUM(access_log.count) > 200;
~~~



## UCASE()

把字段的值转换为大写



## LCASE()

 函数把字段的值转换为小写。



## MID() 

MID() 函数用于从文本字段中提取字符。

~~~sql
# 从 "Websites" 表的 "name" 列中提取前 4 个字符：
SELECT
    MID(column_name, start [,length])
FROM
    table_name;
    
    
SELECT
    MID(name, 1, 4) AS ShortTitle
FROM
    Websites;
~~~



## LEN() 函数

LEN() 函数返回文本字段中值的长度。

~~~sql
SELECT LEN(column_name) FROM table_name;

SELECT
    name,
    LENGTH(url) as LengthOfURL
FROM
    Websites;
~~~



## NOW()

返回当前系统的日期和时间。

~~~sql
SELECT
    name,
    url,
    Now() AS date
FROM
    Websites;
~~~



## FORMAT()

函数用于对字段的显示进行格式化。

~~~sql
SELECT
    FORMAT(column_name, format)
FROM
    table_name;

# 从 "Websites" 表中选取 name, url 以及格式化为 YYYY-MM-DD 的日期：
SELECT
    name,
    url,
    DATE_FORMAT(Now(), '%Y-%m-%d') AS date
FROM
    Websites;
~~~

