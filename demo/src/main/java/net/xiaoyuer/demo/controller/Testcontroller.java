package net.xiaoyuer.demo.controller;

import net.xiaoyuer.demo.domian.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Testcontroller {
    @RequestMapping(value = {"/test"})
    public String test(){
        return "hello";
    }
    @RequestMapping("/test_map")
    @ResponseBody
    public Map<String, String> testMap() {
        Map<String,String> map = new HashMap<>();
        map.put("name", "value");
        return map;

    }

    @RequestMapping("/testjson")
    @ResponseBody
    public Object testJson(){
        return new Users(27, "", new Date());
    }
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Object upload(@RequestParam(name="head_img") MultipartFile file, HttpServletRequest request){
        String fileName =file.getOriginalFilename();
        //      File file4Windows = new File("C:/Users/jokeep/Desktop/Repositoies/8yue.xls"+fileName);
        File file4Mac = new File("/Users/suyafei/Repositoies/springboot_learning/"+fileName);
        try {
            file.transferTo(file4Mac);
//          file.transferTo(file4Windows);
            return "吃皮";
        } catch (Exception e) {
            e.printStackTrace();
            return "dddd";
        }

    }



}
