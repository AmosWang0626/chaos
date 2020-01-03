# 《用进废退》
> 总是在新建项目，开发一些小的功能点，也知道有这么一个项目，
> 它的名字就是 chaos，里边有许多工具类，但它太老了，两年前写的。
>
> 我想重启它，将新的技术融入进入，故想到了用进废退这个词。
>
> 就像老朋友，它一直都在，重逢的 feel，加油 ~(@^_^@)~

## ヾ(๑╹◡╹)ﾉ"

## (づ｡◕ᴗᴗ◕｡)づ

## JSON Parse
```text
JSON 解析重命名
(1) com.fasterxml.jackson.databind.ObjectMapper
@JsonProperty("DealerCode") private String dealerCode
DealerInfoDTO dealerInfoDTO = new ObjectMapper().readValue(json, DealerInfoDTO.class);
(2) com.google.gson.Gson
@SerializedName("DealerCode") private String dealerCode;
DealerInfoDTO dealerInfoDTO = gson.fromJson(json, DealerInfoDTO.class);
```