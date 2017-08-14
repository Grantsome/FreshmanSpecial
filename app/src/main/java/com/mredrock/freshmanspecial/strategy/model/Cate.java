package com.mredrock.freshmanspecial.strategy.model;

import java.util.List;

/**
 * Created by Grantsome on 2017/8/13.
 */

public class Cate {

    /**
     * Status : 200
     * Info : success
     * Version : 1.0
     * Data : [{"name":"李记串串","location":"永辉超市旁边","resume":"口味独特，麻辣鲜香","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/李记串串.jpg"]},{"name":"纸包鱼","location":"新校门对面罐罐米线旁边","resume":"味美可口","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/纸包鱼.jpg"]},{"name":"豆花鱼","location":"新校门对面堕落街2街第一家","resume":"豆浆涮鱼好滋味","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/豆花鱼.jpg"]},{"name":"万州巴斗香烤鱼","location":"新校门出门右转，农业银行旁买水果的巷子里面","resume":"口味奇绝、营养丰富","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/万州巴斗香烤鱼.jpg"]},{"name":"蜜雪冰城","location":"老校门对面","resume":"这家的冰激凌很好吃哦，有抹茶，原味和混合三种口味哦~而且不贵，只要两块，物美价廉！","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/蜜雪冰城.jpg"]},{"name":"果然","location":"老校门对面","resume":"甜品美食在这里 ","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/果然.jpg"]},{"name":"城门老火锅","location":"新校门出门，过马路右转下山的路边","resume":"辣而不燥，回味悠长","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/城门老火锅.jpg"]},{"name":"Daydream","location":"校门出门过马路左转直走看见采蝶轩汤锅，就在它旁边（在角落，不是很好找）","resume":"文青们聚集地","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/Daydream.jpg"]},{"name":"华莱士","location":"老校门对面","resume":"物美价廉，种类繁多，美味可口","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/华莱士.jpg"]},{"name":"袁姐牛肉面","location":"老校门对面","resume":"牛肉甘温、安中益气、养脾胃","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/袁姐牛肉面.jpg"]},{"name":"大茶杯","location":"老校门过马路左转一个斜坡旁","resume":"招牌奶茶顺滑可口","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/大茶杯.jpg"]},{"name":"彩蝶轩","location":"老校门出门过马路左转一直走","resume":"汤锅爽辣，自助烤肉有趣味","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/彩蝶轩.jpg"]},{"name":"贵州蘸水米线","location":"老校门出门过马路左转一直走","resume":"价格合理，汤浓鲜香","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/贵州蘸水米线.jpg"]},{"name":"罗非鱼","location":"老校门出门过马路左转一直走，路边","resume":"肉味鲜美，肉质细嫩","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/罗非鱼.jpg"]},{"name":"九村烤脑花","location":"老校门出门过马路左转一直走，路边","resume":"气味醇厚，入口绵软","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/九村烤脑花.jpg"]},{"name":"杀牛王老火锅","location":"老校门出门过马路左转一直走，路边","resume":"好吃正宗","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/杀牛王老火锅.jpg"]},{"name":"毛哥老鸭汤","location":"老校门出门过马路左转一直走，路边","resume":"汤鲜味美","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/毛哥老鸭汤.jpg"]},{"name":"鹅掌老鸭汤","location":"老校门出门过马路左转一直走，路边","resume":"地道重庆味","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/鹅掌老鸭汤.jpg"]},{"name":"田间烂鱼头","location":"老校门出门过马路左转一直走，路边","resume":"鲜而不腥，入口窜香","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/田间烂鱼头.jpg"]},{"name":"第一家火锅串串","location":"老校门出门过马路左转一直走，斜坡旁边","resume":"与麻辣的亲密接触","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/第一家火锅串串.jpg"]},{"name":"柒露营串串","location":"老校门出门过马路左转，斜坡旁边巷子进去","resume":"一家和重邮一起成长的老店","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/柒露营串串.jpg"]},{"name":"无届青年餐馆","location":"老校门出门过马路左转，斜坡旁边巷子进去，柒露营串串旁边","resume":"一个文青以酒会友的地方","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/无届青年餐馆.jpg"]},{"name":"东北饺子馆","location":"老校门出门过马路左转，斜坡旁边巷子进去，柒露营串串1号店旁边","resume":"饺子个大好吃","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/东北饺子馆.jpg"]},{"name":"土巴碗","location":"老校门对面左转斜坡上右边","resume":"菜品好吃，种类丰富","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/土巴碗.jpg"]},{"name":"隆江猪脚饭","location":"老校门对面堕落街里面第一家","resume":"肥而不腻，入口即化","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/隆江猪脚饭.jpg"]},{"name":"净香园","location":"老校门对面堕落街里","resume":"人间舒适新享受","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/净香园.jpg"]},{"name":"黄焖鸡米饭","location":"老校门对面","resume":"好吃又实惠","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/黄焖鸡米饭.jpg"]},{"name":"一品·豆汤饭","location":"老校门对面堕落街里面","resume":"味美鲜香","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/一品·豆汤饭.jpg"]},{"name":"沁源干锅","location":"老校门对面堕落街里面","resume":"浓香四溢，口味多样","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/沁源干锅.jpg"]},{"name":"奈斯汉堡","location":"老校门对面右转堕落2街里面","resume":"食欲大开","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/奈斯汉堡.jpg"]},{"name":"彩蝶轩港式中西餐厅","location":"老校门对面右转堕落2街里面","resume":"错过好味道就是过错","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/彩蝶轩港式中西餐厅.jpg"]},{"name":"韩品屋","location":"新校门对面堕落2街路口","resume":"韩国式美食飘香","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/韩品屋.jpg"]},{"name":"燃面饺子馆","location":"老校门堕落街里面","resume":"满口喷香，馅多汁多","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/燃面饺子馆.jpg"]},{"name":"第一佳大鸡排","location":"老校门对面右转直走路边","resume":"汁多肉嫩，皮脆香酥","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/第一佳大鸡排.jpg"]},{"name":"长生饺子馆","location":"新校门对面堕落街里面","resume":"饺子数量足，现包现煮","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/长生饺子馆.jpg"]},{"name":"肠鲜楼江湖菜","location":"新校门对面广益中学路牌旁边","resume":"武侠餐饮，座座爆满","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/肠鲜楼江湖菜.jpg"]},{"name":"创维江湖火山石烫鱼","location":"新校门出门右转向下山方向一直走，在路边就可看见","resume":"一锅在手，温暖一冬","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/创维江湖火山石烫鱼.jpg"]},{"name":"沁园","location":"老校门出门右转邮政旁边","resume":"甜香扑鼻，松软可口","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/沁园.jpg"]},{"name":"绝味鸭脖","location":"老校门出门右转牛杂王旁边","resume":"鲜香麻辣，越啃越有味","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/绝味鸭脖.jpg"]},{"name":"重庆鸡公煲","location":"老校门对面堕落街","resume":"好吃不辣，量足管饱","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/重庆鸡公煲.jpg"]},{"name":"新疆沙湾大盘鸡","location":"老校门对面堕落街","resume":"独具疆域特色","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/新疆沙湾大盘鸡.jpg"]},{"name":"福宇记黄焖鸡","location":"老校门对面堕落街","resume":"香味浓郁","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/福宇记黄焖鸡.jpg"]},{"name":"撒拉尔牛肉面","location":"老校门对面堕落街","resume":"香味浓郁","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/撒拉尔牛肉面.jpg"]},{"name":"渝香铁板烧","location":"老校门对面堕落街","resume":"味道纯正，香气十足","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/渝香铁板烧.jpg"]},{"name":"刘氏鸡公煲","location":"老校门对面堕落街","resume":"浓香滑嫩，入味彻底","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/刘氏鸡公煲.jpg"]},{"name":"阿里郎","location":"老校门对面堕落街","resume":"独具台式风味","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/阿里郎.jpg"]},{"name":"陈记干锅","location":"老校门对面堕落街","resume":"量大分足，赏心悦目","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/陈记干锅.jpg"]},{"name":"李海粥王","location":"老校门对面堕落街","resume":"营养美味","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/李海粥王.jpg"]},{"name":"旮旯酸辣粉、羊肉粉","location":"老校门对面堕落街","resume":"回味悠长，麻辣鲜香","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/旮旯酸辣粉、羊肉粉.jpg"]},{"name":"三番料理","location":"老校门对面堕落街","resume":"唇齿留香，色味俱佳","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/三番料理.jpg"]},{"name":"好又来","location":"老校门对面堕落街","resume":"好吃不贵","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/好又来.jpg"]},{"name":"咖喱至尊","location":"老校门对面堕落街","resume":"色香味美，物美价廉","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/咖喱至尊.jpg"]},{"name":"边林社","location":"老校门对面堕落街","resume":"美味佳肴","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/边林社.jpg"]},{"name":"小酒馆","location":"老校门对面堕落街","resume":"文青聚集地","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/小酒馆.jpg"]},{"name":"嬢嬢汤圆","location":"老校门对面堕落街","resume":"嬢嬢好，汤圆妈妈味。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/嬢嬢汤圆.jpg"]}]
     */

    private int Status;
    private String Info;
    private String Version;
    private List<DataBean> Data;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * name : 李记串串
         * location : 永辉超市旁边
         * resume : 口味独特，麻辣鲜香
         * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/李记串串.jpg"]
         */

        private String name;
        private String location;
        private String resume;
        private List<String> url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getResume() {
            return resume;
        }

        public void setResume(String resume) {
            this.resume = resume;
        }

        public List<String> getUrl() {
            return url;
        }

        public void setUrl(List<String> url) {
            this.url = url;
        }
    }
}
