package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class LockOperate {

    public interface LockDao {
        /**
         * 加锁
         */
        void lock();

        /**
         * 释放锁
         */
        void unLock();
    }

    public static class MySqlLock implements LockDao {

        @Override
        public void lock() {
            System.out.println(this.getClass().getSimpleName() + " 开始加锁处理...");
        }

        @Override
        public void unLock() {
            System.out.println(this.getClass().getSimpleName() + " 处理完成，解锁成功！");
        }
    }

    public static class OracleLock implements LockDao {

        @Override
        public void lock() {
            System.out.println(this.getClass().getSimpleName() + " 开始加锁处理...");
        }

        @Override
        public void unLock() {
            System.out.println(this.getClass().getSimpleName() + " 处理完成，解锁成功！");
        }
    }


}
