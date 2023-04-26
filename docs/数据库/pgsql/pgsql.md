# PGSql

## 资料来源

+ [探秘PG带你玩转PostgreSQL](https://juejin.cn/post/7156408589718913038)
+ [PG常用指令大总结](https://juejin.cn/post/7161998606029815816)

## 表空间

### 介绍

表空间是磁盘上Postgre	SQL存储包含数据库对象的数据文件的位置，例如，索引,和表格。

PostgreSQL使用表空间将逻辑名称映射到磁盘上的物理位置。

PostgreSQL附带两个默认表空间:

- `pg_default`表空间存储用户数据。
- `pg_global`表空间存储全局数据。

表空间允许我们控制PostgreSQL的磁盘布局。使用表空间有两个主要优点:

- 首先，如果初始化群集的分区空间不足，我们可以在不同的分区上创建一个新的表空间，并使用它，直到重新配置系统。
- 其次，我们可以使用统计信息来优化数据库性能。例如，我们可以将频繁访问的索引或表放在执行速度非常快的设备上，例如固态设备，并将包含存档数据的表放在速度较慢的设备上。

### 语法

~~~sql
-- 创建新的表空间
CREATE TABLESPACE tablespace_name
OWNER user_name
LOCATION directory_path;

-- 示例
CREATE TABLESPACE oz_user 
LOCATION 'C:\pgdata\user';

-- 修改表空间
-- 要重命名表空间
ALTER TABLESPACE tablespace_name 
RENAME TO new_name;
-- 示例
ALTER TABLESPACE table1 
RENAME TO table2;


-- 要更改表空间的所有者，
ALTER TABLESPACE tablespace_name 
OWNER TO new_owner;
-- 示例
ALTER TABLESPACE table2 
OWNER to oz;


-- 以下语句更改表空间的参数:
ALTER TABLESPACE tablespace_name 
SET parameter_name = value;

-- 删除表空间
DROP TABLESPACE [IF EXISTS] tablespace_name;
~~~



## 备份

### 介绍

**前言**: 在本文中，我们将学习如何使用`pg_dump`和`pg_dumpall`命令备份数据库。

备份数据库是数据库管理中最关键的任务之一。在备份数据库之前，应考虑以下备份类型:

- 全部/部分数据库
- 数据和结构，或仅结构
- 恢复时间
- 恢复性能

PostgreSQL提供了`pg_dump`和`pg_dumpall`命令帮助我们轻松有效地备份数据库。

对于希望查看快速备份数据库的命令的用户，可以参考以下命令:

```r
pg_dump -U username -W -F t database_name > c:\backup_file.tar
```

在下一节中，我们将逐步学习如何备份一个数据库、所有数据库以及仅备份数据库对象。



## 用户管理

### 要创建新角色

~~~sql
-- 要创建新角色，请使用CREATE ROLE语句，声明如下:
CREATE ROLE role_name;

-- 查询所有用户
SELECT rolname FROM pg_roles;
~~~

### 角色属性

角色的属性定义该角色的权限，包括登录、超级管理员、创建数据库、创建角色、密码等:

~~~sql
-- 基本语法
CREATE ROLE name WITH option;

-- 登陆角色
CREATE ROLE adi 
LOGIN 
PASSWORD 'adi123';


-- 超级用户
CREATE ROLE superidol 
SUPERUSER 
LOGIN 
PASSWORD 'superidol123';

-- 可以创建数据库角色
CREATE ROLE dba 
CREATEDB 
LOGIN 
PASSWORD 'dba123';

-- 创建有效期角色
CREATE ROLE dev WITH
LOGIN
PASSWORD 'dev123'
VALID UNTIL '2023-01-01';

-- 创建有链接限制的角色
CREATE ROLE api
LOGIN
PASSWORD 'api123'
CONNECTION LIMIT 1000;	
~~~



## 授权管理

### Grant

使用LOGIN属性创建角色后，该角色可以登录到PostgreSQL数据库服务器。但是，它无法对表、视图、函数等数据库对象执行任何操作。

例如，用户角色无法从表中选择数据或执行特定函数。

允许用户角色与数据库对象，我们需要使用 `GRANT`语句 对用户角色授予数据库对象操作权限。

以下例子展示了`GRANT`向角色授予一个或多个表操作权限的语句:

~~~sql
GRANT privilege_list | ALL 
ON  table_name
TO  role_name;
~~~

#### 简单示例

~~~sql
-- 创建用户
create role abcd 
login 
password 'Abcd1234';

-- 创建表
create table user (
    user_id int generated always as identity,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(255) not null unique,
    phone varchar(25) not null,
    primary key(user_id)
);

-- 授予查询权限
GRANT SELECT 
ON user 
TO abd;

-- 授予其他权限
GRANT INSERT, UPDATE, DELETE
ON user 
TO abcd;
~~~

#### 其他示例

~~~sql
-- 表上的所有权限授予角色
GRANT ALL
ON user
TO abcd;

-- 向角色授予schema中所有表的所有权限
GRANT ALL
ON ALL TABLES
IN SCHEMA "public"
TO abcd;

-- 授予所有表的SELECT权限
GRANT SELECT
ON ALL TABLES
IN SCHEMA "public"
TO reader;
~~~

### REVOK

`REVOKE`语句撤销先前从角色授予的数据库对象权限。

以下显示`REVOKE`的语法：从角色撤销一个或多个表的权限的语句:

```sql
REVOKE privilege | ALL
ON TABLE table_name |  ALL TABLES IN SCHEMA schema_name
FROM role_name;
复制代码
```

在上面的语法中：

- 首先，指定要撤销的一个或多个权限。可以使用`ALL`指定撤销所有权限。
- 第二，`ON`关键字后指定表。可以使用`ALL TABLES`指定从schema中的所有表撤销指定的权限。
- 第三，`FROM`关键字后指定要从中撤销权限的角色的名称。

#### 简单示例

~~~sql
-- 收回查找权限
REVOKE SELECT
ON dept
FROM oz;

-- 收回所有权限
REVOKE ALL
ON user
FROM oz;
~~~

### 角色组

作为一个组来管理角色更容易，这样我们就可以从整个组中授予或撤销特权，而不是在单个角色上这样做。

通常，我们会创建一个角色组，然后将角色组中的成员资格授予各个角色。

按照惯例，角色组没有`LOGIN`权限。这意味着我们将无法使用角色组登录PostgreSQL。

要创建角色组，使用`CREATE ROLE`语句如下:

~~~sql
-- 模版
CREATE ROLE group_role_name;

-- 示例
CREATE ROLE test;
~~~

#### 示例

~~~sql
-- 将角色添加到角色组
GRANT group_role to user_role;
-- 示例
GRANT test TO adi;

-- 从角色组中删除用户角色
REVOKE group_role FROM user_role;
-- 示例
REVOKE test FROM adi;

~~~

#### 完整案例

~~~sql
-- 使用postgres登录到PostgreSQL数据库。
-- 创建一个名为company的数据库:
create database company;

-- 创建user表:
create table user(
   id int generated always as identity primary key,
   name varchar(255) not null,
   phone varchar(255) not null
);

-- 创建jointime表:
create table jointime(
    year int, 
    month int
);

-- 设置角色和角色组
-- 创建角色jj它可以使用密码登录并继承其所属组角色的所有权限
create role jj inherit login password 'jj123';

-- 给jj角色赋予user表select权限
grant select on user to jj;

-- 创建ggroup角色组:
create role ggroup noinherit;
-- 创建jgroup角色组:
create role jgroup noinherit;


-- 给ggroup授予user表所有权限：
grant all on user to ggroup;
-- 给jgroup授予jointime表所有权限：
grant all on jointime to jgroup;

--  添加角色jj到角色组ggroup:
 grant ggroup to jj;
-- 添加角色jgroup到角色组ggroup:
 grant ggroup to jgroup;
 
 -- 恢复角色权限，我们可以使用以下声明:
 RESET ROLE;
~~~



### 删除角色

~~~sql
-- 使用postgres角色登录PostgreSQL:
drop role alice;

postgreSQL发出以下错误:
Error:

ERROR:  role "ali" cannot be dropped because some objects depend on it
DETAIL:  2 objects in database sales

-- 切换到alibaba数据库:
-- 重新分配对象ali所有权到postgres:
reassign owned by ali to postgres;

-- drop owned ali:
drop owned by ali;

-- 删除角色ali:
drop role ali;

~~~















## 基本语句

### 库操作

#### 概念

~~~sql
CREATE DATABASE database_name
WITH
   [OWNER =  role_name]
   [TEMPLATE = template]
   [ENCODING = encoding]
   [LC_COLLATE = collate]
   [LC_CTYPE = ctype]
   [TABLESPACE = tablespace_name]
   [ALLOW_CONNECTIONS = true | false]
   [CONNECTION LIMIT = max_concurrent_connection]
   [IS_TEMPLATE = true | false ]
~~~

执行`CREATE DATABASE`语句我们需要具有超级用户角色或特殊角色`CREATE DATABASE`特权。

创建新数据库:

- 首先，指定`CREATE DATABASE`关键词。数据库名称在PostgreSQL数据库服务器中必须是唯一的。如果我们尝试创建名称已经存在的数据库，PostgreSQL将发出错误。
- 然后，为新数据库指定一个或多个参数。

**OWNER 所有者**

给创建的数据库分配一个角色，这将是数据库的所有者。如果你省略了`OWNER`选项，数据库的所有者是执行`CREATE DATABASE`时的角色。

**TEMPLATE 模板**

默认情况下，PostgreSQL使用`template`指定从中创建新数据库的模板数据库。如果未明确指定模板数据库，则将默认数据库作为模板数据库.

**ENCODING 字符集编码**

确定新数据库中的字符集编码。

**LC_COLLATE 排序规则**

指定排序规则顺序 (`LC_COLLATE`)，新数据库将使用该排序规则。此参数影响的排序顺序字符串查询包含`Order By`模板数据库。

**LC_CTYPE 语言符号及其分类**

指定新数据库将使用的字符分类。 它影响字符的分类，例如大写, 小写, 和数字. 它默认为模板数据库的`LC_CTYPE`

**TABLESPACE 表空间**

指定新数据库TABLESPACE的名称。默认值为模板数据库的表空间。

**CONNECTION LIMIT 最大连接数**

指定到新数据库的最大并发连接。默认值为-1，即无限制。此参数在共享托管环境中非常有用，我们可以在其中配置特定数据库的最大并发连接。

**ALLOW_CONNECTIONS 是否允许连接**

参数`allow_connections`的数据类型是布尔值。如果是`false`,我们无法连接到数据库。

**IS_TEMPLATE 是否为模板**

如果`IS_TEMPLATE`是真的，任何角色的`CREATE DATABASE`都可以克隆它。如果为false，则只有超级用户或数据库所有者可以克隆它。

#### 示例

**默认**

~~~sql
CREATE DATABASE sales;


CREATE DATABASE hr 
WITH 
   ENCODING = 'UTF8'
   OWNER = hr
   CONNECTION LIMIT = 100;
   
   
   
   
CREATE DATABASE hr 
WITH 
   ENCODING = 'UTF8'
   OWNER = hr
   CONNECTION LIMIT = -1;
-- -1 代表不限制链接数


~~~



#### 修改

~~~sql
-- 更改数据库的属性
ALTER DATABASE name WITH option;
-- 示例
CREATE DATABASE testdb2;
 
-- 重命名
ALTER DATABASE database_name RENAME TO new_name;
-- 示例
ALTER DATABASE testdb2 RENAME TO testhrdb;
 
-- 更改数据库的所有者
ALTER DATABASE database_name OWNER TO new_owner | current_user | session_user;
-- 示例 假设hrrole 已存在。
ALTER DATABASE testhrdb OWNER TO hr;
-- 如果hrrole 不存在，我们可以使用CREATE ROLE声明:
CREATE ROLE hr LOGIN CREATEDB PASSWORD 'securePa$$1';

 -- 更改数据库的默认表空间
ALTER DATABASE database_name SET TABLESPACE new_tablespace;
-- 示例 更改的默认表空间testhrdb从pg_default到hr_default,假设hr_default表空间已存在。
 ALTER DATABASE testhrdb
 SET TABLESPACE hr_default;

-- 更改运行时配置变量的默认值
ALTER DATABASE database_name SET configuration_parameter = value;
-- 示例 设置escape_string_warning配置变量为off通过使用以下语句:
 ALTER DATABASE testhrdb 
 SET escape_string_warning = off;
~~~



#### 重命名数据库

要重命名PostgreSQL数据库，请使用以下步骤:

1. 断开与要重命名的数据库的连接，然后连接到其他数据库。
2. 检查并终止与要重命名的数据库的所有活动连接。
3. 使用`ALTER DATABASE`语句将数据库重命名为新数据库。

~~~sql
-- 检查db数据库所有活动连接:
SELECT  *
 FROM pg_stat_activity
 WHERE datname = 'postgres';
 
 
 -- 然后，终止与db连接，使用以下语句:
SELECT pg_terminate_backend(30742);

-- 修改数据库名
ALTER DATABASE "testhrdb" RENAME TO "newdb";
~~~



#### 删除数据库

一旦不再需要数据库，我们可以使用DROP DATABASE声明。

以下说明的语法`DROP DATABASE`声明:

```sql
 DROP DATABASE [IF EXISTS] database_name;
```

- `DROP DATABASE`删除指定数据库。
- 使用`如果存在`防止错误删除不存在的数据库。PostgreSQL将发出通知。

**删除具有活动连接的数据库**

要删除具有活动连接的数据库，可以按照以下步骤操作:

首先，找到活动数据库查询`pg_stat_activity`视图:

```ini
 SELECT *
 FROM pg_stat_activity
 WHERE datname = '<database_name>';
```

第二，通过发出以下查询来终止活动连接:

```sql
 SELECT  pg_terminate_backend(pid)
 -- 删除所有活动的链接
 select pg_terminate_backend(pg_stat_activity.pid) from pg_stat_activity where pg_stat_activity.datname = 'testdb1';
```

请注意，如果我们使用PostgreSQL 9.1或更早版本，请使用`procpid`列而不是`pid`列，因为从9.2版开始PostgreSQL已更改`procid`至`pid`

第三，执行`DROP DATABASE`声明:

```ini
 DROP DATABASE <database_name>;
```

#### 复制到另一个库

有时，我们希望在数据库服务器中复制PostgreSQL数据库以进行测试。

PostgreSQL使用 `CREATE DATABASE`，可以很容易实现这个操作:

```sql
 CREATE DATABASE targetdb 
 WITH TEMPLATE sourcedb;
```

此语句复制`sourcedb`到`targetdb`。例如，复制`dvdrental`到`dvdrental_test`数据库，我们使用以下语句:

```sql
 CREATE DATABASE dvdrental_test 
 WITH TEMPLATE dvdrental;
```

根据源数据库的大小,可能需要一段时间才能完成复制。

如果`dvdrental`数据库具有活动连接，我们将收到以下错误:

```vbnet
 ERROR:  source database "dvdrental" is being accessed by other users
 DETAIL:  There is 1 other session using the database.
```

以下查询返回活跃的连接:

```sql
 SELECT pid, usename, client_addr 
 FROM pg_stat_activity 
 WHERE datname ='dvdrental';
```

终止`dvdrental`数据库活跃连接，我们使用以下查询:

```sql
SELECT pg_terminate_backend (pid)
FROM pg_stat_activity
WHERE datname = 'dvdrental';
```

之后，我们可以执行`CREATE TABLE WITH TEMPLATE`再次执行语句，将dvdrental数据库复制到dvdrental_test数据库。



#### 复制到另一台服务器

在PostgreSQL数据库服务器之间复制数据库有几种方法。

如果源数据库很大，并且数据库服务器之间的连接很慢，我们可以将源数据库转储到文件中，将文件复制到远程服务器，并恢复它:

首先，将源数据库转储到文件中。

```
pg_dump -U postgres -d sourcedb -f sourcedb.sql
```

第二，将转储文件复制到远程服务器。

第三，在远程服务器中创建新数据库:

```sql
CREATE DATABASE targetdb
```

最后，还原远程服务器上的转储文件:

```sql
psql -U postgres -d targetdb -f sourcedb.sql
```

**如果服务器之间的连接速度很快并且数据库大小不大，可以使用以下命令:**

```bash
pg_dump -C -h local -U localuser sourcedb | psql -h remote -U remoteuser targetdb
```

例如，复制`dvdrental`数据库来自本地主机到远程服务器，我们执行如下操作:

```
pg_dump -C -h localhost -U postgres dvdrental | psql -h remote -U postgres dvdrental
```



### 查询大小

#### PostgreSQL table 大小

要获取特定表的大小，请使用`pg_relation_size()`功能。例如，我们可以获取`user`表如下所示:

```csharp
 select pg_relation_size('user');
```

`pg_relation_size()`函数以字节为单位返回特定表的大小:

```lua
 pg_relation_size
 ------------------
             16384
```

为了使结果更易于阅读，我们可以使用`pg_size_pretty()`功能。`pg_size_pretty()`函数获取另一个函数的结果，并根据需要使用字节、kB、MB、GB或TB对其进行格式化。例如:

```arduino
 SELECT
     pg_size_pretty (pg_relation_size('user'));
```

以下是以kB为单位的输出

```sql
  pg_size_pretty
     ----------------
      16 kB
     (1 row)
```

`pg_relation_size()`函数仅返回表的大小，不包括索引或其他对象。

要获取表的总大小，请使用`pg_total_relation_size()`功能。例如，要获取`user`表的总大小，请使用以下语句:

```arduino
 SELECT
     pg_size_pretty (
         pg_total_relation_size ('user')
     );
```

下面显示输出:

```sql
  pg_size_pretty
 ----------------
  72 kB
 (1 row)
```

我们可以使用`pg_total_relation_size()`函数查找最大表 (包括索引) 的大小。

例如，以下查询返回`dvdrental`数据库最大的5张表:

```sql
 SELECT
     relname AS "relation",
     pg_size_pretty (
         pg_total_relation_size (C .oid)
     ) AS "total_size"
 FROM
     pg_class C
 LEFT JOIN pg_namespace N ON (N.oid = C .relnamespace)
 WHERE
     nspname NOT IN (
         'pg_catalog',
         'information_schema'
     )
 AND C .relkind <> 'i'
 AND nspname !~ '^pg_toast'
 ORDER BY
     pg_total_relation_size (C .oid) DESC
 LIMIT 5;
```

**Output**

```sql
   relation  | total_size
 ------------+------------
  user     | 2472 kB
  post    | 2232 kB
  dept       | 688 kB
  company | 536 kB
  tenant  | 464 kB
 (5 rows)
```

#### PostgreSQL database 大小

要获取整个数据库的大小，请使用`pg_database_size()`功能。例如，以下语句返回`dvdrental`数据库大小:

```sql
 SELECT
     pg_size_pretty (
         pg_database_size ('dvdrental')
     );

```

该语句返回以下结果:

```sql
 pg_size_pretty
 ----------------
  15 MB
 (1 row)
```

要获取当前数据库服务器中每个数据库的大小，请使用以下语句:

```yaml
 SELECT
     pg_database.datname,
     pg_size_pretty(pg_database_size(pg_database.datname)) AS size
     FROM pg_database;
     
 Output:
     datname     |  size
 ----------------+---------
  postgres       | 7055 kB
  template1      | 7055 kB
  template0      | 6945 kB
  dvdrental      | 15 MB
```

#### PostgreSQL index 大小

要获取附加到表的所有索引的总大小，请使用`pg_indexes_size()`功能。

`pg_indexes_size()`函数接受OID或表名称作为参数，并返回该表附加的所有索引使用的总磁盘空间。

例如，要获取`user`表index 总大小，我们使用以下语句:

```arduino
 SELECT
     pg_size_pretty (pg_indexes_size('user'));
```

Output:

```sql
  pg_size_pretty
 ----------------
  32 kB
 (1 row)

```

#### PostgreSQL tablespace 大小

要获取表空间的大小，请使用`pg_tablespace_size()`功能。`pg_tablespace_size()`函数接受表空间名称并返回以字节为单位的大小。

以下语句返回`pg_default`表空间大小:

```sql
 SELECT
     pg_size_pretty (
         pg_tablespace_size ('pg_default')
     );

```

该语句返回以下输出:

```sql
  pg_size_pretty
 ----------------
  43 MB
 (1 row)
```

#### PostgreSQL value 大小

要查找需要存储特定值的空间，请使用`pg_column_size()`函数，例如:

```sql
 select pg_column_size(5::smallint);
  pg_column_size
 ----------------
               2
 (1 row)
 
 
 select pg_column_size(5::int);
  pg_column_size
 ----------------
               4
 (1 row)
 
 
 select pg_column_size(5::bigint);
  pg_column_size
 ----------------
               8
 (1 row)
```

## schema

在PostgreSQL中，schema是一个命名空间，其中包含名为database的对象，例如表，视图,索引,数据类型,函数,存储过程和标识符。

要访问schema中的对象，我们需要使用以下语法对对象进行限定:

```
schema_name.object_name
```

一个数据库可以包含一个或多个schema，并且每个schema仅属于一个数据库。两个schema可以具有共享相同名称的不同对象。

例如，你可能有`test`schema ，`user` 表，`public` schema也具有`user` 表。当你提到`user` 表你必须限定如下:

```arduino
public.user
```

Or

```
test.user
```

### 为什么需要使用schema

为什么需要使用schema:

- Schema允许我们将数据库对象 (例如表) 组织到逻辑组中，以使它们更易于管理。
- Schema使多个用户能够使用一个数据库而不会相互干扰。

### `public` schema

对于每个新数据库，PostgreSQL自动创建一个名为`public`的schema。无论我们创建的对象有没有指定schema名称，PostgreSQL都会将其放入`public`的schema。因此，以下语句是等效的:

```scss
CREATE TABLE table_name(
  ...
);
```

和

```sql
CREATE TABLE public.table_name(
   ...
);
```

###　schema搜索路径

实际上，引用没有其schema名称的表，例如，`user`表而不是完全限定的名称，例如`test.user`表。

当仅使用表的名称引用表时，PostgreSQL使用**schema搜索路径**,这是要查找的**schema**列表。

PostgreSQL将访问schema搜索路径中的第一个匹配表。如果没有匹配项，它将返回错误，即使该名称存在于数据库中的另一个schema中。

搜索路径中的第一个schema称为当前schema。请注意，当我们在未显式指定schema名称的情况下创建新对象时，PostgreSQL还将为新对象使用当前schema。

`current_schema()`函数返回当前schema:

```csharp
SELECT current_schema();
```

**Output**

```sql
 current_schema
----------------
public
(1 row)
```

这就是为什么对于我们创建的每个新对象，PostgreSQL使用`public`修饰。

在`psql`工具要查看当前搜索路径，请使用`show`命令:

```ini
SHOW search_path;
```

**Output**

```kotlin
 search_path
-----------------
"$user", public
(1 row)
```

> 🐣在此输出中:
>
> - `"$ user"`指定PostgreSQL将用于搜索对象的第一个schema，该对象与当前用户具有相同的名称。例如，如果我们使用`postgres`用户登录并访问`user`表。PostgreSQL将在`postgres`schema搜索`user`表。如果找不到这样的对象，它将继续在`public`schema搜索`user`表。
> - 第二个要素是指`public`我们之前已经看到的模式。

要创建新schema，请使用`CREATE SCHEMA`声明:

```bash
CREATE SCHEMA test;
```

要将新schema添加到搜索路径，请使用以下命令:

```vbnet
SET search_path TO test, public;
```

现在，如果我们创建一个名为`user`不指定schema名称，PostgreSQL将把它`user`表到`test`schema:

```sql
CREATE TABLE user(
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL
);
```

在`test`schema访问`user`表我们可以使用以下语句之一:

```sql
SELECT * FROM user;
```

Or

```sql
SELECT * FROM test.user;
```

`public` schema是搜索路径中的第二个元素，因此在public schema中要访问`user`表，我们必须限定表名，如下所示:

```vbnet
SELECT * FROM public.staff;
```

如果使用以下命令，则需要显式引用`public`使用完全限定名称的schema:

```vbnet
SET search_path TO public;
```

> `public` schema不是特殊的schema， 所以你可以删除他

### PostgreSQL schemas 和 权限

用户只能访问其拥有的schema中的对象。这意味着它们无法访问schema中不属于它们的任何对象。

要允许用户访问其不拥有的schema中的对象，必须授予`USAGE`schema权限

```vbnet
GRANT USAGE ON SCHEMA schema_name 
TO role_name;
复制代码
```

要允许用户在他们不拥有的schema中创建对象，我们需要向他们授予`CREATE`schema 权限:

```sql
GRANT CREATE ON SCHEMA schema_name 
TO user_name;
复制代码
```

> 请注意，默认情况下，在`public`schema 每个用户都有`CREATE`和`USAGE`。

### PostgreSQL schema 操作

- 要创建新schema，请使用`CREATE SCHEMA`声明。
- 要重命名schema或更改其所有者，请使用`ALTER SCHEMA`声明。
- 要删除schema，请使用`DELETE SCHEMA`声明。

在这之前，我们已经了解了PostgreSQL schema以及PostgreSQL如何使用搜索路径来解析对象名称。

### PostgreSQL `CREATE SCHEMA` 语句概述

>  **NOTE**: 在此处，我们将学习如何使用PostgreSQL`CREATE SCHEMA`语句以在数据库中创建新schema。

`CREATE SCHEMA` 语句允许我们在当前数据库中创建新schema。

`创建SCHEMA`声明:

```sql
CREATE SCHEMA [IF NOT EXISTS] schema_name;
```

在以下语法中:

- 首先，指定架构后`CREATE SCHEMA`关键词。schema名称在当前数据库中必须是唯一的。
- 第二，可选使用`IF NOT EXISTS`只有当新schema不存在时才有条件地创建它。尝试创建已经存在的新schema而不使用`IF NOT EXISTS`语句将导致错误。

> **NOTE**:执行`CREATE SCHEMA`语句，我们必须具有当前数据库中`CREATE`的权限。

我们还可以为用户创建schema:

```sql
CREATE SCHEMA [IF NOT EXISTS] 
AUTHORIZATION username;
```

在这种情况下，将为`username`创建schema

PostgreSQL还允许我们创建schema和对象列表，例如使用单个语句创建表和视图，如下所示:

```sql
CREATE SCHEMA schema_name
    CREATE TABLE table_name1 (...)
    CREATE TABLE table_name2 (...)
    CREATE VIEW view_name1
        SELECT select_list FROM table_name1;
```

> **NOTE**:请注意，每个子命令不以分号 (;) 结尾。

### 示例

### PostgreSQL `CREATE SCHEMA` 示例

让我们举一些使用`CREATE SCHEMA`例子，以获得更好的理解。

####  使用`CREATE SCHEMA`创建新SCHEMA示例

以下语句使用`创建SCHEMA`语句以创建名为的新schema `tests`:

```sql
CREATE SCHEMA tests;
```

以下语句返回当前数据库中的所有schema:

```sql
SELECT * 
FROM pg_catalog.pg_namespace
ORDER BY nspname;)
```

#### 使用`CREATE SCHEMA`为用户创建schema

首先，创建一个角色 名为 `gg`

```sql
CREATE ROLE gg 
LOGIN
PASSWORD 'Postgr@123#';
复制代码
```

第二，为`gg`创建schema语法如下 :

```sql
CREATE SCHEMA AUTHORIZATION gg;
复制代码
```

第三，为`gg`创建一个名为dd的 schema :

```sql
CREATE SCHEMA IF NOT EXISTS dd AUTHORIZATION john;
复制代码
```

#### 使用`CREATE SCHEMA`创建schema及其对象的示例

以下示例使用`CREATE SCHEMA`语句以创建名为的新schema`ssm`。它还会创建一个名为`spring`的表和一个名为`spring_boot`的视图

```sql
CREATE SCHEMA ssm 
    CREATE TABLE spring(
        id SERIAL NOT NULL, 
        version DATE NOT NULL
    )
    CREATE VIEW spring_boot AS 
        SELECT ID, version
        FROM spring 
        WHERE version <= 2.2.0;

```

>  **NOTE**: 在上面的文章中，我们已经学习了如何使用PostgreSQL`CREATE SCHEMA`语句以在数据库中创建新schema。

#### PostgreSQL `ALTER SCHEMA` 语句概述

`ALTER SCHEMA` 语句允许我们更改schema的定义。例如，我们可以按如下方式重命名schema:

```sql
ALTER SCHEMA schema_name 
RENAME TO new_name;
```

> **NOTE**:
>
> - 首先，在`ALTER SCHEMA`关键词后指定旧的schema_name。
> - 第二，在`RENAME`关键词后指定新的new_name。

请注意，要执行此语句，我们必须是schema的所有者，并且必须具有`CREATE`数据库特权。

除了重命名schema之外，`ALTER SCHEMA`还允许我们将schema的所有者更改为新的所有者，如以下语句所示:

```sql
ALTER SCHEMA schema_name 
OWNER TO { new_owner | CURRENT_USER | SESSION_USER};
```

**NOTE**:

- 首先，`ALTER SCHEMA`指定要在其中更改所有者的schema的名称。
- 第二，`OWNER TO` 指定新所有者.

#### PostgreSQL `ALTER SCHEMA` 语句示例

让我们举一些使用`ALTER SCHEMA`的示例，以获得更好的理解。

请注意，以下部分中的示例基于我们在`CREATE SCHEMA`中的操作。

####  使用`ALTER SCHEMA` 重命名schema的示例

此示例使用`ALTER SCHEMA`重命名`dd`schema到`pp`schema的语句:

```css
ALTER SCHEMA dd
RENAME TO pp;
```

同样，以下示例重命名`tests`schema:

```bash
ALTER SCHEMA tests
RENAME TO test;
复制代码
```

#### 使用`ALTER SCHEMA`语句以更改schema的所有者

以下示例使用`ALTER SCHEMA`将schema dd的所有者更改为postgres的语句;

```css
ALTER SCHEMA dd 
OWNER TO postgres;
```

以下是查询用户创建的schema的语句:

```vbnet
SELECT * 
FROM 
    pg_catalog.pg_namespace
WHERE 
    nspacl is NULL AND
    nspname NOT LIKE 'pg_%'
ORDER BY 
    nspname;
```

从输出中可以清楚地看到，`dd`schema现在由id为10的所有者拥有，即`postgres`。

同样，此语句将test的所有者更改为`postgres`:

```bash
ALTER SCHEMA test 
OWNER TO postgres;
```

> 在上面的文章中，我们学习了如何使用PostgreSQL`更改模式`语句以重命名schema或将schema的所有者更改为新的schema。

#### PostgreSQL `DROP SCHEMA` 语句概述

`DROP SCHEMA`移除一个SCHEMA以及数据库中的所有对象。

以下是的`DROP SCHEMA`语法:

```sql
DROP SCHEMA [IF EXISTS] schema_name 
[ CASCADE | RESTRICT ];

```

> 释义：
>
> - 首先， `DROP SCHEMA` 关键字后指定架构要从中删除的schema_name.
> - 第二，使用`IF EXISTS`仅在schema存在时才有条件删除schema的选项。
> - 第三，使用`CASCADE` （级联）删除schema及其所有对象，进而删除依赖于这些对象的所有对象。如果仅在schema为空时才删除schema，则可以使用`RESTRICT` 选项。默认情况下，`DROP SCHEMA`使用`RESTRICT` 选项。

执行`DROP SCHEMA`语句，我们必须是要删除的schema的所有者或超级用户。

PostgreSQL允许你在一个`DROP SCHEMA`声明中删除多个schema:

```sql
DROP SCHEMA [IF EXISTS] schema_name1 [,schema_name2,...] 
[CASCADE | RESTRICT];
```

#### PostgreSQL `DROP SCHEMA` 语句示例

#####  使用`DROP SCHEMA`删除空schema的语句示例

此示例使用`DROP SCHEMA`删除gg的语句:

```sql
DROP SCHEMA IF EXISTS gg;
```

要刷新列表中的schema，请右键单击schema节点，然后选择 “刷新” 菜单项:

##### 使用`DROP SCHEMA`删除多个schema的语句示例

以下示例使用`DROP SCHEMA`删除多个schema的语句`gg`和`test`使用单个语句:

```sql
DROP SCHEMA IF EXISTS gg, test;
```

#####  使用`DROP SCHEMA`删除非空schema示例的语句

此声明删除`ssm`schema:

```sqlini
DROP SCHEMA ssm;
```

以下是控制台输出:

```vbnet
ERROR:  cannot drop schema scm because other objects depend on it
DETAIL:  table scm.deliveries depends on schema scm
view scm.delivery_due_list depends on schema scm
HINT:  Use DROP ... CASCADE to drop the dependent objects too.
SQL state: 2BP01
复制代码
```

因此，如果schema不为空，并且我们想要删除schema及其对象，则必须使用级联删除（`CASCADE`）:

```sql
DROP SCHEMA scm CASCADE;
```

同样，使用以下语句我们可以删除`pp`的schema及其对象:

```sql
DROP SCHEMA pp CASCADE;
```

> 在本文中，我们已经学习了如何使用PostgreSQL 'DROP SCHEMA' 语句在数据库中删除一个或多个schema。



