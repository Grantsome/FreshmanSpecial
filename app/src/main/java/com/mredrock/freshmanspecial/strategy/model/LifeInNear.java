package com.mredrock.freshmanspecial.strategy.model;

import java.util.List;

/**
 * Created by Grantsome on 2017/8/13.
 */

public class LifeInNear {

    /**
     * Status : 200
     * Info : success
     * Version : 1.0
     * Data : [{"name":"ZAKKA生活小铺","location":"重庆邮电大学旁，新校门出门，左转直走，老校门出门，右转直走","resume":"文具等用品齐全","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/ZAKKA生活小铺.jpg"]},{"name":"多乐迪KTV","location":"重庆邮电大学旁，新校门出门右转，中国农业银行楼下","resume":"环境较好，是个唱歌的好地方","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/多乐迪KTV.jpg"]},{"name":"联佰大药房","location":"重庆邮电大学旁，新校门出门，过马路，右转直走。","resume":"药品相对齐全","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/联佰大药房.jpg"]},{"name":"新世纪超市","location":"重庆邮电大学旁，新校门出门右转，过一条马路直走","resume":"各类物品较为齐全","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/新世纪超市.jpg"]},{"name":"永辉超市","location":"重庆邮电大学旁，新校门出门过马路，右转直走","resume":"物品齐全，价钱相对便宜","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/永辉超市.jpg"]},{"name":"渝芳百货商场","location":"重庆邮电大学旁，新校门出门，左转直走。老校门出门，右转直走.","resume":"物品较为丰富","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/渝芳百货商场.jpg"]},{"name":"中国工商银行自助服务点","location":"重庆邮电大学旁，新校门出门，左转直走，老校门出门，右转直走。","resume":"距离学校较近，比较方便","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/中国工商银行自助服务点.jpg"]},{"name":"重庆农村商业银行","location":"重庆邮电大学旁，老校门出门，过马路，右转。","resume":"方便取存款，办理业务。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/重庆农村商业银行.jpg"]},{"name":"中国邮政","location":"重庆邮电大学旁，老校门出门，右转。新校门出们，左转。","resume":"可以办理相关业务，取存款等。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/中国邮政.jpg"]}]
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
         * name : ZAKKA生活小铺
         * location : 重庆邮电大学旁，新校门出门，左转直走，老校门出门，右转直走
         * resume : 文具等用品齐全
         * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/ZAKKA生活小铺.jpg"]
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
