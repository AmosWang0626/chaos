package cn.amos.mode.design.proxy.cglib.trans;

/**
 * private: 本类可访问
 * none(默认): private + 同包可访问
 * protected: none + 继承类可访问
 * public: protected + 所有类可访问
 */
public class TransSportsCar implements Trans {

    @Override
    public void start(String name, String target) {
        System.out.println("------------core----------------");
        System.out.println(name + " 检查车身, 检查油量, 系好安全带!");
        System.out.println("启动跑车, 挂挡, 踩油门, 向" + target + "出发......");
        System.out.println("------------core----------------");
    }
}
