package com.chan.hen.service.impl;

import com.chan.hen.base.BaseServiceImpl;
import com.chan.hen.entity.SysUser;
import com.chan.hen.mapper.SysUserMapper;
import com.chan.hen.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员表(SysUser)表服务实现类
 *
 * @author chanyu
 * @since 2020-06-01 20:48:41
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper,SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserMapper.queryAllByLimit(offset, limit);
    }
}