package cn.amos.frame.dubbo;

/**
 * PROJECT: permit
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/11/28
 */
public interface HelloService {

    /**
     * say hello
     *
     * @param name name
     * @param info info
     * @return response
     */
    String sayHello(String name, String info);

}
