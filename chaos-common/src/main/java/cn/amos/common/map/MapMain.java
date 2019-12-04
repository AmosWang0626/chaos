package cn.amos.common.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * DESCRIPTION: Main
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/12/4
 */
public class MapMain {

    private static final String EXCEL_TO_JSON_FILE_NAME = "map.json";


    public static void main(String[] args) {
        // 初始化数据
        List<BaseDataDTO> parse = JSONArray.parseArray(getJson(), BaseDataDTO.class);

        // 解析数据，通过 Map 间接去重
        Map<String, DataMapVO> dataMap = new TreeMap<>();
        parse.forEach(dto -> {
            // 省
            DataMapVO province = dataMap.get(dto.getProvinceCode());
            if (province == null) {
                province = new DataMapVO(dto.getProvinceCode(), dto.getProvince()).setChildrenMap(new TreeMap<>());
                dataMap.put(dto.getProvinceCode(), province);
            }

            // 市
            Map<String, DataMapVO> cityMap = province.getChildrenMap();
            DataMapVO city = cityMap.get(dto.getCityCode());
            if (city == null) {
                city = new DataMapVO(dto.getCityCode(), dto.getCity()).setChildrenMap(new TreeMap<>());
                cityMap.put(dto.getCityCode(), city);
            }

            // 区
            city.getChildrenMap().put(dto.getDistrictCode(), new DataMapVO(dto.getDistrictCode(), dto.getDistrict()));
        });
        System.out.println(JSON.toJSONString(dataMap));
        System.out.println("JSON包含行政区数目: " + dataMap.size());

        // 处理 Map 数据，转化为 tree
        List<DataListVO> dataTreeList = new ArrayList<>();
        dataMap.values().forEach(province -> {
            DataListVO provinceListVO = new DataListVO(province.getId(), province.getName());
            provinceListVO.setChildren(new HashSet<>());
            province.getChildrenMap().values().forEach(cityMapVO -> {
                DataListVO cityListVO = new DataListVO(cityMapVO.getId(), cityMapVO.getName()).setChildren(new HashSet<>());
                cityMapVO.getChildrenMap().values().forEach(districtMapVO -> {
                    cityListVO.getChildren().add(new DataListVO(districtMapVO.getId(), districtMapVO.getName()));
                });
                provinceListVO.getChildren().add(cityListVO);
            });
            dataTreeList.add(provinceListVO);
        });

        System.out.println(JSON.toJSONString(dataTreeList));
    }

    private static String getJson() {
        ClassPathResource resource = new ClassPathResource(EXCEL_TO_JSON_FILE_NAME);

        StringBuilder sb = new StringBuilder();

        try {
            File jsonFile = resource.getFile();
            if (!jsonFile.exists()) {
                return sb.toString();
            }
            FileInputStream fis = new FileInputStream(jsonFile);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
