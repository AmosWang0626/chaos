package cn.amos.frame.spring.service;

import cn.amos.frame.spring.utils.AmosUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * DESCRIPTION: IndexService
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
@Component
public class IndexService {

    @Resource
    private UserService userService;

    public IndexService() {
        AmosUtils.println("IndexService init");
    }

    public UserService getUserService() {
        return userService;
    }

}
