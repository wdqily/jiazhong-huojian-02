package com.jiazhong.huojian.spring.boot.mybatis.plus.been;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {
    @TableId
    private String id;
    private String username;
    private String password;
    private Integer state;

}
