package cn.amos.chaos.test.dao.mapper;

import cn.amos.chaos.test.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DESCRIPTION: UserRepository
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/11/27
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
