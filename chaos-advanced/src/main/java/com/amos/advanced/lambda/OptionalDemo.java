package com.amos.advanced.lambda;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;
import java.util.Optional;

/**
 * optional
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/3/1
 */
public class OptionalDemo {

    public static void main(String[] args) {
        // init
        Hello hello = new Hello();
        hello.setId(100000L);

        Hello hello2 = null;

        // map
        Long id = Optional.ofNullable(hello).map(Hello::getId).orElse(null);
        Long id2 = Optional.ofNullable(hello2).map(Hello::getId).orElse(null);

        System.out.println(id);
        System.out.println(id2);

        // flatMap
        Optional<Long> ol = Optional.ofNullable(hello).flatMap(obj -> Optional.ofNullable(obj.getId()));
        Optional<Long> ol2 = Optional.ofNullable(hello2).flatMap(obj -> Optional.ofNullable(obj.getId()));

        System.out.println(ol.orElse(null));
        System.out.println(ol2.orElse(null));

        // filter
        Hello fHello = Optional.ofNullable(hello).filter(obj -> Objects.nonNull(hello.getId())).orElse(null);
        Hello fHello2 = Optional.ofNullable(hello2).filter(obj -> Objects.nonNull(hello.getId())).orElse(null);

        System.out.println(fHello);
        System.out.println(fHello2);

    }

    @Getter
    @Setter
    private static class Hello {

        private Long id;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

}
