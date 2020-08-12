package com.guozy.example;

/**
 * java的序列化
 */
public class SerializableMain {
    public static void main(String[] args) {
        ISerializer serializer = new JavaSerializer();
        User user = new User();
        user.setName("guozy");
        user.setAge(22);
        byte[] bytes = serializer.serialize(user);
        System.out.println(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + " ");
        }
        System.out.println();
        User userRever = serializer.deserialize(bytes);
        System.out.println(userRever);
    }
}
