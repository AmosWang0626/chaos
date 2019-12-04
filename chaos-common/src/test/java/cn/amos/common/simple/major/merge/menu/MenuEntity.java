package cn.amos.common.simple.major.merge.menu;

import lombok.Data;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/11/14
 */
@Data
public class MenuEntity {

    /**
     * 菜单编号
     */
    private String no;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单父编号
     */
    private String parentNo;
    /**
     * 菜单备注
     */
    private String desc;

    public MenuEntity(String no, String parentNo) {
        this.no = no;
        this.parentNo = parentNo;
    }
}
