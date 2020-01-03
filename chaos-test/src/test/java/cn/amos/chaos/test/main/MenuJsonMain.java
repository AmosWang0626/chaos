package cn.amos.chaos.test.main;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PROJECT: Sales
 * DESCRIPTION: 三级菜单分层展示Demo
 *
 * @author amos
 * @date 2019/5/9
 */
public class MenuJsonMain {

    public static void main(String[] args) {
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("101", null, 1));
        list.add(new Menu("102", null, 1));
        list.add(new Menu("201", "101", 2));
        list.add(new Menu("202", "101", 2));
        list.add(new Menu("203", "102", 2));
        list.add(new Menu("204", "102", 2));
        list.add(new Menu("301", "201", 3));
        list.add(new Menu("302", "202", 3));
        list.add(new Menu("303", "203", 3));
        list.add(new Menu("304", "204", 3));

        List<Menu> menuList = new ArrayList<>();
        Map<String, List<Menu>> level2Map = new HashMap<>();
        Map<String, List<Menu>> level3Map = new HashMap<>();

        list.forEach(menu -> {
            if (menu.getLevel() == 1) {
                menuList.add(menu);
            } else if (menu.getLevel() == 2) {
                List<Menu> menus2 = level2Map.get(menu.getParentId());
                if (menus2 == null) {
                    menus2 = new ArrayList<>();
                }
                menus2.add(menu);
                level2Map.put(menu.getParentId(), menus2);
            } else if (menu.getLevel() == 3) {
                List<Menu> menus3 = level3Map.get(menu.getParentId());
                if (menus3 == null) {
                    menus3 = new ArrayList<>();
                }
                menus3.add(menu);
                level3Map.put(menu.getParentId(), menus3);
            }
        });

        level2Map.forEach((s, menus) -> {
            menus.forEach(menu -> menu.setChild(level3Map.get(menu.getId())));
            level2Map.put(s, menus);
        });

        menuList.forEach(menu -> {
            menu.setChild(level2Map.get(menu.getId()));
            System.out.println(menu);
        });

        System.out.println(menuList);
    }

    @Data
    private static class Menu {
        private String id;
        private String parentId;
        private Integer level;
        private List<Menu> child;

        public Menu(String id, String parentId, Integer level) {
            this.id = id;
            this.parentId = parentId;
            this.level = level;
        }

    }

}
