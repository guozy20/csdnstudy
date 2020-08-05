package com.guozy.example.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

public class ProtobufMain {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        UserProto.User user = UserProto.User.newBuilder().setAge(37101).setName("郭a").build();
        ByteString bytes = user.toByteString();
        System.out.println(bytes.size());
        for (byte bt :bytes) {
            System.out.print(bt + " ");
        }
        System.out.println();
        UserProto.User userRever = UserProto.User.parseFrom(bytes);
        System.out.println(userRever);

    }
}
