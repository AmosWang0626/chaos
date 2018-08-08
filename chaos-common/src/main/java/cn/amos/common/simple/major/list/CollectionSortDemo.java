package cn.amos.common.simple.major.list;

import java.util.*;

/**
 * @author AmosWang
 */
public class CollectionSortDemo {

    private static final String[] STR_ARRAY = {"ab", "zz", "za", "aa", "az", "zb", "ab", "za"};

    public static void main(String[] args) {
        System.out.println("原始String []:" + Arrays.toString(STR_ARRAY));
        System.out.println("================================================================");

        // 比较 ArrayList | HashSet | TreeSet
        testArrayList();

        System.out.println("================================================================");
        testHashSet();

        System.out.println("================================================================");
        testTreeSet();

    }

    /**
     * List
     * 使用此接口能够精确的控制每个元素插入的位置
     */
    private static void testArrayList() {
        List<String> list = new ArrayList<>(Arrays.asList(STR_ARRAY));

        System.out.println("ArrayList添加元素之后原始输出:");
        list.forEach(s -> System.out.print("\t" + s + "\t"));

        // 对List进行排序
        Collections.sort(list);

        System.out.println("\nArrayList 以下是Collection.sort(List)之后的输出:");
        list.forEach(s -> System.out.print("\t" + s + "\t"));

        System.out.println("\n!!!结论!!! ArrayList 默认不去重也不排序");
    }

    /**
     * HashSet
     * 不能有重复元素
     * 自动不彻底排序
     */
    private static void testHashSet() {
        Set<String> set = new HashSet<>(Arrays.asList(STR_ARRAY));

        System.out.println("HashSet添加元素之后原始输出:");
        set.forEach(s -> System.out.print("\t" + s + "\t"));

        System.out.println("\n!!!结论!!! HashSet 已经排序并且去重,但可以看出排序不完全");
    }

    /**
     * TreeSet
     * 不能有重复元素
     * 彻底排序
     */
    private static void testTreeSet() {
        Set<String> set = new TreeSet<>(Arrays.asList(STR_ARRAY));

        System.out.println("TreeSet添加元素之后原始输出:");
        set.forEach(s -> System.out.print("\t" + s + "\t"));

        System.out.println("\n!!!结论!!! TreeSet 去重并彻底排序");
    }

}
