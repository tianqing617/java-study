package top.smartliu.mapper;

import top.smartliu.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);
}
