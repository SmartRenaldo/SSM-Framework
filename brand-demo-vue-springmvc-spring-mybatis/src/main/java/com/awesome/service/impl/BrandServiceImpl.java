package com.awesome.service.impl;

import com.awesome.mapper.BrandMapper;
import com.awesome.pojo.Brand;
import com.awesome.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Brand> selectAll(){
        return brandMapper.selectAll();
    }

    /**
     * 添加
     * @param brand
     */
    @Override
    public void add(Brand brand){
        brandMapper.add(brand);
    }



    /**
     * 根据id查询
     * @return
     */
    @Override
    public Brand selectById(int id){
        return brandMapper.selectById(id);
    }


    /**
     * 修改
     * @param brand
     */
    @Override
    public void update(Brand brand){
        brandMapper.update(brand);
    }
}
