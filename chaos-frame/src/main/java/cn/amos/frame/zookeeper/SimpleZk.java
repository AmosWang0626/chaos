package cn.amos.frame.zookeeper;

import org.apache.zookeeper.Watcher;

/**
 * DESCRIPTION: 简单 zk create/get
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/22
 */
public class SimpleZk extends BaseWatch {

    public static void main(String[] args) throws Exception {
        SimpleZk simple = new SimpleZk();
        simple.initZkInstance();
        String defaultPath = "/java_test";
        String saveData = "Java代码测试数据";

        simple.createNode(defaultPath, saveData);

        String data = simple.getNode(defaultPath);
        System.out.println(">>>>>>> 获取节点数据：" + data);

        simple.stop();
    }

    @Override
    public Watcher getDataWatcher() {
        return null;
    }

    @Override
    public Watcher getChildDataWatcher() {
        return null;
    }

}
