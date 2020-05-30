package com.chan.hen.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Description 控制器基本类
 * @Author chanyu
 * @Date 2020/5/27 22:05
 * @Version 1.0
 */
public class BaseController<T extends BaseHenEntity ,S extends IBaseService<T>> {
    @Resource
    protected S baseService;

    @PostMapping(value = "saveOrUpdateBatchLimit" )
    public R saveOrUpdateBatchLimit(@RequestParam List<T> entityList,@RequestParam int batchSize){
        boolean success=baseService.saveOrUpdateBatch(entityList,batchSize);
        return HenResult.ok(success);
    }
    @ApiOperation(value = "批量保存" ,notes = "批量保存")
    @PostMapping(value = "saveOrUpdateBatch" )
    public R saveOrUpdateBatch(@RequestBody List<T> entityList){
        boolean success=baseService.saveOrUpdateBatch(entityList);
        return HenResult.ok(success);
    }
    @ApiOperation(value = "根据ids删除" ,notes = "根据ids删除")
    @DeleteMapping(value = "removeByIds" )
    public R removeByIds(@RequestParam Collection<? extends Serializable> idList){
        boolean success=baseService.removeByIds(idList);
        return HenResult.ok(success);
    }
    @ApiOperation(value = "根据map参数查询列表" ,notes = "根据map参数查询列表")
    @GetMapping("listByMap")
    public R listByMap(Map<String, Object> columnMap){
       List<T> list =baseService.listByMap(columnMap);
       return  HenResult.ok(list);
    }

    @ApiOperation(value = "分页查询" ,notes = "分页查询")
    @GetMapping("listByPage")
    public R listByPage(T t,
                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
//            ,@RequestParam(name = "queryParams", required = false)  List <QueryParam> queryParams
    ) {
            QueryWrapper<T> queryWrapper = new QueryWrapper<T>();
            IPage<T> p=  baseService.page(new Page<T>(pageNum,pageSize), queryWrapper);
            return HenResult.ok(p);
    }
}
