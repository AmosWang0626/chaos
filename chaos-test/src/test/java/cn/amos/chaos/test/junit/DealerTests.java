package cn.amos.chaos.test.junit;

import cn.amos.chaos.test.pojo.dto.DealerInfoDTO;
import cn.amos.chaos.test.pojo.dto.DealerInfoVO;
import cn.amos.chaos.test.pojo.dto.DealerResponse;
import cn.amos.chaos.test.service.DealerService;
import cn.amos.common.utils.base.RedisUtils;
import com.amos.common.dto.response.MultiResponse;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DealerTests {

    private String dealerInfoUrl;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DealerService dealerService;

    private static final String DEALER_INFO = "DEALER_INFO";


    @Test
    void getDealerInfo() {
        String dealerInfo = RedisUtils.get(DEALER_INFO);
        if (dealerInfo != null && dealerInfo.trim().length() > 0) {
            DealerResponse dealerResponse = new Gson().fromJson(dealerInfo, DealerResponse.class);
            System.out.println(dealerResponse.getData().size());
            return;
        }
        ResponseEntity<String> forEntity = restTemplate.getForEntity(dealerInfoUrl, String.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            String body = forEntity.getBody();
            RedisUtils.set(DEALER_INFO, body);
            DealerResponse dealerResponse = new Gson().fromJson(body, DealerResponse.class);
            System.out.println(dealerResponse.getData().size());
        }
    }

    @Test
    public void filterDealers() {
        String code = "1101";
        String tag = "服务站";
        MultiResponse<DealerInfoVO> dealers = dealerService.getDealers(code, tag, "凯翔");
        System.out.println("dealer size is " + dealers.getData().size());
        System.out.println("dealer body is " + dealers.getData());
    }


    /**
     * test use Gson parse json
     */
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = "";
        DealerInfoDTO jsonToObj = gson.fromJson(json, DealerInfoDTO.class);
        List<DealerInfoDTO> list = new ArrayList<>();
        list.add(jsonToObj);
        List<DealerInfoDTO> collect = list.stream()
                .filter(dealerInfoDTO -> StringUtils.isBlank("") || dealerInfoDTO.getCityId().equals(""))
                .collect(Collectors.toList());
        System.out.println(gson.toJson(collect));
    }


}
