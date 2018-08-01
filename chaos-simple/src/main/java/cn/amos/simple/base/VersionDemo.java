package cn.amos.simple.base;

/**
 * PROJECT: chaos
 * @date 2017/10/25
 *
 * @author DaoYuanWang
 */
public class VersionDemo {

    private static final String VERSION = "1.1.1";

    public static void main(String[] args) {
//        boolean boo = versionSesame();
//        System.out.println(boo);

        checkVersion();
    }

    private static boolean versionSesame() {
        // 当前用户App版本号
        String[] versionArray = VERSION.split("\\.");
        for (String str : versionArray) {
            if (Integer.parseInt(str) < 1) {
                return false;
            }
        }
        return true;
    }

    private static Boolean checkVersion() {
        String version1 = "1.2.1";
        String version2 = "1.2.22";

        int a1 = version1.indexOf(".", 1);
        int a2 = version1.lastIndexOf(".");
        int b1 = version2.indexOf(".", 1);
        int b2 = version2.lastIndexOf(".");

        if (a1 == b1 && a2 == b2 && version1.length() == version2.length()) {
            int num1 = Integer.parseInt(version1.replace(".", ""));
            int num2 = Integer.parseInt(version2.replace(".", ""));
            System.out.println(num1 > num2 ? "old" : "new");
        }

        System.out.println(a1 > b1 ? "old" : "new");
        System.out.println(a1 == b1 && a2 > b2 ? "old" : "new");

        return true;
    }
}
