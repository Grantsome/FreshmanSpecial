package com.mredrock.freshmanspecial.data.model;

import java.util.List;

/**
 * Created by Grantsome on 2017/8/11.
 */

public class FailRatio {

    /**
     * Status : 200
     * Info : success
     * Version : 1.0
     * Data : [{"course":"C语言程序设计","major":"工商管理类","college":"经济管理学院","ratio":"0.3556701030927835"},{"course":"高等数学B(下)","major":"工商管理类","college":"经济管理学院","ratio":"0.20103092783505155"},{"course":"线性代数B","major":"工商管理类","college":"经济管理学院","ratio":"0.15463917525773196"},{"course":"C语言程序设计","major":"工程管理","college":"经济管理学院","ratio":"0.43333333333333335"},{"course":"高等数学B(下)","major":"工程管理","college":"经济管理学院","ratio":"0.3"},{"course":"大学英语","major":"工程管理","college":"经济管理学院","ratio":"0.15"},{"course":"高等数学A(下)","major":"广电与数字媒体类","college":"通信与信息工程学院","ratio":"0.4444444444444444"},{"course":"大学物理A（上）","major":"广电与数字媒体类","college":"通信与信息工程学院","ratio":"0.42857142857142855"},{"course":"线性代数A","major":"广电与数字媒体类","college":"通信与信息工程学院","ratio":"0.25396825396825395"},{"course":"大学英语","major":"广播电视编导","college":"传媒艺术学院","ratio":"0.0975609756097561"},{"course":"计算机艺术设计基础","major":"广播电视编导","college":"传媒艺术学院","ratio":"0.06829268292682927"},{"course":"形势与政策","major":"广播电视编导","college":"传媒艺术学院","ratio":"0.04878048780487805"},{"course":"计算机网络","major":"信息管理与信息系统","college":"经济管理学院","ratio":"0.42857142857142855"},{"course":"高等数学B(下)","major":"信息管理与信息系统","college":"经济管理学院","ratio":"0.22857142857142856"},{"course":"面向对象程序设计","major":"信息管理与信息系统","college":"经济管理学院","ratio":"0.06666666666666667"},{"course":"高等数学A(下)","major":"先进制造大类","college":"先进制造工程学院","ratio":"0.39925373134328357"},{"course":"大学物理B（上）","major":"先进制造大类","college":"先进制造工程学院","ratio":"0.27238805970149255"},{"course":"制图实践与数字化建模","major":"先进制造大类","college":"先进制造工程学院","ratio":"0.20149253731343283"},{"course":"运动解剖学","major":"社会体育指导与管理","college":"体育学院","ratio":"0.09836065573770492"},{"course":"思想道德修养与法律基础","major":"社会体育指导与管理","college":"体育学院","ratio":"0.08196721311475409"},{"course":"体育心理学","major":"社会体育指导与管理","college":"体育学院","ratio":"0.06557377049180328"},{"course":"高等数学B(下)","major":"经济学","college":"经济管理学院","ratio":"0.4444444444444444"},{"course":"C语言程序设计","major":"经济学","college":"经济管理学院","ratio":"0.20833333333333334"},{"course":"会计学","major":"经济学","college":"经济管理学院","ratio":"0.19444444444444445"},{"course":"大学物理A（上）","major":"生物信息学","college":"生物信息学院","ratio":"0.8142857142857143"},{"course":"高等数学A(下)","major":"生物信息学","college":"生物信息学院","ratio":"0.5142857142857142"},{"course":"大学英语","major":"生物信息学","college":"生物信息学院","ratio":"0.35714285714285715"},{"course":"大学物理A（上）","major":"生物医学工程","college":"生物信息学院","ratio":"0.31645569620253167"},{"course":"C语言程序设计","major":"生物医学工程","college":"生物信息学院","ratio":"0.25316455696202533"},{"course":"高等数学A(下)","major":"生物医学工程","college":"生物信息学院","ratio":"0.25316455696202533"},{"course":"高等数学A(下)","major":"电子工程类","college":"光电工程学院","ratio":"0.28859060402684567"},{"course":"C语言程序设计","major":"电子工程类","college":"光电工程学院","ratio":"0.28187919463087246"},{"course":"大学物理A（上）","major":"电子工程类","college":"光电工程学院","ratio":"0.15771812080536912"},{"course":"高等数学A(下)","major":"电子信息工程(中美)","college":"国际学院","ratio":"0.35353535353535354"},{"course":"数据结构与算法B","major":"电子信息工程(中美)","college":"国际学院","ratio":"0.29292929292929293"},{"course":"大学物理A（上）","major":"电子信息工程(中美)","college":"国际学院","ratio":"0.1717171717171717"},{"course":"C语言程序设计","major":"电子商务大类","college":"经济管理学院","ratio":"0.4732142857142857"},{"course":"高等数学B(下)","major":"电子商务大类","college":"经济管理学院","ratio":"0.22321428571428573"},{"course":"大学英语","major":"电子商务大类","college":"经济管理学院","ratio":"0.08928571428571429"},{"course":"高等数学A(下)","major":"计算机与智能科学类","college":"计算机科学与技术学院","ratio":"0.27364185110663986"},{"course":"大学物理B（上）","major":"计算机与智能科学类","college":"计算机科学与技术学院","ratio":"0.1851106639839034"},{"course":"离散数学A","major":"计算机与智能科学类","college":"计算机科学与技术学院","ratio":"0.09456740442655935"},{"course":"高等数学A(下)","major":"软件工程","college":"软件工程学院","ratio":"0.58"},{"course":"大学物理B（上）","major":"软件工程","college":"软件工程学院","ratio":"0.4266666666666667"},{"course":"大学英语","major":"软件工程","college":"软件工程学院","ratio":"0.3233333333333333"},{"course":"线性代数","major":"软件工程（中外）","college":"国际学院","ratio":"0.6105263157894737"},{"course":"高等数学A(下)","major":"软件工程（中外）","college":"国际学院","ratio":"0.6"},{"course":"大学物理B（上）","major":"软件工程（中外）","college":"国际学院","ratio":"0.4105263157894737"},{"course":"高等数学A(下)","major":"自动化与电气工程类","college":"自动化学院","ratio":"0.3143418467583497"},{"course":"大学物理B（上）","major":"自动化与电气工程类","college":"自动化学院","ratio":"0.1787819253438114"},{"course":"C语言程序设计","major":"自动化与电气工程类","college":"自动化学院","ratio":"0.13948919449901767"},{"course":"大学英语","major":"艺术设计类","college":"传媒艺术学院","ratio":"0.08522727272727272"},{"course":"大学体育2","major":"艺术设计类","college":"传媒艺术学院","ratio":"0.056818181818181816"},{"course":"形势与政策","major":"艺术设计类","college":"传媒艺术学院","ratio":"0.005681818181818182"},{"course":"数据结构与算法A","major":"英语(中加)","college":"国际学院","ratio":"0.38461538461538464"},{"course":"高等数学A(下)","major":"英语(中加)","college":"国际学院","ratio":"0.20512820512820512"},{"course":"大学物理A（上）","major":"英语(中加)","college":"国际学院","ratio":"0.20512820512820512"},{"course":"高等数学A(下)","major":"英语+软件","college":"软件工程学院","ratio":"0.6028368794326241"},{"course":"大学物理B（上）","major":"英语+软件","college":"软件工程学院","ratio":"0.5886524822695035"},{"course":"离散数学B","major":"英语+软件","college":"软件工程学院","ratio":"0.19858156028368795"},{"course":"基础英语2","major":"英语类","college":"外国语学院","ratio":"0.14102564102564102"},{"course":"英语基础写作1","major":"英语类","college":"外国语学院","ratio":"0.07692307692307693"},{"course":"英语时文阅读","major":"英语类","college":"外国语学院","ratio":"0.07692307692307693"},{"course":"高等数学A(下)","major":"集成电路工程类","college":"国际半导体学院","ratio":"0.4797979797979798"},{"course":"电路分析基础B","major":"集成电路工程类","college":"国际半导体学院","ratio":"0.31313131313131315"},{"course":"大学英语","major":"集成电路工程类","college":"国际半导体学院","ratio":"0.29797979797979796"},{"course":"高等数学A(下)","major":"通信与信息类","college":"通信与信息工程学院","ratio":"0.2413793103448276"},{"course":"大学物理A（上）","major":"通信与信息类","college":"通信与信息工程学院","ratio":"0.21149425287356322"},{"course":"数字与逻辑电路基础","major":"通信与信息类","college":"通信与信息工程学院","ratio":"0.1839080459770115"},{"course":"大学英语","major":"法学类","college":"网络空间安全与信息法学院","ratio":"0.11224489795918367"},{"course":"民法总论","major":"法学类","college":"网络空间安全与信息法学院","ratio":"0.02040816326530612"},{"course":"法律专业计算机概论","major":"法学类","college":"网络空间安全与信息法学院","ratio":"0.01020408163265306"},{"course":"高等数学A(下)","major":"日语+软件","college":"软件工程学院","ratio":"0.6388888888888888"},{"course":"大学物理B（上）","major":"日语+软件","college":"软件工程学院","ratio":"0.6111111111111112"},{"course":"日语精读2","major":"日语+软件","college":"软件工程学院","ratio":"0.4722222222222222"},{"course":"大学英语","major":"数字媒体艺术与动画大类","college":"传媒艺术学院","ratio":"0.2754491017964072"},{"course":"马克思主义基本原理","major":"数字媒体艺术与动画大类","college":"传媒艺术学院","ratio":"0.17964071856287425"},{"course":"计算机图形制作","major":"数字媒体艺术与动画大类","college":"传媒艺术学院","ratio":"0.07784431137724551"},{"course":"高等代数（下）","major":"数理科学与信息技术类","college":"理学院","ratio":"0.3717948717948718"},{"course":"数学分析A2","major":"数理科学与信息技术类","college":"理学院","ratio":"0.358974358974359"},{"course":"普通物理学B1","major":"数理科学与信息技术类","college":"理学院","ratio":"0.2692307692307692"}]
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
        return "FailRatio{" +
                "Status=" + Status +
                ", Info='" + Info + '\'' +
                ", Version='" + Version + '\'' +
                ", Data=" + Data +
                '}';
    }

    public static class DataBean {
        /**
         * course : C语言程序设计
         * major : 工商管理类
         * college : 经济管理学院
         * ratio : 0.3556701030927835
         */

        private String course;
        private String major;
        private String college;
        private String ratio;

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getRatio() {
            return ratio;
        }

        public void setRatio(String ratio) {
            this.ratio = ratio;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "course='" + course + '\'' +
                    ", major='" + major + '\'' +
                    ", college='" + college + '\'' +
                    ", ratio='" + ratio + '\'' +
                    '}';
        }
    }
}
