package com.mredrock.freshmanspecial.strategy.model;

import java.util.List;

/**
 * Created by Grantsome on 2017/8/13.
 */

public class Canteen {


    /**
     * Status : 200
     * Info : success
     * Version : 1.0
     * Data : [{"name":"中心食堂","resume":"地理位置的优越不仅来源于它历史的悠久，更是因为中心特色小面的支持，这里一砖一瓦都沉淀着岁月的气息。又大又好吃又便宜的素菜包子和肉花卷、馒头加豆浆，是早餐的不二选择。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/中心食堂.jpg"]},{"name":"红高粱食堂","resume":"由于地处长长的阶梯之上，它有\u201c重邮最高食堂\u201d之称。重邮流传着这样一句话：敢于从老校门到红高粱吃饭的人都是勇士。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/红高粱.jpg"]},{"name":"兴业苑食堂","resume":"位处红高粱之下，\u201c快递一条街\u201d之上，毗邻兴业苑宿舍，是兴业苑众多的男神女神便捷的就餐地点。这可是让明理苑、知行苑等的同学嫉妒兴业苑的地理位置得不行呢！","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/兴业苑食堂 (1).jpg","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/兴业苑食堂 (2).jpg","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/兴业苑食堂 (3).jpg"]},{"name":"千喜鹤食堂","resume":"千喜鹤\u2014\u2014上过微博热搜的网红食堂，华丽的八角灯和亮丽的小彩灯在五颜六色的高脚凳的映衬下特别有小酒吧的文艺清新范，传说中的\u201c别人家的食堂\u201d现在就是你家的食堂啦！","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/千喜鹤 (1).jpg","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/千喜鹤 (2).jpg"]},{"name":"大西北食堂","resume":"如果有宗教信仰的小伙伴或者想尝尝大西北特色的同学一定不要错过这里，西北的美食\u2014\u2014兰州拉面量多价廉。去大西北，一定要点上一碗牛肉拉面尝尝这里的特色。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/大西北食堂.jpg"]},{"name":"延生食堂","resume":"美食窗口众多，各有特色，每年都会不断推陈出新，更重要的是性价比非常高，因此吸引了莘莘学子，客流量很大。酷暑天气，喝上一杯延生西瓜汁，真是降火消暑又愉悦人心。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/延生食堂.jpg"]}]
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
         * name : 中心食堂
         * resume : 地理位置的优越不仅来源于它历史的悠久，更是因为中心特色小面的支持，这里一砖一瓦都沉淀着岁月的气息。又大又好吃又便宜的素菜包子和肉花卷、馒头加豆浆，是早餐的不二选择。
         * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/中心食堂.jpg"]
         */

        private String name;
        private String resume;
        private List<String> url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
