package com.guozy.example;

/**
 * java的序列化
 */
public class XmlSerializableMain {
    public static void main(String[] args) {
        ISerializer serializer = new XMLSerializer();
        User user = new User();
        user.setName("guozy");
        user.setAge(22);
        System.out.println(serializer.serialize(user).length);
        System.out.println(new String(serializer.serialize(user)));
    }
}
