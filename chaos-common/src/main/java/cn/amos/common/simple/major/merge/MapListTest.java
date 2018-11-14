package cn.amos.common.simple.major.merge;

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
public class MapListTest {

    public static void main(String[] args) {
        List<ManageMenuEntity> manageMenuEntityList = new ArrayList<>();
        manageMenuEntityList.add(new ManageMenuEntity("A0001"));
        manageMenuEntityList.add(new ManageMenuEntity("A0002"));
        manageMenuEntityList.add(new ManageMenuEntity("A0003"));
        manageMenuEntityList.add(new ManageMenuEntity("B0001"));
        manageMenuEntityList.add(new ManageMenuEntity("B0002"));
        manageMenuEntityList.add(new ManageMenuEntity("B0003"));
        manageMenuEntityList.add(new ManageMenuEntity("C0001"));
        manageMenuEntityList.add(new ManageMenuEntity("C0002"));
        manageMenuEntityList.add(new ManageMenuEntity("C0003"));

        System.out.println(group(manageMenuEntityList));
    }

    public static Map<String, List<ManageMenuEntity>> group(List<ManageMenuEntity> menus) {
        Map<String, List<ManageMenuEntity>> map = new HashMap<>(3);

        for (ManageMenuEntity menu : menus) {
            List<ManageMenuEntity> list;

            if (menu.getNo().startsWith("A")) {
                list = map.get("A");
                list = (list == null ? new ArrayList<>() : list);
                list.add(menu);
                map.put("A", list);
            }
            if (menu.getNo().startsWith("B")) {
                list = map.get("B");
                list = list == null ? new ArrayList<>() : list;
                list.add(menu);
                map.put("B", list);
            }
            if (menu.getNo().startsWith("C")) {
                list = map.get("C");
                list = (list == null ? new ArrayList<>() : list);
                list.add(menu);
                map.put("C", list);
            }
        }
        return map;
    }

    static class ManageMenuEntity {

        private String no;

        public ManageMenuEntity(String no) {
            this.no = no;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "ManageMenuEntity{" +
                    "no='" + no + '\'' +
                    '}';
        }
    }

}
