package cn.amos.chaos.test.junit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * DESCRIPTION: 中国省市区信息
 * <a title="中国省市区信息" href="https://github.com/airyland/china-area-data"/>
 *
 * @author amos.wang
 * @date 2019/5/28
 */
@Slf4j
@SpringBootTest
public class ChinaAreaTests {

    @Value("classpath:static/elementui/data.json")
    private Resource areaData;

    private static JSONObject BASE_AREA_DATA = null;

    @Test
    public void areaDateToString() throws IOException {
        String content = FileUtils.readFileToString(areaData.getFile(), "UTF-8");

        BASE_AREA_DATA = JSON.parseObject(content);

        if (BASE_AREA_DATA == null) {
            return;
        }

        // 拿到国内所有省份
        JSONObject chinaData = BASE_AREA_DATA.getJSONObject("86");
        JSONArray jsArrayData = getChildrenArray(chinaData);

        FileUtils.writeStringToFile(new File("C:\\Users\\User\\Desktop\\area-data.js"), jsArrayData.toString(), Charset.forName("UTF-8"));
    }

    /**
     * 递归设置 children
     */
    private static JSONArray getChildrenArray(JSONObject jsonObject) {
        if (jsonObject == null || jsonObject.size() == 0) {
            return null;
        }
        JSONArray childrenArray = new JSONArray();
        jsonObject.forEach((code, label) -> {
            JSONObject tempJSONObj = new JSONObject();
            tempJSONObj.put("label", label);
            tempJSONObj.put("value", label);
            tempJSONObj.put("children", getChildrenArray(BASE_AREA_DATA.getJSONObject(code)));

            childrenArray.add(tempJSONObj);
        });

        return childrenArray;
    }

}
