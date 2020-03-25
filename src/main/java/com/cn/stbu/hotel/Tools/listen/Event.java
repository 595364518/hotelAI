package com.cn.stbu.hotel.Tools.listen;

import com.cn.stbu.hotel.Tools.thread.FrThead;

/**
 * Description: 识别结果消息事件
 * Datetime:    2020/3/20 0020   12:00
 * Author:  IDEA
 */
public class Event {
    FrThead frThead;

    public Event(FrThead frThead){
        this.frThead = frThead;
    }
    public FrThead getResource(){
        return frThead;
    }

}
