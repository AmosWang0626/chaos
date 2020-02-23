package com.amos.design.structure.flyweight;

/**
 * DESCRIPTION: 网站
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/23/2020
 */
public interface Website {

    /**
     * 访问网站
     *
     * @param visitor 访问人
     */
    void access(Visitor visitor);

}
