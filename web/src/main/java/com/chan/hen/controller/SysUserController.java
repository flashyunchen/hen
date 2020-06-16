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

    @ApiOperation(value = "异常测试" ,notes = "异常测试")
    @RequestMapping(value = "exTest",method = RequestMethod.GET)
    public R exTest() {
        int a=2/0;
        return  HenResult.ok("");
    }
    @ApiOperation(value = "乱码测试" ,notes = "乱码测试")
    @RequestMapping(value = "encodeTest",method = RequestMethod.GET)
    public R encodeTest() {
        return  HenResult.ok("这是中文"+"abcd");
    }
}