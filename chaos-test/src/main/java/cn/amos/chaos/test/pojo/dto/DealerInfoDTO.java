package cn.amos.chaos.test.pojo.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * DESCRIPTION: DealerInfoDTO
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/1/2
 */
@Data
public class DealerInfoDTO {

    @SerializedName("DealerId")
    private String dealerId;
    @SerializedName("DealerCode")
    private String dealerCode;
    @SerializedName("DealerName")
    private String dealerName;
    @SerializedName("ProvinceId")
    private String provinceId;
    @SerializedName("CityId")
    private String cityId;
    @SerializedName("Lng")
    private String lng;
    @SerializedName("Lat")
    private String lat;
    @SerializedName("Address")
    private String address;
    @SerializedName("Tel")
    private String tel;
    @SerializedName("SalesTel")
    private String salesTel;
    @SerializedName("DealerTag")
    private String dealerTag;

}
