package cn.amos.common.map;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("province_code")
    private String provinceCode;
    private String province;

    @JsonProperty("city_code")
    private String cityCode;
    private String city;

    @JsonProperty("district_code")
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
