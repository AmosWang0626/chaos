package cn.amos.frame.spring.service;

import cn.amos.frame.spring.utils.AmosUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * DESCRIPTION: UserService
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
@Component
public class UserService {

    @Resource
    private IndexService indexService;

    public UserService() {
        AmosUtils.println("UserService init");
    }

    @PostConstruct
    public void callback() {
        AmosUtils.println("UserService init CallBack");
    }

    public IndexService getIndexService() {
        return indexService;
    }

}
