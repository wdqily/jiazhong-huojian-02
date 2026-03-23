# MyBatis 归纳总结

## 什么是 ORM 框架

对象关系映射

## MyBatis 的环境搭建

1.pom.xml中引入jar包

2.在resources下创建config.xml配置文件

3.创建bean包类

4.创建mapper包接口

5.创建 mapper 包接口对应的 Xxx.xml 文件

6.App类中测试

## MyBatis 的参数问题

### 单参数

1. empno=#{} #是占位符

2. empno=${} $是直接填入

3. 单个参数上下可以不一致

   ```java
   @Select("select * from emp where empno=${aaa}")
   Emp findEmpById3(int id);
   ```

### 多参数

1. 多参数传值时需要用@Param绑定

   ```java
   @Select("select * from emp where job=#{job} and ename=#{ename}")
   List<Emp> findEmp3(@Param("job") String job, @Param("ename") String ename);
   ```

2. 用List 或者Map

   ```java
   @Select("select * from emp where job=#{job} and ename=#{ename}")
   List<Emp> findEmp1(Emp emp);
   
   @Select("select * from emp where job=#{job} and ename=#{ename}")
   List<Emp> findEmp2(Map map);
   ```

## 映射

### 自动映射

数据库查询出来的虚拟列和 Java 实体类中的属性名一致(不区分大小写)，就可以自动映射。

### 手动映射

column：数据库列名

property：属性

```java
@Results(value = {
        @Result(column = "deptno", property = "deptNo", id = true),
        @Result(column = "dname", property = "dName"),
        @Result(column = "deptNo", property = "emps",
                many = @Many(select = "com.jiazhong.huojian.mybatis.m3.mapper.EmpMapper.findEmpByDeptNo"))
}
)
```

## 多表关系

### 一对多

many 通过部门编号查员工

### 多对一

one 通过员工查到部门

## 动态SQL

1. if

2. where

3. choose when otherwise

   ```java
   select * from emp
   <choose>
       <when test="sal>60000">
           where job='程序员'
       </when>
       <when test="sal>40000">
           where job='网页设计'
       </when>
       <otherwise>
           where job='歌手'
       </otherwise>
   </choose>
   ```

4. trim:可以写and或or

   ```java
   select * from emp
   <trim prefix="where" prefixOverrides="and|or">
       <if test="job!=null">
           job=#{job}
       </if>
       <if test="sal!=null">
           and sal>#{sal}
       </if>
   </trim>
   ```


5. foreach:遍历

   item：迭代时的别名。
   index：每次迭代到的位置。
   open：表示该语句以什么开始。
   separator：以什么符号作为分隔符
   close：表示该语句以什么结束

   ```java
   <foreach collection="job" open="(" close=")" separator="," item="ab">
       #{ab}
   </foreach>
       
   ```

## 二级缓存

### 什么是缓存

在计算机里面，任何信息都有源头，缓存一般指源头信息读取后，放在内存或者其他读取较快的地方，下次读取相同信息不去源头查询而是直接从内存（或者能快速存取的硬件）读取。这样可以减少硬件使用，提高读取速度。

### 一级缓存

1. 作用域是session 默认开启
2. 同一个session多次查一个数据 不需要连接数据库
3. 生命周期为一个session

### 二级缓存

1. 作用域为Mapper

2. ```java
   <settings>
       <setting name="cacheEnabled" value="true" />
   </settings>
   ```

### 缓存失效

1. 清除缓存 session.close()
2. 进行了更新操作(delete，insert以及update)

## 应用

### 如何添加

```java

@Insert("insert into emp values(null,#{ename},#{job},#{mgr},#{hireDate},#{sal},#{comm},#{deptNo})")
void saveEmp(Emp emp);
```

### 如何修改

```java

@Update("update emp set job=#{job} where empNo=#{empNo} ")
void updateEmp(Emp emp);
```

### 如何删除

```java

@Delete("delete from emp where empno=#{empNo}")
void deleteEmp(int empNo);
```

### 如何查询

1. 单行查询(按照ID查询):ById

   ```java
   @Select("select * from emp where empno=#{id}")
   Emp findEmpById1(int id);
   ```

2. 多行查询(全查询、模糊查询等)： findAll %王%

   ```java
   @Select("select * from emp")
   List<Emp> findAll();
   ```

3. 分页查询：limit分页和PageHelper插件

   ```java
   @Select("select * from emp limit #{start},#{size}")
   List<Emp> findPage(@Param("start") int start, @Param("size") int size);
   ```

