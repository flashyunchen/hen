package com.chan.hen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chan.hen.base.BaseHenEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @NotNull
    @Length(min = 6,max = 20)
    private String account;
    /**
    * 密码
    */
    @NotNull
    @Length(min = 6,max = 20)
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
    @Email
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