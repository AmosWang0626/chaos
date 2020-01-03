package cn.amos.chaos.test.pojo.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * DESCRIPTION: Dealer Response
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/1/2
 */
@Data
@Accessors(chain = true)
public class DealerResponse {

    @SerializedName("IsSuccess")
    private Boolean isSuccess;
    @SerializedName("Message")
    private String message;
    @SerializedName("Data")
    private List<DealerInfoDTO> data;

}
