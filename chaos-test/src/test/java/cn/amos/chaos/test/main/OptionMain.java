package cn.amos.chaos.test.main;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

/**
 * DESCRIPTION: option
 *
 * @author amos.wang
 * @date 2019/8/28
 */
public class OptionMain {

    public static void main(String[] args) {
        boolean present = Optional.of(getUser())
                .map(OptionMain::changeUser)
                .map(UserVO::getId)
                .filter(StringUtils::isNotEmpty)
                .isPresent();
        System.out.println(present);

        test();
    }

    private static UserVO getUser() {
        UserVO userVO = new UserVO();
        userVO.setId("12345678");
        userVO.setName("amos.wang");
        userVO.setGender("man");
        userVO.setDescription("description");
        return userVO;
    }

    private static UserVO changeUser(UserVO userVO) {
        userVO.setId("");
        return userVO;
    }

    private static void test() {
        Optional<UserVO> user = Optional.ofNullable(getUser("ofNullable"));
        user.ifPresent(System.out::println);

        Optional<UserVO> user2 = Optional.ofNullable(getUser(""));
        System.out.println(user2.orElse(getUser("orElse")));

        Optional<UserVO> user3 = Optional.ofNullable(getUser(""));
        System.out.println(user3.orElseGet(() -> getUser("orElseGet")));

        Optional<UserVO> user4 = Optional.ofNullable(getUser("filter"));
        System.out.println(user4.filter(userVO -> userVO.getName().equals("filter")).orElse(getUser("orElse")));

        Optional<UserVO> user5 = Optional.ofNullable(getUser("mmp"));
        System.out.println(user5.map(userVO -> userVO.setId(userVO.getId().replace("-", "")).setName("map")));

        Optional<UserVO> user6 = Optional.ofNullable(getUser("flatMap"));
        System.out.println(user6.flatMap(userVO -> Optional.of(userVO.setId(userVO.getId().replace("-", "")))));

        Optional<UserVO> user7 = Optional.ofNullable(getUser("flatMap"));
        System.out.println(user7.flatMap(userVO -> Optional.of(userVO.setId(userVO.getId().replace("-", "")))));
    }

    private static UserVO getUser(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(UUID.randomUUID().toString());
        userVO.setName(name);
        userVO.setGender(new Random().nextBoolean() ? "0" : "1");
        userVO.setDescription("this is description!");

        return userVO;
    }
}


@Accessors(chain = true)
@Data
class UserVO {
    private String id;
    private String name;
    private String gender;
    private String description;
}
