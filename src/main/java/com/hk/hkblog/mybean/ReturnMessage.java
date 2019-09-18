package com.hk.hkblog.mybean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by 何坤
 * @Classname ReturnMessage
 * @Description TODO
 * @Date 2019/9/16 9:07
 */
public class ReturnMessage {
    /**
     * code：状态码，规定为（200：成功，100：失败）
     */
    private Integer code;

    /**
     * msg：提示信息
     * */
    private String msg;

    /**
     * extend：服务器返回给前台的具体数据
     * */
    private Map<String, Object> extend = new HashMap<>();

    public static ReturnMessage success(){
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode(200);
        returnMessage.setMsg("处理成功");
        return returnMessage;
    }

    public static ReturnMessage failed(){
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode(100);
        returnMessage.setMsg("处理失败");
        return returnMessage;
    }

    public ReturnMessage add(String key, Object value){
        this.getExtend().put(key, value);
        return this;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
