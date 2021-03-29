package Dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
import Model.user;
import Util.JDBCUtils;
 
public class UserDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	//添加用户操作
	public boolean insert(user u){
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into user (username, password, identity) "
					+ "values('"
					+ u.getUsername()
					+ "','"
					+ u.getPassword()
					+ "','"
					+ u.getIdentity()
					+ "')";
			System.out.println("添加SQL语句为：" + sql);
			int num = stmt.executeUpdate(sql);
			if (num > 0){
				return true;
			}
			return false;
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}

	//根据username查询
	public user find(String username){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from user where username = '" + username +"'";
			System.out.println("单个查询SQL语句：" + sql);			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				user u = new user();
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setIdentity(rs.getString("identity"));
				return u;
			}
			return null;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	//删除用户
	public boolean delete(String username){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from user where username = '" + username + "'";
			System.out.println("删除的SQL语句是：" + sql);
			int num = stmt.executeUpdate(sql);
			if (num > 0){
				return true;
			}
			return false;
		} catch (Exception ee){
			ee.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	
	//修改用户
	public boolean update(user u){
	try{
		conn = JDBCUtils.getConnection();
		stmt = conn.createStatement();
		String sql = "update user set password='" + u.getPassword() 
					+ "',identity='" + u.getIdentity()
					+ "' where username='" + u.getUsername() + "'";
		System.out.println("修改的SQL语句是：" + sql);
		int num = stmt.executeUpdate(sql);
		if (num > 0){
			return true;
		}
		return false;
		} catch (Exception ee){
			ee.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
}
