package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/27
 */
public class CakeAaaSweet extends BaseSweet {

    @Override
    String wear() {
        return "奶油蛋糕";
    }

    @Override
    double price() {
        return 66;
    }
}
