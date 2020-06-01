package com.chan.hen.mapper;

import com.chan.hen.base.IBaseMapper;
import com.chan.hen.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 管理员表(SysUser)表数据库访问层
 *
 * @author chanyu
 * @since 2020-06-01 20:48:25
 */
public interface SysUserMapper extends IBaseMapper<SysUser>{
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
}