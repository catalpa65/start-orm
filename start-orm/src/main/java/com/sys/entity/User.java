package com.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("mp_user")
public class User {
    //主键
    @TableId
    private Long userId;
    //姓名
    @TableField("name")
    private String userName;
    //年龄
    private Integer age;
    //邮箱
    private String email;
    //父级ID
    private Long managerId;
    //创建时间
    private LocalDateTime createTime;

    @TableField(exist = false)
    private String remark;
}
