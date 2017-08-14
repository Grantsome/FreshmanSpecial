package com.mredrock.freshmanspecial.strategy.model;

import java.util.List;

/**
 * Created by Grantsome on 2017/8/13.
 */

public class BeautyInNear {


    /**
     * Status : 200
     * Info : success
     * Version : 1.0
     * Data : [{"name":"大金鹰","location":"重庆市南岸区南山路25路大金鹰园内","resume":"数十里景物尽收眼底","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/大金鹰.jpg"]},{"name":"黄葛古道","location":"G65包茂高速附近","resume":"重庆的\u201c丝绸之道\u201d","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/黄葛古道.jpg"]},{"name":"重庆抗战遗址博物馆","location":"重庆市南岸区南山植物园路1号","resume":"历史、自然气息浓厚","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/重庆抗战遗址博物馆.jpg"]},{"name":"老君洞","location":"重庆市南岸区龙黄公路","resume":"重庆主城区最大最主要的宫观","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/老君洞.jpg"]},{"name":"南滨公园","location":"重庆市南岸区南滨路80号","resume":"开放带状公园","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/南滨公园.jpg"]},{"name":"南之山书店","location":"南山公园北路128号","resume":"一间看得见风景的书店","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/南之山书店.jpg"]},{"name":"涂山湖","location":"重庆市南岸区崇文路16号","resume":"四季景色尽揽眼底","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/涂山湖.jpg"]},{"name":"一棵树观景台","location":"重庆市南岸区风景区南山一棵树内","resume":"感受山水之城的起伏面貌。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/一棵树观景台.jpg"]}]
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
         * name : 大金鹰
         * location : 重庆市南岸区南山路25路大金鹰园内
         * resume : 数十里景物尽收眼底
         * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/大金鹰.jpg"]
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
