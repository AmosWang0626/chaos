package cn.amos.simple.base;

/**
 * PROJECT: chaos
 *
 * @author DaoYuanWang
 * @apiNote 校验Object不能为空
 * @date 2018/1/31
 */
public class ObjectDemo {

    /**
     * 校验对象不能为空
     *
     * @param object 对象不能为空
     * @return 不为空 true; 为空 false.
     */
    private static boolean singleNotNull(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof String) {
            String str = object.toString().trim();
            if (str.length() == 0) {
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                // 如果有一个字符不为空就return不为空true
                if (!Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Object Not Null: " + singleNotNull(""));
    }

}
