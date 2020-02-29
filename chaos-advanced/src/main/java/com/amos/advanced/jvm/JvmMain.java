package com.amos.advanced.jvm;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/25
 */
public class JvmMain {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println("===================================");
        // 基本数据类型没有 ClassLoader
        System.out.println("int.class.getClassLoader() >>>>> " + int.class.getClassLoader());
        System.out.println();
        System.out.println("ClassLoader.getSystemClassLoader() >>>>> " + ClassLoader.getSystemClassLoader());
        System.out.println();
        System.out.println("JvmMain.class.getClassLoader() >>>>>> " + JvmMain.class.getClassLoader());
        System.out.println("JvmMain.class.getClassLoader().getParent() >>>>>> " + JvmMain.class.getClassLoader().getParent());
        System.out.println("JvmMain.class.getClassLoader().getParent().getParent() >>>>>> " + JvmMain.class.getClassLoader().getParent().getParent());
    }

}
