package cn.amos.chaos.test.junit;

import cn.amos.chaos.test.dao.entity.GroupEntity;
import cn.amos.chaos.test.dao.entity.UserEntity;
import cn.amos.chaos.test.dao.entity.UserGroupEntity;
import cn.amos.chaos.test.dao.mapper.GroupRepository;
import cn.amos.chaos.test.dao.mapper.UserGroupRepository;
import cn.amos.chaos.test.dao.mapper.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * DESCRIPTION: JpaTests
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/11/27
 */
@Slf4j
@SpringBootTest
public class JpaTests {
    @Resource
    private UserRepository userRepository;
    @Resource
    private GroupRepository groupRepository;
    @Resource
    private UserGroupRepository userGroupRepository;

    @Test
    public void saveUser() {
        for (int i = 0; i < 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername("amos-0" + i);
            userRepository.save(userEntity);
        }
    }

    @Test
    public void saveGroup() {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setName("group " + System.currentTimeMillis());
        HashSet<UserGroupEntity> userGroupEntities = new HashSet<>();
        userGroupEntities.add(
                new UserGroupEntity().setType(1).setGroup(groupEntity)
                        .setUser(new UserEntity().setId("8a80cb816eaafe63016eaafe75f20004"))
        );
        groupEntity.setUserGroupEntities(userGroupEntities);
        groupRepository.save(groupEntity);
    }

    @Test
    public void updateGroup() {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId("8a80cb816eab90eb016eab9103e20000");
        groupEntity.setName("group " + System.currentTimeMillis());
        groupEntity.setUserGroupEntities(Collections.emptySet());
        groupRepository.save(groupEntity);
        Set<UserGroupEntity> userGroupEntities = new HashSet<>();
        userGroupEntities.add(
                new UserGroupEntity().setType(100).setGroup(groupEntity)
                        .setUser(new UserEntity().setId("8a80cb816eaafe63016eaafe75a40002"))
        );
        userGroupEntities.add(
                new UserGroupEntity().setType(100).setGroup(groupEntity)
                        .setUser(new UserEntity().setId("8a80cb816eaafe63016eaafe75c70003"))
        );
        userGroupEntities.add(
                new UserGroupEntity().setType(100).setGroup(groupEntity)
                        .setUser(new UserEntity().setId("8a80cb816eaafe63016eaafe76140005"))
        );
        groupEntity.setUserGroupEntities(userGroupEntities);
        userGroupRepository.saveAll(userGroupEntities);
    }

    @Test
    public void emptySetUserGroup() {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId("8a80cb816eab90eb016eab9103e20000");
        groupEntity.setName("group " + System.currentTimeMillis());
        groupEntity.setUserGroupEntities(Collections.emptySet());
        groupRepository.save(groupEntity);
    }

}
