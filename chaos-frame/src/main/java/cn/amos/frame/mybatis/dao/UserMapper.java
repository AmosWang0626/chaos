package cn.amos.frame.mybatis.dao;

import cn.amos.frame.mybatis.plugin.PageModule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * DESCRIPTION: UserMapper
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
public interface UserMapper {

    @Select("select * from org_user")
    List<UserEntity> queryAll();

    @Select("select * from org_user")
    List<UserEntity> queryByPage(PageModule pageModule);

}
