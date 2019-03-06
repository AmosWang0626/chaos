package cn.amos.mode.design.proxy.cglib.trans;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class TransMotorcycle implements Trans {

    @Override
    public void start(String name, String target) {
        System.out.println("------------core----------------");
        System.out.println(name + " 检查车身, 检查油量, 带上头盔!");
        System.out.println("启动摩托, 挂挡, 拧油门, 向" + target + "出发......");
        System.out.println("------------core----------------");
    }
}
