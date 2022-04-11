package com.x.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.x.domain.User;
import com.x.domain.VO;
import com.x.utils.FileTransferUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Gavin
 * save1 ~ save5:页面跳转
 * save6 ~ save10: 回写数据
 * save11 ~ save21: 获得请求参数
 * save21 ~ save23: 文件上传
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick1", method = RequestMethod.GET, params = "username")
    // 若要执行save方法，访问地址为 http://localhost:8080/user/quick?username=xxx
    public String save1() {
        System.out.println("Controller save running...");

        return "success";
    }

    @RequestMapping("/quick2")
    public ModelAndView save2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "阿三");
        modelAndView.setViewName("username");

        return modelAndView;
    }

    @RequestMapping("/quick3")
    public String save3(Model model) {
        model.addAttribute("username", "老四");

        return "username";
    }

    @RequestMapping("/quick4")
    public ModelAndView save4(ModelAndView modelAndView) {
        modelAndView.addObject("username", "Kate");
        modelAndView.setViewName("username");

        return modelAndView;
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "Catherin");

        return "username";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello quick6!");
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() {
        return "Hello quick7!";
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() {
        return "{\"name\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User("lisi", 22);

        //使用json转换工具将对象转换成json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping("/quick10")
    @ResponseBody
    // 让SpringMVC自动将User转换成JSON格式字符串
    // 需要在spring-mvc.xml下添加配置
    // <mvc:annotation-driven/>
    public User save10() {
        return new User("wangwu", 10);
    }

    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    /**
     * 若用Ajax传数据，需要在User前添加@RequestBody
     * @param user
     */
    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);
    }

    @RequestMapping("/quick13")
    @ResponseBody
    public void save13(String[] strs) {
        System.out.println(Arrays.toString(strs));
    }

    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> users) {
        System.out.println(users);
    }

    /**
     * 注解@RequestParam还有如下参数可以使用：
     *  value：与请求参数名称(username失效)
     *  required：此在指定的请求参数是否必须包括，默认是true，提交时如果没有此参数则报错
     *  defaultValue：当没有指定请求参数时，则使用指定的默认值赋值
     *
     * @param username
     */
    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "King") String username) {
        System.out.println(username);
    }

    // restful风格
    // http://localhost:8080/user/quick17/zhangsan
    @RequestMapping("/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable("username") String username) {
        System.out.println(username);
    }

    // http://localhost:8080/user/quick18?date=2020-11-20
    @RequestMapping("/quick18")
    @ResponseBody
    public void save18(Date date) {
        System.out.println(date);
    }

    /**
     * SpringMVC支持使用原始ServletAPI对象作为控制器方法的参数进行注入，常用的对象如下：
     *  HttpServletRequest
     *  HttpServletResponse
     *  HttpSession
     */
    @RequestMapping("/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String userAgent) {
        System.out.println(userAgent);
    }

    @RequestMapping("/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) {
        System.out.println(jsessionId);
    }

    @RequestMapping("/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile, MultipartFile uploadFile2) throws IOException {
        System.out.println(username);
        // 获得文件上传名称
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(
                new File("D:\\IdeaProjects\\spring_mvc\\src\\main\\java\\com\\x\\controller\\fileDownloadTestPackage\\"
                        + originalFilename));

        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(
                new File("D:\\IdeaProjects\\spring_mvc\\src\\main\\java\\com\\x\\controller\\fileDownloadTestPackage\\"
                        + originalFilename2));
    }

    @RequestMapping("/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFiles) throws IOException {
        System.out.println(username);
        // 获得文件上传名称
        for (MultipartFile uploadFile : uploadFiles) {
            System.out.println(uploadFile.getOriginalFilename());
            System.out.println(uploadFile.getName());
            System.out.println(uploadFile.getResource());
            uploadFile.transferTo(
                    new File("D:\\IdeaProjects\\spring_mvc\\src\\main\\java\\com\\x\\controller\\fileDownloadTestPackage\\"
                            + uploadFile.getOriginalFilename()));
        }
    }

    /**
     * get and do not save file
     *
     * @param username
     * @param uploadFiles
     * @throws IOException
     */
    @RequestMapping("/quick24")
    @ResponseBody
    public void save24(String username, MultipartFile[] uploadFiles) throws IOException {
        System.out.println(username);
        // 获得文件上传名称
        for (MultipartFile uploadFile : uploadFiles) {
            File file = FileTransferUtils.transferToFile(uploadFile);
            BufferedReader br = new BufferedReader(new FileReader(file));

            System.out.println(uploadFile.getOriginalFilename());

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println();
        }
    }
}
