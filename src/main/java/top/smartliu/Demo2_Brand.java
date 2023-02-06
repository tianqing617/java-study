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

public class Demo2_Brand {
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
        BrandMapper brandMapper = (BrandMapper) sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands.toString());

        //4. 释放资源
        sqlSession.close();
    }
}
