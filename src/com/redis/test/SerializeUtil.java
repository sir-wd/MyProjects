package com.redis.test;

import java.io.*;

/**
 * 序列化对象
 */
public class SerializeUtil {

    /**
     * 将对象序列化成Util
     */
    public static byte[] serialize(Object object){
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            //序列化：new FileOutputStream("");
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                oos.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }

    /**
     * 将byte[]反序列化成对象
     */
    public static Object unserialize(byte[] bytes){
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try{
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return  ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                ois.close();
                bais.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }
}
