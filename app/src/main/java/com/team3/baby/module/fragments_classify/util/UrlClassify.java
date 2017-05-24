package com.team3.baby.module.fragments_classify.util;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/22  19:44
 */

public class UrlClassify {
    //种类
/*    public static List<String> getCLASSIFY() {
        List<String> list = new ArrayList<>();
        list.add("宝宝奶粉");
        list.add("辅食营养");
        list.add("宝宝尿裤");
        list.add("洗护用品");
        list.add("喂养用品");
        list.add("宝宝玩乐");
        list.add("妈妈专区");
        list.add("童装童鞋");
        list.add("图书天地");
        list.add("童车童床");
        return list;
    }*/
//右侧点击，跳转的接口参数
    public static final String VALUE_PCCI = "313006";
    //抓的接口
    public static final String ADD_CLASSIFY = "http://ds.suning.cn/ds/terminal/categoryInfo/99999999-.json";
    //宝宝奶粉
    public static final String BBNF = "http://search.suning.com/emall/mobile/clientSearch.jsonp?set=5&ps=10&channelId=MOBILE&keyword=&st=0&ci=313006&cf=&sc=0&cityId=9173&cp=0&iv=-1&ct=-1&sp=&prune=1&operate=0&istongma=1&v=1.2";
    public static final String ADD_BASE_RIGHT_01 = "http://search.suning.com/emall/mobile/clientSearch.jsonp?set=5&ps=10&channelId=MOBILE&keyword=&st=0&ci=";
    public static final String ADD_BASE_RIGHT_02 = "&cf=&sc=0&cityId=9173&cp=0&iv=-1&ct=-1&sp=&prune=1&operate=0&istongma=1&v=1.2";

}
