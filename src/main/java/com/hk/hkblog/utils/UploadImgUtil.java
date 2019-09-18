package com.hk.hkblog.utils;

import com.hk.hkblog.myexception.WangEditorUploadException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by 何坤
 * @Classname UploadImgUtil
 * @Description TODO
 * @Date 2019/9/18 10:59
 */
public class UploadImgUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<String> wangEditorUploadImgUtil(List<MultipartFile> imgs,
                                          HttpServletRequest request,
                                          HttpSession session) throws IOException {
        String myPath = session.getServletContext().getRealPath("/WangEditorImages/");
        File path = new File(myPath);
        if (!path.exists()){
            path.mkdirs();
        }

        List<String> imgUrls =  new ArrayList<>();
        for (MultipartFile img : imgs){
            String imagePath = "";
            if (!img.isEmpty()){
                if (!StringUtils.isEmpty(img.getOriginalFilename())){
                    String suffix = img.getOriginalFilename().substring(img.getOriginalFilename().lastIndexOf("."));
                    // 获取文件的后缀
                    if (StringUtils.isEmpty(suffix)){
                        throw new WangEditorUploadException("上传的文件没有后缀，无法识别文件类型！");
                    }
                    // 生成新的文件名
                    String fileName = System.currentTimeMillis()+suffix;

                    File file = new File(path, fileName);
                    img.transferTo(file);
                    imagePath = request.getContextPath()+"/WangEditorImages/"+fileName;

                    String uploadImagePath = System.getProperty("user.dir") + "/src/main/resources/static/UploadImages/"+fileName;
                    File f = new File(uploadImagePath);
                    FileUtils.copyFile(file, f);
                }else {
                    throw new WangEditorUploadException("上传的图片名称为空，请检查！");
                }
            }
            imgUrls.add(imagePath);
        }
        return imgUrls;
    }
}
