package com.redis.test;

import com.mongo.test.Person;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class JTest {

    private  static Jedis jd;
    private Person bean1;
    private Person bean2;

    @BeforeClass//在程序启动的时候执行一次
    public static void setUpBeforeClass() throws Exception{
        jd = new Jedis("127.0.0.1",6379);
        System.out.println("连接成功");
        jd.select(0);
    }

    @org.junit.Before
    public void setUp() throws Exception {
        bean1 = new Person();
        bean1.setUid(1);
        bean1.setUname("林夕");
        bean1.setPassword("05200");

        bean2 = new Person();
        bean2.setUid(2);
        bean2.setUname("IsMe");
        bean2.setPassword("7488");
    }

    //保存对象
    @Test
    public void testSaveObject(){
        jd.set("person".getBytes(),SerializeUtil.serialize(bean1));
        jd.expire("person".getBytes(),300);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    /**
     * 关闭
     * @throws Exception
     */
    public static void tearDownAfterClass() throws Exception{
        jd.close();
    }
}
