package cn.amos.mode.base.abstracts.entity;

import java.util.Date;

/**
 * PROJECT: chaos
 * DESCRIPTION: 不需要实例化的用Abstract
 *
 * @author Daoyuan
 * @date 2019/2/21
 */
public abstract class BaseEntity {

    private Long id;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
