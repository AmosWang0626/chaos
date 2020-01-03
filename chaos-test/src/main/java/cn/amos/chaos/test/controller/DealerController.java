package cn.amos.chaos.test.controller;

import cn.amos.chaos.test.pojo.dto.DealerInfoDTO;
import cn.amos.chaos.test.service.DealerService;
import cn.amos.common.response.GeneralResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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


    @GetMapping("info")
    public GeneralResponse<List<DealerInfoDTO>> dealerInfo(String city, String tag) {

        return dealerService.getDealers(city, tag);
    }

}
