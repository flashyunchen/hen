package com.chan.hen.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.chan.hen.base.BaseController;
import com.chan.hen.base.HenResult;
import com.chan.hen.entity.SysUser;
import com.chan.hen.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员表(SysUser)表控制层
 *
 * @author chanyu
 * @since 2020-06-01 20:48:50
 */
@RestController
@RequestMapping("sysUser")
public class SysUserController extends BaseController<SysUser,SysUserService> {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;
    @ApiOperation(value = "分页查询" ,notes = "分页查询")
    @RequestMapping(value = "queryAllByLimit",method = RequestMethod.GET)
    public R queryAllByLimit(int offset, int limit) {
         List<SysUser> list= sysUserService.queryAllByLimit(offset,limit);
         return  HenResult.ok(list);
    }
}