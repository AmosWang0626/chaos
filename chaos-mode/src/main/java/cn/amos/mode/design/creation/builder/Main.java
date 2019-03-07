package cn.amos.mode.design.creation.builder;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/7
 */
public class Main {

    public static void main(String[] args) {
        new Cooker(new ThickCake("啦啦啦")).cookCake();
        new Cooker(new ThinCake("啦啦啦啦啦啦啦啦")).cookCake();
    }

}
