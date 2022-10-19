# jpinyin - A opensource java library for converting chinese to pinyin

JPinyin是一个汉字转拼音的Java开源类库，在PinYin4j的功能基础上做了一些改进。<br>

【JPinyin主要特性】<br>

1、准确、完善的字库；<br>

Unicode编码从4E00-9FA5范围及3007（〇）的20903个汉字中，JPinyin能转换除46个异体字（异体字不存在标准拼音）之外的所有汉字；<br>

2、拼音转换速度快；<br>

经测试，转换Unicode编码从4E00-9FA5范围的20902个汉字，JPinyin耗时约100毫秒。<br>

3、多拼音格式输出支持；<br>

JPinyin支持多种拼音输出格式：带音标、不带音标、数字表示音标以及拼音首字母输出格式；<br>

4、常见多音字识别；<br>

JPinyin支持常见多音字的识别，其中包括词组、成语、地名等；<br>

5、简繁体中文转换；<br>

6、支持添加用户自定义字典；<br>

## Maven

``` xml
    <dependency>
        <groupId>io.github.cqwsbsy</groupId>
	    <artifactId>jpinyin</artifactId>
        <version>1.0.1</version>
    </dependency>
```

## Config
    默认不需要配置，若需要拓展自己的字典则需要在spring配置文件中指定拓展字典文件的位置
    例如：
```yaml
    jpingying:
      ext-file-path: drug_mutil_pinyin.dic
```
    表示在springboot项目中的resource目录下添加了自定义字典文件drug_mutil_pinyin.dic
## Usage

``` java
    String str = "你好世界";
    PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_MARK); // nǐ,hǎo,shì,jiè
    PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITH_TONE_NUMBER); // ni3,hao3,shi4,jie4
    PinyinHelper.convertToPinyinString(str, ",", PinyinFormat.WITHOUT_TONE); // ni,hao,shi,jie
    PinyinHelper.getShortPinyin(str); // nhsj
    PinyinHelper.addPinyinDict("user.dict");  // 添加用户自定义字典
```
    或者使用提供的pinyinUtil
```java
    import io.github.jpinyin.PinyinUtil;
    @Autowired
    private PinyinUtil pinyinUtil;
    pinyinUtil.getFullPinyin("党参");//dangsen
```
