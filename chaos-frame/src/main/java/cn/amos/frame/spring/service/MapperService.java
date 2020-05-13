package cn.amos.frame.spring.service;

import cn.amos.frame.spring.dao.UserMapper;
import cn.amos.frame.spring.utils.AmosUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * DESCRIPTION: MapperService
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
@Service
public class MapperService {

    @Resource
    private UserMapper userMapper;

    public MapperService() {
        AmosUtils.println("MapperService init");
    }

    public void queryAll() {
        List<String> list = userMapper.queryAll();
        System.out.println("userMapper\t" + userMapper);
        System.out.println("userMapper.queryAll()\t" + list);
    }

}
