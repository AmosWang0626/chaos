package cn.amos.mode.design.adapter.demo1;

/**
 * NOTE: 类说明
 * PROJECT: 适配器模式
 *
 * @author AMOS
 * @date 2018/8/6
 */
public class Main {

    public static void main(String[] args) {
        USB typeCAdapter = new TypeCAdapter();
        typeCAdapter.charge();
        USB microBAdapter = new MicroBAdapter();
        microBAdapter.charge();
    }
}
