package com.jiazhong.huojian.mybatis.m4.Mapper;

import com.jiazhong.huojian.mybatis.m4.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    List<Emp> find1(String ename);

    List<Emp> find2(String ename);

    List<Emp> find3(Double sal);

    List<Emp> find4(@Param("job") String job, @Param("sal") Double sal);

    List<Emp> find5(@Param("job") List<String> job);

    List<Emp> find6(Emp emp);

    void update(Emp emp);
}
