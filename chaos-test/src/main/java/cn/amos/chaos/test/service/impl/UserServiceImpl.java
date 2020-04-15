package cn.amos.chaos.test.service.impl;

import cn.amos.chaos.test.dao.entity.UserEntity;
import cn.amos.chaos.test.dao.mapper.UserRepository;
import cn.amos.chaos.test.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * DESCRIPTION: UserServiceImpl
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/4/15
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public String save(String username) {
        UserEntity userEntity = userRepository.save(new UserEntity().setUsername(username));

        if (true) {
            throw new RuntimeException("fail!!!!!!!!!!!!");
        }

        return userEntity.getId();
    }

    @Override
    public String save2(String username) {

        return save(username);
    }

}
