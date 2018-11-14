package cn.amos.common.simple.major.merge.menu;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/11/14
 */
public class MenuVO {
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

    /**
     * 子菜单
     */
    private List<MenuVO> childMenus;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<MenuVO> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<MenuVO> childMenus) {
        this.childMenus = childMenus;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
