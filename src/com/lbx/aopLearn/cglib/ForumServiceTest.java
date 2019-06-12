package com.lbx.aopLearn.cglib;

import com.lbx.aopLearn.primordialAOP.ForumService;
import com.lbx.aopLearn.primordialAOP.ForumServiceImpl;
import org.junit.Test;

/**
 * Create by lbx on 2018/11/3  17:45
 **/
public class ForumServiceTest {
    @Test
    public void proxy(){
        CglibProxy proxy = new CglibProxy();
        ForumService forumService = (ForumService) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeTopic(10);
        forumService.removeForum(20);
    }
}
