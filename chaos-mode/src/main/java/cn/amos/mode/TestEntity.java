package cn.amos.mode;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/6
 */
@Data
@Accessors(chain = true)
public class TestEntity {

    private String id;
    private String name;
    private String gender;


    public static void main(String[] args) {
        System.out.println(new TestEntity().setGender("1").setId("666").setName("name"));
    }
}
