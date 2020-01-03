package cn.amos.chaos.test.main;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * DESCRIPTION: can't use new create object
 *
 * @author amos.wang
 * @date 2019/10/8
 */
@Data
public class InstanceMain {

    private String name;

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("cn.amos.chaos.test.main.InstanceMain");
        InstanceMain instance = (InstanceMain) clazz.newInstance();
        instance.setName("amos");
        System.out.println(JSON.toJSONString(instance));
        // {"name":"amos"}

        InstanceMain obj = InstanceMain.class.newInstance();
        obj.setName("amos");
        System.out.println(JSON.toJSONString(obj));
        // {"name":"amos"}
    }

}
