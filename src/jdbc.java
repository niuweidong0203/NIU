import java.sql.DriverManager;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


public class jdbc {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载成功");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studb","root","admin");
			System.out.println("connect创建成功");
			
			//
			Statement sta = (Statement) con.createStatement();
			int n = sta.executeUpdate(" delete from studentinfo where stuid='250'");
			if (n > 0) {
				System.out.println("添加成功");
			}
			
			
			
			//
			ResultSet rs = (ResultSet) sta.executeQuery("select * from studentinfo");
			while (rs.next()) {
				String xh = rs.getString(1);
				System.out.println("学号" + xh);
				String name = rs.getString(2);
				System.out.println("姓名" + name);
				int age = rs.getInt(3);
				System.out.println("年龄" + age);
			}	
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到com.mysql.jdbc.Drive");
		}catch(SQLException sqle){
			System.out.println("连接异常");
		}finally {
			System.out.println("关闭jdbc");
		}
	}
}
