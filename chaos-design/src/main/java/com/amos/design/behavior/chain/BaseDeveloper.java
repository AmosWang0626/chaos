package com.amos.design.behavior.chain;

/**
 * DESCRIPTION: 研发抽象类
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public abstract class BaseDeveloper {

    /**
     * 需求难度
     */
    public interface HardLevel {
        int ONE = 1;
        int TWO = 2;
        int THREE = 3;
    }

    protected BaseDeveloper nextDeveloper;

    protected int level;

    public void plusDeveloper(BaseDeveloper nextDeveloper) {
        this.nextDeveloper = nextDeveloper;
    }

    public void develop(int level, String demand) {
        if (this.level >= level) {
            realDevelop(demand);
        } else if (nextDeveloper != null) {
            nextDeveloper.develop(level, demand);
        }
    }

    /**
     * 研发需求
     *
     * @param demand 需求
     */
    abstract void realDevelop(String demand);

}
