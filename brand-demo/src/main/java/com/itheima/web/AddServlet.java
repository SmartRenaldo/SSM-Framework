package com.itheima.web;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据，request.getParameter不能接收Json数据，需要获取请求体数据
        //获取请求体数据
        request.setCharacterEncoding("utf8");
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        //将JSON字符串转换为Java对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //调用service添加
        brandService.add(brand);

        //响应成功标识(1)
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
