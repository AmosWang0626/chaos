# 获取百度地图省市区数据，解析成json树，提供给前端

1. 获取省市区乡镇Excel
2. Excel数据转JSON
3. 解析JSON数据呈树状结构

## 1、获取省市区乡镇 Excel
- [百度地图 DEV-RES](http://lbsyun.baidu.com/index.php?title=open/dev-res)
- 省市区乡镇表格：逆地理编码服务使用的国家标准行政区划代码（ad-code）映射表
- 如果只要省市区，可去掉乡镇，然后用 WORD/WPS 的删除重复项
- 参照：[行政省市区201910.xlsx](resources/baidu-map/行政省市区201910.xlsx)

## 2、Excel数据转JSON
- [EXCEL/CSV转JSON](http://www.bejson.com/json/col2json/)
- 参照：[map.json](resources/baidu-map/map.json)

## 3、解析JSON数据呈树状结构
- [BaiduMapDataMain.java](java/cn/amos/common/baidu/map/BaiduMapDataMain.java)
- 参照：[map-format.json](resources/baidu-map/map-format.json)


