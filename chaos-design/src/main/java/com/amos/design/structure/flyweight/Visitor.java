package com.amos.design.structure.flyweight;

import lombok.Data;

/**
 * DESCRIPTION: 访问者
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/23/2020
 */
@Data
public class Visitor {

    private String name;

    public Visitor(String name) {
        this.name = name;
    }
}
