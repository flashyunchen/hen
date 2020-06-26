package com.chan.hen.srun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 在spring run完成前执行
 *
 * @author chanyu
 */
@Component
@Order(value = 1)
public class HenStartRun implements CommandLineRunner {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public void run(String... args) throws Exception {
        //执行业务，比如开启定时任务等
        logger.info("这是第一个");
    }
}
