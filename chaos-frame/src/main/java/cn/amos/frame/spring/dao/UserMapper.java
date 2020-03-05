package cn.amos.frame.spring.dao;

import cn.amos.frame.spring.api.MySelect;

import java.util.List;

/**
 * DESCRIPTION: UserMapper
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return 所有用户
     */
    @MySelect("select * form user")
    List<String> queryAll();

}
