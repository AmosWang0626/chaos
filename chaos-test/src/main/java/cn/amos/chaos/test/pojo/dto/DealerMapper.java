package cn.amos.chaos.test.pojo.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * DESCRIPTION: map-struct mapper
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 1/3/2020
 */
@Mapper
public interface DealerMapper {

    DealerMapper INSTANCE = Mappers.getMapper(DealerMapper.class);


    @Mappings({})
    DealerInfoVO convert(DealerInfoDTO simpleBean);

    @Mappings({})
    DealerInfoDTO backConvert(DealerInfoVO simpleBean);

}
