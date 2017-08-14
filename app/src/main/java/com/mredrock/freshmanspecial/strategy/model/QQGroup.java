package com.mredrock.freshmanspecial.strategy.model;

import java.util.List;

/**
 * Created by Grantsome on 2017/8/12.
 */

public class QQGroup {

    /**
     * Status : 200
     * Info : success
     * Version : 1.0
     * Data : [{"GroupName":"贵州","Number":"601631814","category":"homeland"},{"GroupName":"浙江","Number":"247010642","category":"homeland"},{"GroupName":"江苏","Number":"123736116","category":"homeland"},{"GroupName":"山西","Number":"119738941","category":"homeland"},{"GroupName":"福建","Number":"623621146","category":"homeland"},{"GroupName":"安徽","Number":"558183547","category":"homeland"},{"GroupName":"陕西","Number":"193388613","category":"homeland"},{"GroupName":"广东","Number":"113179139","category":"homeland"},{"GroupName":"辽宁","Number":"134489031","category":"homeland"},{"GroupName":"海南","Number":"9334029","category":"homeland"},{"GroupName":"贵州","Number":"601631814","category":"homeland"},{"GroupName":"吉林","Number":"118060379","category":"homeland"},{"GroupName":"浙江","Number":"247010642","category":"homeland"},{"GroupName":"宁夏","Number":"319432002","category":"homeland"},{"GroupName":"湖南","Number":"204491110","category":"homeland"},{"GroupName":"天津","Number":"8690505","category":"homeland"},{"GroupName":"湖北","Number":"33861584","category":"homeland"},{"GroupName":"山东","Number":"384043802","category":"homeland"},{"GroupName":"河北","Number":"644348638","category":"homeland"},{"GroupName":"四川","Number":"142604890","category":"homeland"},{"GroupName":"江西","Number":"476426072","category":"homeland"},{"GroupName":"黑龙江","Number":"316348915","category":"homeland"},{"GroupName":"河南","Number":"603517442","category":"homeland"},{"GroupName":"云南宣威","Number":"211910023","category":"homeland"},{"GroupName":"云南玉溪","Number":"256581906","category":"homeland"},{"GroupName":"云南曲靖","Number":"117499346","category":"homeland"},{"GroupName":"广西贵港","Number":"5819894","category":"homeland"},{"GroupName":"广东韶山","Number":"66484867","category":"homeland"},{"GroupName":"广东惠州","Number":"213337022","category":"homeland"},{"GroupName":"四川成都","Number":"298299346","category":"homeland"},{"GroupName":"四川自贡","Number":"444020511","category":"homeland"},{"GroupName":"四川绵阳","Number":"191653502","category":"homeland"},{"GroupName":"四川眉山","Number":"273968035","category":"homeland"},{"GroupName":"武隆","Number":"123122421","category":"homeland"},{"GroupName":"涪陵","Number":"199748999","category":"homeland"},{"GroupName":"梁平","Number":"85423833","category":"homeland"},{"GroupName":"璧山","Number":"112571803","category":"homeland"},{"GroupName":"綦江","Number":"109665788","category":"homeland"},{"GroupName":"巫溪","Number":"143884210","category":"homeland"},{"GroupName":"云阳","Number":"118971621","category":"homeland"},{"GroupName":"长寿","Number":"594337683","category":"homeland"},{"GroupName":"开州","Number":"5657168","category":"homeland"},{"GroupName":"南川","Number":"423494314","category":"homeland"},{"GroupName":"彭水","Number":"283978475","category":"homeland"},{"GroupName":"石柱","Number":"289615375","category":"homeland"},{"GroupName":"丰都","Number":"343292119","category":"homeland"},{"GroupName":"永川","Number":"467050041","category":"homeland"},{"GroupName":"大足","Number":"462534986","category":"homeland"},{"GroupName":"铜梁","Number":"198472776","category":"homeland"},{"GroupName":"忠县","Number":"115637967","category":"homeland"},{"GroupName":"奉节","Number":"50078959","category":"homeland"},{"GroupName":"黔江","Number":"102897346","category":"homeland"},{"GroupName":"通信与信息工程学院","Number":"498167991","category":"college"},{"GroupName":"计算机与科学技术学院","Number":"638612170","category":"college"},{"GroupName":"自动化学院","Number":"574872113","category":"college"},{"GroupName":"光电学院国际半导体学院","Number":"636449199","category":"college"},{"GroupName":"外国语学院","Number":"333094013","category":"college"},{"GroupName":"传媒艺术学院","Number":"527468298","category":"college"},{"GroupName":"编导","Number":"621039140","category":"college"},{"GroupName":"2017级重邮编导交流群","Number":"277821038","category":"college"},{"GroupName":"生物学院","Number":"637402699","category":"college"},{"GroupName":"生物2017级新生群","Number":"654028289","category":"college"},{"GroupName":"信管","Number":"362192309","category":"college"},{"GroupName":"经济管理学院","Number":"545772871","category":"college"},{"GroupName":"工程管理","Number":"552540368","category":"college"},{"GroupName":"软件工程学院","Number":"482656306","category":"college"},{"GroupName":"安法学院院学生会认证官方新生群","Number":"162240404","category":"college"},{"GroupName":"安法学院新生群","Number":"615223073","category":"college"},{"GroupName":"理学院","Number":"575159267","category":"college"},{"GroupName":"体育学院","Number":"649510732","category":"college"},{"GroupName":"国际学院","Number":"17443276","category":"college"},{"GroupName":"先进制造学院","Number":"563565394","category":"college"}]
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

    @Override
    public String toString() {
        return "QQGroup{" +
                "Status=" + Status +
                ", Info='" + Info + '\'' +
                ", Version='" + Version + '\'' +
                ", Data=" + Data +
                '}';
    }

    public static class DataBean {
        /**
         * GroupName : 贵州
         * Number : 601631814
         * category : homeland
         */

        private String GroupName;
        private String Number;
        private String category;

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String GroupName) {
            this.GroupName = GroupName;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String Number) {
            this.Number = Number;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "GroupName='" + GroupName + '\'' +
                    ", Number='" + Number + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }
}
