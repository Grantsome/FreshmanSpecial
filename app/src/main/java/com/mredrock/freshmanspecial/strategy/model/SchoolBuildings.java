package com.mredrock.freshmanspecial.strategy.model;

import java.util.List;

/**
 * Created by Grantsome on 2017/8/12.
 */

public class SchoolBuildings {
    /**
     * Status : 200
     * Info : success
     * Version : 1.0
     * Data : [{"title":"鸟瞰重邮","content":"站在腾飞广场，做着属于我们的腾飞梦，从这一刻便开启了你的大学新篇章。秉持\u201c修德、博学、求实、创新\u201d校训，书写你的重邮梦。很高兴能与你在重邮相遇。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xyhj/鸟瞰重邮.png"]},{"title":"科创信科楼","content":"挑战杯、创青春、互联网+、数模\u2026\u2026在各类创新创业竞赛中，都可以看到重邮人的身影，他们不断地充实着大学生活，和重邮人在一起，自己在会变得更好。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xyhj/科创信科楼.png"]},{"title":"数字图书馆","content":"在这里，时间变慢，重邮人的脚步变快。从图书馆开门到熄灯，总会看到埋头学习的重邮人，一整天都可以在窗户透过的光芒里，全神贯注。没错，爱学习的重邮人最好看啦！","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xyhj/数字图书馆.png"]},{"title":"二教夕阳","content":"伴着余晖，二教像披着一层朦胧的纱幔，金黄的银杏叶妆点着她的美。漫步在春华秋实广场，邂逅一场邮苑专属浪漫。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xyhj/二教夕阳.png"]},{"title":"高山流水","content":"在重邮信科楼旁的高山流水只是简单一个缩影，却包含了重邮学子的内心广阔。流水溅射过青松，把一切都转换为学子的高山俯仰之情。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xyhj/高山流水.png"]},{"title":"雨红莲","content":"红砖绿荫的映衬下的雨红莲，是重邮人的活动聚集地。丰富的校园活动常常在这里开展，洋着重邮人的活力，展示重邮浓厚的校园文化。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xyhj/雨红莲.png"]},{"title":"仰望八教","content":"八教是传媒艺术学院的学子艺术灵感的发源地，创意在这里闪亮聚集，也是重邮人乘风破浪，扬帆起航的象征。勇敢追梦吧，重邮学子们。","url":["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xyhj/仰望八教.png"]}]
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
         * title : 鸟瞰重邮
         * content : 站在腾飞广场，做着属于我们的腾飞梦，从这一刻便开启了你的大学新篇章。秉持“修德、博学、求实、创新”校训，书写你的重邮梦。很高兴能与你在重邮相遇。
         * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xyhj/鸟瞰重邮.png"]
         */

        private String title;
        private String content;
        private List<String> url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getUrl() {
            return url;
        }

        public void setUrl(List<String> url) {
            this.url = url;
        }
    }
}
