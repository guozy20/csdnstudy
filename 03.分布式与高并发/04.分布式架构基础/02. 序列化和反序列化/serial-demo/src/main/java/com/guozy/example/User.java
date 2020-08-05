package com.guozy.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
    /**
     * Java 的序列化机制是通过判断类的 serialVersionUID 来验证版本一致性的。在进行反序列化
     * 时， JVM 会把传来的字节流中的 serialVersionUID 与本地相应实体类的 serialVersionUID 进
     * 行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的
     * 异常，即是 InvalidCastException。
     */
//    private static final long serialVersionUID = -114234582589748533L;
    private String name;

    /**
     * transient
     * Transient 关键字的作用是控制变量的序列化，在变量声明前加上该关键字，可以阻止该变
     * 量被序列化到文件中，在被反序列化后， transient 变量的值被设为初始值，如 int 型的是
     * 0，对象型的是 null。
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 绕开 transient 机制的办法
     * 虽然 name 被 transient 修饰，但是通过我们写的这两个方法依然能够使得 name 字段正确
     * 被序列化和反序列化
     *
     * writeObject 和 readObject 原理
     * writeObject 和 readObject 是两个私有的方法，他们是什么时候被调用的呢？从运行结果来
     * 看，它确实被调用。而且他们并不存在于 Java.lang.Object，也没有在 Serializable 中去声明。
     * 我们唯一的猜想应该还是和 ObjectInputStream 和 ObjectOutputStream 有关系，所以基于
     * 这个入口去看看在哪个地方有调用
     * 从源码分析可以看到，readObject是通过反射调用
     * @param out
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(age);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        age = in.readInt();

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
