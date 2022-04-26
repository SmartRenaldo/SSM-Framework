package com.itheima.controller;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PagenationVo;
import com.itheima.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Yiqi Li
 */
@Controller
public class AddController {
    private BrandService brandService = new BrandService();

    //Brand前须注明@RequestBody，否则无法向Brand传入数据，这是因为前段用了Ajax
    @RequestMapping(value = "/addController")
    @ResponseBody
    public String add(@RequestBody Brand brand) {
        brandService.add(brand);

        return "success";
    }
}
