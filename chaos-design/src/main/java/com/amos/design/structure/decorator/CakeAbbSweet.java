package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/27
 */
public class CakeAbbSweet extends BaseSweet {

    @Override
    String wear() {
        return "水果蛋糕";
    }

    @Override
    double price() {
        return 66;
    }
}
