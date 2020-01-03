package cn.amos.chaos.test.dao.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * DESCRIPTION: user & group
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/11/27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@Entity
@Table(name = "DEV_USER_GROUP")
@IdClass(UserGroupIds.class)
public class UserGroupEntity implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    private Integer type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGroupEntity)) return false;
        UserGroupEntity that = (UserGroupEntity) o;
        return Objects.equals(user.getId(), that.user.getId()) &&
                Objects.equals(group.getId(), that.group.getId()) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        if (user == null || group == null) {
            return super.hashCode();
        }
        return Objects.hash(user.getId(), group.getId(), type);
    }
}
