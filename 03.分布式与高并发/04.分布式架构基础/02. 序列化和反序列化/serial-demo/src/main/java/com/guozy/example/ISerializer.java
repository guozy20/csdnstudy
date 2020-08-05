package com.guozy.example;

public interface ISerializer {
    <T> byte[] serialize(T obj);

    <T> T deserialize(byte[] data);
}
