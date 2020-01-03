package cn.amos.chaos.test.service;

import cn.amos.chaos.test.pojo.dto.DealerInfoDTO;
import cn.amos.common.response.GeneralResponse;

import java.util.List;

/**
 * DESCRIPTION: DealerService
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/1/3
 */
public interface DealerService {

    /**
     * 获取经销商信息
     *
     * @param code 城市编码
     * @param tag  门店类型
     * @return list dealer
     */
    GeneralResponse<List<DealerInfoDTO>> getDealers(String code, String tag);

}
