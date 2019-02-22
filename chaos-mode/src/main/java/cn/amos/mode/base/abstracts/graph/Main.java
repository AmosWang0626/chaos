package cn.amos.mode.base.abstracts.graph;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class Main {

    public static void main(String[] args) {
        ParamForm paramForm = new ParamForm();
        paramForm.setFlag(2);
        paramForm.setRadius(8D);
        paramForm.setLength(6D);
        paramForm.setHeight(6D);

        BaseGraph instance = GraphFactory.getInstance(paramForm);
        if (instance != null) {
            System.out.println("area: " + instance.area());
            System.out.println("perimeter: " + instance.perimeter());
        }
    }

}