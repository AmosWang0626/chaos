package cn.amos.algorithm.hit.word.config;

import cn.amos.algorithm.hit.word.common.api.GSON;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * WordConfig
 *
 * @author amos.wang
 */
@Component
public class WordConfig {

    @Value("classpath:static/words.json")
    private Resource filePath;


    public Set<String> getWords() {
        Set<String> set = new HashSet<>();
        try {
            JsonArray jsonArray = GSON.fromJson(new FileReader(filePath.getFile()), JsonArray.class);
            jsonArray.forEach(element -> set.add(element.getAsString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }

}
