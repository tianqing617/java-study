package top.smartliu;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.smartliu.mapper.BrandMapper;
import top.smartliu.pojo.Brand;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo2_Brand4Update {
    // 多条件查询
    public static void main(String[] args) throws IOException {
        // 1. 加载MyBatis核心配置文件，获取SqlSessionFactory实例
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        // 3.1 方式一：
        /*List<User> users = sqlSession.selectList("test.selectAll");*/

        // 3.2 方式二：解决硬编码问题
        int id = 2;
        int status = 101;
        String companyName = "华为123";
        String brandName = "华为";

        //封装对象
        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        // 3.2.3 查询数据
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int count = brandMapper.update(brand);

        System.out.println("改变行数：" + count);

        sqlSession.commit();

        //4. 释放资源
        sqlSession.close();
    }
}
