package cn.amos.chaos.test.service;

import cn.amos.chaos.test.pojo.dto.DealerInfoVO;
import com.amos.common.dto.response.MultiResponse;

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
    MultiResponse<DealerInfoVO> getDealers(String code, String tag, String storeKeyword);

}
