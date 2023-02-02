import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo1Jdbc {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接对象
        String url = "jdbc:mysql://localhost:3306/school?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义SQL
        String sql = "update students set age = 22 where id = 1";

        // 4. 获取执行SQL的对象
        Statement stmt = conn.createStatement();

        // 5. 执行SQL
        int count = stmt.executeUpdate(sql);

        // 6. 处理结果
        System.out.println(count);

        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}
