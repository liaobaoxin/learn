package com.lbx.aopLearn.primordialAOP;

/**
 * Create by lbx on 2018/11/3  15:00
 **/
public class TestForumService {
    public static void main(String[] args) {
        ForumService forumService=new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
