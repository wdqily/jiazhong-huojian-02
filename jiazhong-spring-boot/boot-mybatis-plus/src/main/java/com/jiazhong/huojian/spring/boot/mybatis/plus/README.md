# Mybatis-Plus

## 环境搭建

1. 引入依赖
2. 书写配置文件(application.yml)
3. bean包中的类
4. mapper包中的接口
    ```java
    @Mapper
    public interface EmpMapper extends BaseMapper<Emp> {
    } 
    ```
5. 书写service的接口以及实现类
6. 测试（jUnit或者run测试）

## 几个方法

1. 全查询
2. 按照主键ID查询
3. 分页查询
4. 添加
5. 按照主键修改
6. 按照主键删除（逻辑删除和物理删除）
7. 自动填充功能

## 条件构造器

1. 关系运算符条件
2. 模糊查询条件
3. 范围查询条件
4. 为空查询条件
5. 排序查询条件
6. 分组以及部分列查询
7. 拼接内容查询
8. `and` 或者 `or` 查询
9. 修改操作

## 其他操作

1. 引入 `config.xml`
2. 引入 `mapper.xml`
3. 常见注解（看一遍）