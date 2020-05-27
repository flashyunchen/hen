package com.chan.hen.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description 服务基本实现类
 * @Author chanyu
 * @Date 2020/5/27 22:00
 * @Version 1.0
 */
public class BaseServiceImpl<M extends IBaseMapper<T>,T extends BaseHenEntity>
        extends ServiceImpl<M , T>
        implements IBaseService<T> {
}
