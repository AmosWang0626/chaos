package cn.amos.common.simple.major.merge.menu;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/11/14
 */
public class MenuFinal {

    private static List<MenuEntity> MENU_ENTITY_LIST = new ArrayList<>();

    private static Map<String, MenuVO> ROOT_MAP = new HashMap<>();
    private static Map<String, MenuVO> SECOND_MAP = new HashMap<>();

    private static void init() {
        MENU_ENTITY_LIST.add(new MenuEntity("A1", null));
        MENU_ENTITY_LIST.add(new MenuEntity("A2", null));

        MENU_ENTITY_LIST.add(new MenuEntity("B1", "A1"));
        MENU_ENTITY_LIST.add(new MenuEntity("B2", "A1"));
        MENU_ENTITY_LIST.add(new MenuEntity("B3", "A2"));
        MENU_ENTITY_LIST.add(new MenuEntity("B4", "A2"));

        MENU_ENTITY_LIST.add(new MenuEntity("C1", "B1"));
        MENU_ENTITY_LIST.add(new MenuEntity("C2", "B1"));
        MENU_ENTITY_LIST.add(new MenuEntity("C3", "B2"));
        MENU_ENTITY_LIST.add(new MenuEntity("C4", "B2"));
        MENU_ENTITY_LIST.add(new MenuEntity("C5", "B2"));
        MENU_ENTITY_LIST.add(new MenuEntity("C6", "B3"));
        MENU_ENTITY_LIST.add(new MenuEntity("C7", "B3"));
        MENU_ENTITY_LIST.add(new MenuEntity("C8", "B4"));
        MENU_ENTITY_LIST.add(new MenuEntity("C9", "B4"));
    }

    private static List<MenuVO> initMenuVOS(List<MenuEntity> menuEntities) {
        List<MenuVO> menuVOList = new ArrayList<>();
        for (MenuEntity menuEntity : menuEntities) {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(menuEntity, menuVO);
            // 先初始化根菜单
            if (menuVO.getParentNo() == null) {
                ROOT_MAP.put(menuVO.getNo(), menuVO);
                continue;
            }
            menuVOList.add(menuVO);
        }
        return menuVOList;
    }


    public static void main(String[] args) {
        // 初始化数据
        init();

        // 将实体转化为VO，并初始化一级菜单
        List<MenuVO> menuVOList = initMenuVOS(MENU_ENTITY_LIST);

        // 筛选出二级菜单
        for (MenuVO menuVO : menuVOList) {
            if (menuVO.getParentNo() != null && ROOT_MAP.get(menuVO.getParentNo()) != null) {
                SECOND_MAP.put(menuVO.getNo(), menuVO);
            }
        }

        // 筛选出三级菜单，并关联二级菜单
        for (MenuVO menuVO : menuVOList) {
            if (menuVO.getParentNo() != null && SECOND_MAP.get(menuVO.getParentNo()) != null) {
                // 取出二级菜单,设置三级菜单
                MenuVO tempMenu = SECOND_MAP.get(menuVO.getParentNo());
                List<MenuVO> childMenus = tempMenu.getChildMenus();
                if (childMenus == null) {
                    childMenus = new ArrayList<>();
                }
                childMenus.add(menuVO);
                tempMenu.setChildMenus(childMenus);
                SECOND_MAP.put(menuVO.getParentNo(), tempMenu);
            }
        }

        // 二级菜单关联一级菜单
        SECOND_MAP.forEach((key, value) -> {
            MenuVO tempMenu = ROOT_MAP.get(value.getParentNo());
            List<MenuVO> childMenus = tempMenu.getChildMenus();
            if (childMenus == null) {
                childMenus = new ArrayList<>();
            }
            childMenus.add(value);
            tempMenu.setChildMenus(childMenus);
            ROOT_MAP.put(value.getParentNo(), tempMenu);
        });

        System.out.println(ROOT_MAP);
    }

}
