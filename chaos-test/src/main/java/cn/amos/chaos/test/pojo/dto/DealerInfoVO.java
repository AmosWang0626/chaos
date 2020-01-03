package cn.amos.chaos.test.pojo.dto;

import lombok.Data;

/**
 * DESCRIPTION: DealerInfoVO
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/1/2
 */
@Data
public class DealerInfoVO {

    /**
     * dealer info
     */
    private String dealerId;
    private String dealerCode;
    private String dealerName;
    private String dealerTag;

    /**
     * address info
     */
    private String provinceId;
    private String cityId;
    private String lng;
    private String lat;
    private String address;

    /**
     * contact
     */
    private String tel;
    private String salesTel;

}
