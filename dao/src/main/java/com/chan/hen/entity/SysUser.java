package com.chan.hen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chan.hen.base.BaseHenEntity;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.io.Serializable;

/**
 * 管理员表(SysUser)实体类
 *
 * @author chanyu
 * @since 2020-06-01 20:48:27
 */
@TableName("sys_user")
@Data
public class SysUser extends BaseHenEntity {
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 账号
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    /**
    * md5密码盐
    */
    private String salt;
    /**
    * 名字
    */
    private String name;
    /**
    * 生日
    */
    private Date birthday;
    /**
    * 性别(字典)
    */
    private String sex;
    /**
    * 电子邮件
    */
    private String email;
    /**
    * 电话
    */
    private String phone;
    /**
    * 角色id(多个逗号隔开)
    */
    private String roleId;
    /**
    * 部门id(多个逗号隔开)
    */
    private Long deptId;
    /**
    * 状态(字典)
    */
    private String status;
    /**
    * 乐观锁
    */
    private Integer version;

}