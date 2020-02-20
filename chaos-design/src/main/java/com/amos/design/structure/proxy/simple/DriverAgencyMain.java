package com.amos.design.structure.proxy.simple;

import com.amos.design.structure.proxy.common.DriveInterface;
import com.amos.design.structure.proxy.common.RealDriver;
import com.amos.design.structure.proxy.common.VirtualDriver;

import java.text.MessageFormat;
import java.util.Random;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/8
 */
public class DriverAgencyMain implements DriveInterface {

    private DriveInterface driver;

    public DriverAgencyMain(DriveInterface driver) {
        this.driver = driver;
    }

    @Override
    public String drive(String model) {
        System.out.println(MessageFormat.format("经纪公司 {0} 安排赛程...", this.getClass().getSimpleName()));

        // 代理方法
        String drive = driver.drive(model);

        System.out.println("赛程数据统计等等");

        return drive;
    }

    /**
     * 静态代理模式
     * 优点：业务类只需要关注业务逻辑本身，这也是代理的共有优点。
     * 缺点：
     * 1.如果代理接口增加一个方法，所有实现代理接口的都要实现此方法；
     * 2.拓展性较差。
     */
    public static void main(String[] args) {
        DriveInterface driver = new Random().nextBoolean()
                ? new RealDriver("刘易斯·汉密尔顿") : new VirtualDriver();

        String drive = new DriverAgencyMain(driver).drive("EQ Silver Arrow 01");

        System.out.println("\n比赛感受：" + drive);
    }

}
