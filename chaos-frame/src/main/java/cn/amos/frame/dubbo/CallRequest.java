package cn.amos.frame.dubbo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * DESCRIPTION: CallRequest
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/10/28
 */
@Setter
@Getter
@Accessors(chain = true)
public class CallRequest {

    /**
     * 类名（全路径）
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;
    /**
     * 参数
     */
    private Object[] params;
    /**
     * 返回值类型
     */
    private Class<?> responseType;

}
