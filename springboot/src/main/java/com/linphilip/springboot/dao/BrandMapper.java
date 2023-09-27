package com.linphilip.springboot.dao;

import com.linphilip.springboot.model.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper<U> {
    List<Brand> sellectAll();

    @Select("select * from tb_brand where id = #{id}")
    Brand selectById(Integer id);

  /*  List<Brand> selectByCondition(@Param("status") int status,
                            @Param("companyName") String companyName,
                            @Param("brandName") String brandName);
    */
    //List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

    void add(Brand brand);

}
