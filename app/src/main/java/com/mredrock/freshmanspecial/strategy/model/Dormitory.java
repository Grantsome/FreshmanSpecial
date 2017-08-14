package com.mredrock.freshmanspecial.strategy.model;

import java.util.List;

/**
 * Created by Grantsome on 2017/8/13.
 */

public class Dormitory {

    /**
     * Status : 200
     * Info : success
     * Version : 1.0
     * Data : [{"name":"明理苑（24\u201431,39）","resume":"位于千喜鹤食堂正街上，可以俯瞰全校以及南山的部分美丽景色，这里也是重邮夏天最凉爽的地方。可以坐私家车直达寝室，周围有两个超市和上铺，并且校车穿过，每个寝室都为6人间，并设有独立卫生间，每一栋楼里面配置有洗衣机可供大家使用，应有尽有，可以尽情满足同学们的平日生活需求。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (1).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (2).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (3).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (4).JPG"]},{"name":"宁静苑（8\u201412，32--35）","resume":"坐落在美丽的情人坡旁，是妹子们散心聊天约会的好去处；篮球、网球、羽毛球这些周围球场为大家的锻炼提供了方便，与新校区紧连，周边分布有\u201c千喜鹤\u201d、\u201c延生\u201d等食堂。宿舍基本为6人间基本情况与22-24相同且有独立的阳台、卫浴，床铺是上下铺与上床下桌的混搭，人流量很少，环境比较清静。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/宁静苑 (1).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/宁静苑 (2).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/宁静苑 (3).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/宁静苑 (4).JPG"]},{"name":"兴业苑（17--23）","resume":"屹立于悠悠重邮高处，周边风景秀丽，分布在太极运动场周围，周边有学校的兴业苑食堂及众多的超市、商铺，校车从这里穿过，内部均设有独立卫生间，并在一些楼层设有洗衣机供大家使用，根据每栋宿舍不同，楼层不同分为4人间、6人间两种。4人间都是上床下铺，而6人间则是上下铺与上床下桌的混搭。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/兴业苑 (1).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/兴业苑 (2).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/兴业苑 (3).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/兴业苑 (4).JPG"]},{"name":"知行苑（1\u20146，15,16）","resume":"位于中心食堂附近的1,5,6栋是学校现存最老的寝室，住宿条件比较差，整体情况是每层楼设有公用的卫生间、洗澡间，这也就意味着每个寝室都没有独立卫生间，没有阳台。处于校园中心，上课、生活都极其便利。但位于情人坡附近的15,16栋，是学校标准的4人间，上床下桌，配有阳台，独立卫生间。楼栋周边环境一流，食堂与超市一应俱全，为学习生活提供不少的便利。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/知行苑 (1).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/知行苑 (2).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/知行苑 (3).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/知行苑 (4).JPG"]}]
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
         * name : 明理苑（24—31,39）
         * resume : 位于千喜鹤食堂正街上，可以俯瞰全校以及南山的部分美丽景色，这里也是重邮夏天最凉爽的地方。可以坐私家车直达寝室，周围有两个超市和上铺，并且校车穿过，每个寝室都为6人间，并设有独立卫生间，每一栋楼里面配置有洗衣机可供大家使用，应有尽有，可以尽情满足同学们的平日生活需求。
         * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (1).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (2).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (3).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (4).JPG"]
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
