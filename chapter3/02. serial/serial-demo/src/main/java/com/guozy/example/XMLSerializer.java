package com.guozy.example;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLSerializer implements ISerializer {
    XStream stream = new XStream(new DomDriver());
    @Override
    public <T> byte[] serialize(T obj) {
        return stream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data) {
        return (T) stream.fromXML(new String(data));
    }
}
