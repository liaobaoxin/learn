package com.lbx.log;

import org.apache.log4j.Logger;

/**
 * Create by lbx on 2018/8/11  10:04
 **/
public class LogLearn {

    private static Logger logger = Logger.getLogger(LogLearn.class);

    public static void main(String[] args) {
        // 记录debug级别的信息
        logger.debug("记录debug级别的信息");
        // 记录info级别的信息
        logger.info("记录info级别的信息");
        // 记录error级别的信息
        logger.error("记录error级别的信息");
    }
}
