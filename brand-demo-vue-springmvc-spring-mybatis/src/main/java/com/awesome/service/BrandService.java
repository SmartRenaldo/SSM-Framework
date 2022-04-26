package com.awesome.service;

import com.awesome.pojo.Brand;

import java.util.List;

public interface BrandService {


    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加
     * @param brand
     */
    void add(Brand brand);



    /**
     * 根据id查询
     * @return
     */
    Brand selectById(int id);


    /**
     * 修改
     * @param brand
     */
    void update(Brand brand);
}
