package cn.amos.chaos.test.service.impl;

import cn.amos.chaos.test.pojo.dto.DealerInfoVO;
import cn.amos.chaos.test.pojo.dto.DealerMapper;
import cn.amos.chaos.test.pojo.dto.DealerResponse;
import cn.amos.chaos.test.service.DealerService;
import cn.amos.common.response.GeneralResponse;
import cn.amos.common.utils.base.RedisUtils;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DESCRIPTION: DealerService
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/1/3
 */
@Service("dealerService")
public class DealerServiceImpl implements DealerService {

    @Resource
    private RestTemplate restTemplate;

    @Value("${beijing-hyundai.dealer.info.url}")
    private String dealerInfoUrl;

    private static final String DEALER_INFO = "DEALER_INFO";


    @Override
    public GeneralResponse<List<DealerInfoVO>> getDealers(String code, String tag, String storeKeyword) {
        DealerResponse allDealer = getAllDealer();
        if (allDealer.getIsSuccess()) {
            List<DealerInfoVO> collect = allDealer.getData().stream()
                    .filter(dealerInfoDTO -> StringUtils.isBlank(code) || dealerInfoDTO.getCityId().equals(code))
                    .filter(dealerInfoDTO -> StringUtils.isBlank(tag) || dealerInfoDTO.getDealerTag().equals(tag))
                    .filter(dealerInfoDTO -> StringUtils.isBlank(storeKeyword) || dealerInfoDTO.getDealerName().contains(storeKeyword))
                    .map(DealerMapper.INSTANCE::convert)
                    .collect(Collectors.toList());
            return new GeneralResponse<>(collect);
        }

        return GeneralResponse.SUCCESS;
    }

    /**
     * 获取所有经销商信息
     */
    private DealerResponse getAllDealer() {
        String dealerInfo = RedisUtils.get(DEALER_INFO);
        if (StringUtils.isNotBlank(dealerInfo)) {
            return new Gson().fromJson(dealerInfo, DealerResponse.class);
        }

        ResponseEntity<String> forEntity = restTemplate.getForEntity(dealerInfoUrl, String.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            String body = forEntity.getBody();
            RedisUtils.set(DEALER_INFO, body);
            return new Gson().fromJson(body, DealerResponse.class);
        }

        return new DealerResponse().setIsSuccess(false);
    }
}
