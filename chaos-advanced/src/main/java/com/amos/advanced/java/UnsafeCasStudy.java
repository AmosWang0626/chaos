//package com.amos.advanced.java;
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
///**
// * PROJECT: chaos
// * DESCRIPTION: note
// *
// * @author daoyuan
// * @date 2020/4/5 14:10
// */
//public class UnsafeCasStudy implements Runnable {
//
//    private int i;
//
//    public static void main(String[] args) {
//        final UnsafeCasStudy obj = new UnsafeCasStudy();
//
//        new Thread(obj).start();
//        new Thread(obj).start();
//    }
//
//    @Override
//    public void run() {
//        try {
//            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//            theUnsafe.setAccessible(true);
//            Unsafe unsafe = (Unsafe) theUnsafe.get(null);
//
//            while (true) {
//                long offset = unsafe.objectFieldOffset(UnsafeCasStudy.class.getDeclaredField("i"));
//                boolean cas = unsafe.compareAndSwapInt(this, offset, this.i, this.i + 1);
//                if (cas) {
//                    System.out.println(unsafe.getIntVolatile(this, offset));
//                }
//                Thread.sleep(500);
//            }
//        } catch (NoSuchFieldException | InterruptedException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
