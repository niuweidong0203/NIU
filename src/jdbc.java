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
			System.out.println("���سɹ�");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/studb","root","admin");
			System.out.println("connect�����ɹ�");
			
			//
			Statement sta = (Statement) con.createStatement();
			int n = sta.executeUpdate(" delete from studentinfo where stuid='250'");
			if (n > 0) {
				System.out.println("��ӳɹ�");
			}
			
			
			
			//
			ResultSet rs = (ResultSet) sta.executeQuery("select * from studentinfo");
			while (rs.next()) {
				String xh = rs.getString(1);
				System.out.println("ѧ��" + xh);
				String name = rs.getString(2);
				System.out.println("����" + name);
				int age = rs.getInt(3);
				System.out.println("����" + age);
			}	
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("û���ҵ�com.mysql.jdbc.Drive");
		}catch(SQLException sqle){
			System.out.println("�����쳣");
		}finally {
			System.out.println("�ر�jdbc");
		}
	}
}
