package com.stronger.controller;

import com.stronger.POJO.PersonInfo;
import com.stronger.POJO.Persons;
import com.stronger.POJO.PureDemo;
import com.stronger.util.Base64Util;
import com.stronger.util.ContextHolder;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  8:14 2018/7/16
 * @ModefiedBy:
 */
@Controller
public class AspectController {


    @RequestMapping(value = "/resonseBody")
    @ResponseBody
    public Map<String, Object> resonseBody() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "fu song");
        map.put("age", 20);
        map.put("descs", "spledend");
        return map;
    }

    @RequestMapping(value = "/persons")
    public void getPerson(PureDemo pureDemo) {
        System.out.println(" 封装到Persons里，  ");
        System.out.println("  " + pureDemo);
    }

    @RequestMapping("/respson")
    @ResponseBody
    public PersonInfo getPersonInfo() {
        PersonInfo info = new PersonInfo(14, "fusong", "nan");
        return info;
    }

    @RequestMapping("/spring")
    public void spring(@RequestParam(defaultValue = "spring", required = false) String season, @RequestParam(defaultValue = "wonderful", required = false) String descs) {
        System.out.println(" season  " + season + "  descs " + descs);
        System.out.println(" spring ok ");
    }

    @RequestMapping("/parseData")
    public void parseData(QuesBody quesBody) {
        System.out.println("   has receive questionBody    ");
        System.out.println(quesBody.getText());
        System.out.println("   has receive questionBody   ");
        System.out.println(quesBody.getAnsw());
    }

    @RequestMapping("/getJpg")
    public void getJpg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = "富文本编辑器,upload_2/20180723081950131.jpg,着呢是个不错的选";
        String jpgPath = "";
        if (content.indexOf(".jpg") > 0) {
            int loa = content.indexOf(".jpg");
            jpgPath = content.substring(loa - 17, loa + 4);
        }
        String url = request.getSession().getServletContext().getRealPath("") + "/upload_2/" + jpgPath;
        String str = Base64Util.GetImageStrFromPath(url);
        System.out.println(" str  " + str);
        JSONObject object = new JSONObject();
        object.accumulate("url", str);

        IOUtils.write(str, new FileOutputStream("D:\\aa.txt"));
        response.getWriter().write(object.toString());
    }

    @RequestMapping("/getParamMap")
    public void getParamMap(HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("  response from method   " + response);
        map.put("name", "fusong");
        map.put("age", 20);

        System.out.println("enter  ");
        map.put("sex", "nan");
        JSONObject object = new JSONObject();
        object.accumulate("bean", map);
        System.out.println(" response from ContextHolder  " + ContextHolder.getCurrentResponse());
        HttpServletResponse servletResponse = ContextHolder.getCurrentResponse();
        // ContextHolder.getCurrentResponse().getWriter().write(object.toString());
        servletResponse.getWriter().write(object.toString());
    }


    @RequestMapping("/uploadPic")
    public void uploadPic(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取图片原始文件名
            String originalFilename = file.getOriginalFilename();
            System.out.println(originalFilename);
            // 文件名使用当前时间
            String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            // 获取上传图片的扩展名(jpg/png/...)
            String extension = FilenameUtils.getExtension(originalFilename);
            String alias = name + "." + extension;
            // 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
            String path = "/upload_2/" + name + "." + extension;
            // 图片上传的绝对路径
            String url = request.getSession().getServletContext().getRealPath("") + path;
            File dir = new File(url);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            JSONObject object = new JSONObject();
            object.accumulate("url", alias);
            System.out.println("  alias  " + alias);
            // 上传图片
            file.transferTo(new File(url));
            response.getWriter().write(object.toString());
        } catch (Exception e) {
            throw new RuntimeException("服务器繁忙，上传图片失败");
        }

    }

    @RequestMapping("upload")
    public void upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取图片原始文件名
            String originalFilename = file.getOriginalFilename();
            System.out.println(originalFilename);
            // 文件名使用当前时间
            String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            // 获取上传图片的扩展名(jpg/png/...)
            String extension = FilenameUtils.getExtension(originalFilename);
            // 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
            String path = "/upload/" + name + "." + extension;
            // 图片上传的绝对路径
            String url = request.getSession().getServletContext().getRealPath("") + path;
            File dir = new File(url);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 上传图片
            file.transferTo(new File(url));
            // 将相对路径写回（json格式）
            JSONObject jsonObject = new JSONObject();
            System.out.println("  request.getCharacterEncoding   " + request.getCharacterEncoding() + "  request.getContentType  " + request.getContentType());
            System.out.println("   response.getContentType " + response.getContentType() + "  response.getCharacterEncoding  " + response.getCharacterEncoding());

            // 将图片上传到本地
//            jsonObject.put("path", path);
            jsonObject.put("userName", request.getParameter("username"));
            jsonObject.put("password", request.getParameter("password"));
            // 设置响应数据的类型json
            response.setContentType("application/json; charset=utf-8");
            // 写回
            response.getWriter().write(jsonObject.toString());

        } catch (Exception e) {
            throw new RuntimeException("服务器繁忙，上传图片失败");
        }
    }

}
