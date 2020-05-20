package cn.amos.chaos.test.map.pojo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * DESCRIPTION: BaseDataDTO
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/12/4
 */
@Getter
@Setter
public class BaseDataDTO {

    @SerializedName("province_code")
    private String provinceCode;
    private String province;

    @SerializedName("city_code")
    private String cityCode;
    private String city;

    @SerializedName("district_code")
    private String districtCode;
    private String district;

    @Override
    public String toString() {
        return "{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
