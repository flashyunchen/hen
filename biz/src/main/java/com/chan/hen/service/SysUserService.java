package com.chan.hen.service;

import com.chan.hen.base.IBaseService;
import com.chan.hen.entity.SysUser;
import java.util.List;

/**
 * 管理员表(SysUser)表服务接口
 *
 * @author chanyu
 * @since 2020-06-01 20:48:40
 */
public interface SysUserService extends IBaseService<SysUser>{
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);
}