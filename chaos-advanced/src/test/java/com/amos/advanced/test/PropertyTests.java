package com.amos.advanced.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * DESCRIPTION: PropertyTests
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/22/2020
 */
@SpringBootTest
public class PropertyTests {

    @Test
    public void property() {
        System.out.println("sun.boot.class.path:\n" + System.getProperty("sun.boot.class.path"));
        System.out.println("java.ext.dirs:\n" + System.getProperty("java.ext.dirs"));
        System.out.println("java.class.path:\n" + System.getProperty("java.class.path"));
    }

}
