package cn.amos.common.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DESCRIPTION: common response
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/1/3
 */
@Getter
@Setter
public class GeneralResponse<T> implements Serializable {

    private String code;

    private String message;

    private T body;

    private Boolean successful;

    public static final GeneralResponse SUCCESS = new GeneralResponse("1000", "成功", true);
    public static final GeneralResponse FAIL = new GeneralResponse("1001", "失败", false);

    private GeneralResponse(String code, String message, Boolean successful) {
        this.code = code;
        this.message = message;
        this.successful = successful;
    }

    public GeneralResponse(T body) {
        this.code = SUCCESS.code;
        this.message = SUCCESS.message;
        this.successful = SUCCESS.successful;
        this.body = body;
    }

    public GeneralResponse(ExceptionCodeEnum exception) {
        this.code = exception.getCode();
        this.message = exception.getMessage();
        this.successful = FAIL.successful;
    }

}
