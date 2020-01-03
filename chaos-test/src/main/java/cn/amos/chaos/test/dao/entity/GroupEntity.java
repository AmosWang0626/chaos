package cn.amos.chaos.test.dao.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * DESCRIPTION: GROUP
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/11/27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "userGroupEntities")
@Accessors(chain = true)
@Builder
@Entity
@Table(name = "DEV_GROUP")
public class GroupEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(updatable = false)
    private String id;

    private String name;

    /**
     * 使用 OneToMany, 必须加 mappedBy
     * 要想保存 UserGroupEntity, 必须增加 cascade = CascadeType.ALL
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", orphanRemoval = true)
    private Set<UserGroupEntity> userGroupEntities;

}