package cn.amos.common.response;

import lombok.Getter;

/**
 * DESCRIPTION: ExceptionCodeEnum
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/1/3
 */
@Getter
public enum ExceptionCodeEnum {
    ;

    private final String code;
    private final String message;

    ExceptionCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
