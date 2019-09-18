package com.hk.hkblog.controller;

import com.hk.hkblog.entity.User;
import com.hk.hkblog.mybean.ReturnMessage;
import com.hk.hkblog.utils.UploadImgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by 何坤
 * @Classname WangEditorController
 * @Description TODO
 * @Date 2019/9/18 10:54
 */
@RestController
@RequestMapping("/wangEditor")
public class WangEditorController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "/uploadImg")
    public WangEditorResponse uploadImg(@RequestParam(value = "img", required = false) List<MultipartFile> imgs,
                                   HttpServletRequest request,
                                   HttpSession session){
        List<String> imgUrls = new ArrayList<>();
        try {
            imgUrls = new UploadImgUtil().wangEditorUploadImgUtil(imgs, request, session);
        } catch (IOException e) {
            e.printStackTrace();
            return new WangEditorResponse(1, "上传错误");
        }
        WangEditorResponse msg = new WangEditorResponse(0, imgUrls);
        return msg;
    }

    @PostMapping("/getContent")
    public ReturnMessage test2(String data){
        return ReturnMessage.success().add("hc", data);
    }

    @GetMapping("/test")
    public WangEditorResponse msg(){
        List<String> list = new ArrayList<>();
        list.add("http://wodkdjak1.com");
        WangEditorResponse msg = new WangEditorResponse(0, list);
        return msg;
    }

    private class WangEditorResponse{
        private Integer errno;
        private List<String> data;
        public WangEditorResponse(Integer errno,List<String> data){
            this.errno=errno;
            this.data=data;
        }
        public WangEditorResponse(Integer errno,String data){
            this.errno=errno;
            this.data=new ArrayList<>();
            this.data.add(data);
        }

        public Integer getErrno() {
            return errno;
        }

        public void setErrno(Integer errno) {
            this.errno = errno;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "WangEditorResponse{" +
                    "errno='" + errno + '\'' +
                    ", data=" + data +
                    '}';
        }
    }
}
