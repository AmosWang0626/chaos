package cn.amos.algorithm.hit.word.common.api;

import com.google.gson.*;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;

/**
 * 模块名称: participle
 * 模块描述: 模仿 JSON 搞一下
 *
 * @author amos.wang
 * @date 2020/5/25 13:11
 */
public class GSON {

    /**
     * singleton
     */
    private static final Gson GSON = new Gson();


    public static GsonBuilder newBuilder() {
        return GSON.newBuilder();
    }


    public static Excluder excluder() {
        return GSON.excluder();
    }


    public static FieldNamingStrategy fieldNamingStrategy() {
        return GSON.fieldNamingStrategy();
    }


    public static boolean serializeNulls() {
        return GSON.serializeNulls();
    }


    public static boolean htmlSafe() {
        return GSON.htmlSafe();
    }


    public static <T> TypeAdapter<T> getAdapter(TypeToken<T> type) {
        return GSON.getAdapter(type);
    }


    public static <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory skipPast, TypeToken<T> type) {
        return GSON.getDelegateAdapter(skipPast, type);
    }


    public static <T> TypeAdapter<T> getAdapter(Class<T> type) {
        return GSON.getAdapter(type);
    }


    public static JsonElement toJsonTree(Object src) {
        return GSON.toJsonTree(src);
    }


    public static JsonElement toJsonTree(Object src, Type typeOfSrc) {
        return GSON.toJsonTree(src, typeOfSrc);
    }


    public static String toJson(Object src) {
        return GSON.toJson(src);
    }


    public static String toJson(Object src, Type typeOfSrc) {
        return GSON.toJson(src, typeOfSrc);
    }


    public static void toJson(Object src, Appendable writer) throws JsonIOException {
        GSON.toJson(src, writer);
    }


    public static void toJson(Object src, Type typeOfSrc, Appendable writer) throws JsonIOException {
        GSON.toJson(src, typeOfSrc, writer);
    }


    public static void toJson(Object src, Type typeOfSrc, JsonWriter writer) throws JsonIOException {
        GSON.toJson(src, typeOfSrc, writer);
    }


    public static String toJson(JsonElement jsonElement) {
        return GSON.toJson(jsonElement);
    }


    public static void toJson(JsonElement jsonElement, Appendable writer) throws JsonIOException {
        GSON.toJson(jsonElement, writer);
    }


    public static JsonWriter newJsonWriter(Writer writer) throws IOException {
        return GSON.newJsonWriter(writer);
    }


    public static JsonReader newJsonReader(Reader reader) {
        return GSON.newJsonReader(reader);
    }


    public static void toJson(JsonElement jsonElement, JsonWriter writer) throws JsonIOException {
        GSON.toJson(jsonElement, writer);
    }


    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return GSON.fromJson(json, classOfT);
    }


    public static <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        return GSON.fromJson(json, typeOfT);
    }


    public static <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        return GSON.fromJson(json, classOfT);
    }


    public static <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return GSON.fromJson(json, typeOfT);
    }


    public static <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return GSON.fromJson(reader, typeOfT);
    }


    public static <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
        return GSON.fromJson(json, classOfT);
    }


    public static <T> T fromJson(JsonElement json, Type typeOfT) throws JsonSyntaxException {
        return GSON.fromJson(json, typeOfT);
    }

}
