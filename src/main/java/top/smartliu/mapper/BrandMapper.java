package top.smartliu.mapper;

import org.apache.ibatis.annotations.Param;
import top.smartliu.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    List<Brand> selectByCondition2(Brand brand);

    void add(Brand brand);
}
