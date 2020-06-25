package com.chan.hen.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.chan.hen.base.BaseController;
import com.chan.hen.base.HenResult;
import com.chan.hen.core.defvalidator.Phone;
import com.chan.hen.entity.SysUser;
import com.chan.hen.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员表(SysUser)表控制层
 *
 * @author chanyu
 * @since 2020-06-01 20:48:50
 */
@RestController
@RequestMapping("sysUser")
@Validated//需要使用Hibernate非实体类参数校验，需要加入此注解
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

    /**
     * 处理"/users/"的GET请求，用来获取用户列表
     *
     * @return
     */
    @GetMapping("/")
    public List<SysUser> getUserList() {
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        return sysUserService.list();
    }

    /**
     * 处理"/users/"的POST请求，用来创建User
     *
     * @param user
     * @return
     */
    @PostMapping("/")
    public String postUser(@Valid  @RequestBody SysUser user) {
        // @RequestBody注解用来绑定通过http请求中application/json类型上传的数据
        sysUserService.save(user);
        return "success";
    }

    /**
     * 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public SysUser getUser(@PathVariable Long id) {
        // url中的id可通过@PathVariable绑定到函数的参数中
        return sysUserService.getById(id);
    }

/*    *//**
     * 处理"/users/{id}"的PUT请求，用来更新User信息
     *
     * @param id
     * @param user
     * @return
     *//*
    @PutMapping("/{id}")
    public String putUser(@PathVariable Long id, @RequestBody SysUser user) {
        user.setId(id);
        sysUserService.updateById(user);
        return "success";
    }*/

    /**
     * 处理"/users/{id}"的DELETE请求，用来删除User
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        sysUserService.removeById(id);
        return "success";
    }

    /**
     * @param phone
     * @return
     */
    @GetMapping("/checkPhone")
    public @ResponseBody String checkPhone(@Phone @RequestParam String phone) {
        return "正确的电话号码格式："+phone;
    }

}