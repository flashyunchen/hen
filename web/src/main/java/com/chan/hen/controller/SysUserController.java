package com.chan.hen.controller;

import com.chan.hen.base.BaseController;
import com.chan.hen.entity.SysUser;
import com.chan.hen.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 管理员表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-05-29 22:13:24
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController extends BaseController<SysUser,SysUserService> {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysUser selectOne(Long id) {
        return this.sysUserService.queryById(id);
    }

}