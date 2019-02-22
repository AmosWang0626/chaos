package cn.amos.mode.base.abstracts.graph;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/21
 */
public class GraphFactory {

    static BaseGraph getInstance(ParamForm paramForm) {
        if (paramForm == null || paramForm.getFlag() == null) {
            return null;
        }

        if (paramForm.getFlag() == 1) {
            return new GraphCycle(paramForm.getRadius());
        } else if (paramForm.getFlag() == 2) {
            return new GraphRectangle(paramForm.getLength(), paramForm.getHeight());
        } else {
            return null;
        }
    }

}
