package cn.amos.chaos.test.web.controller;

import cn.amos.chaos.test.pojo.dto.DealerInfoVO;
import cn.amos.chaos.test.service.DealerService;
import com.amos.common.dto.response.MultiResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * DESCRIPTION: 经销商
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/1/2
 */
@RestController
@RequestMapping("dealer")
public class DealerController {

    @Resource
    private DealerService dealerService;


    @CrossOrigin(origins = "*")
    @GetMapping("info")
    public MultiResponse<DealerInfoVO> dealerInfo(String city, String tag, String storeKeyword) {

        return dealerService.getDealers(city, tag, storeKeyword);
    }

}
