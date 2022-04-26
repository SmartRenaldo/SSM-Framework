package com.itheima.controller;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Yiqi Li
 */
@Controller
public class SelectAllController {
    private BrandService brandService = new BrandService();

    @RequestMapping(value = "/selectAllController", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public List<Brand> selectAll() {
        return brandService.selectAll();
    }
}
