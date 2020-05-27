package com.chan.hen.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    protected S baseService;

    @PostMapping(value = "saveOrUpdateBatch" )
    public R saveOrUpdateBatch(List<T> entityList,int batchSize){
        boolean success=baseService.saveOrUpdateBatch(entityList,batchSize);
        return HenResult.ok(success);
    }
    @DeleteMapping(value = "removeByIds" )
    public R removeByIds(Collection<? extends Serializable> idList){
        boolean success=baseService.removeByIds(idList);
        return HenResult.ok(success);
    }
    @GetMapping("listByMap")
    public R listByMap(Map<String, Object> columnMap){
       List<T> list =baseService.listByMap(columnMap);
       return  HenResult.ok(list);
    }

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
