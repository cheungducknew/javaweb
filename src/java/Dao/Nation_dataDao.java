package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.nation_data;
import Util.JDBCUtils;

public class Nation_dataDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
        //添加
	public boolean insert(nation_data nd){
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into nation_data (nation, male_Population, male_Proportion, female_Population, female_Proportion, sex_ratio) "
					+ "values('"
					+ nd.getNation()
					+ "',"
					+ nd.getMale_Population()
					+ ","
					+ nd.getMale_Proportion()
					+ ","
					+ nd.getFemale_Population()
					+ ","
                                        + nd.getFemale_Proportion()
					+ ","
					+ nd.getSex_ratio()
					+ ")";
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

 
	//查询所有
	public ArrayList<nation_data> findAll(){
		ArrayList<nation_data> list = new ArrayList<nation_data>();
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from nation_data";
			System.out.println("查询所有的SQL语句：" + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nation_data nd = new nation_data();
				nd.setNation(rs.getString("nation"));
				nd.setMale_Population(rs.getLong("male_Population"));
				nd.setMale_Proportion(rs.getDouble("male_Proportion"));
				nd.setFemale_Population(rs.getLong("female_Population"));
				nd.setFemale_Proportion(rs.getDouble("female_Proportion"));
                                nd.setSex_ratio(rs.getDouble("sex_ratio"));
				list.add(nd);
			}
			return list;
		} catch(Exception ee) {
			ee.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	

	//根据nation查询
	public nation_data findNation(String nation){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from nation_data where nation = '" + nation +"'";
			System.out.println("单个查询SQL语句：" + sql);			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nation_data nd = new nation_data();
				nd.setNation(rs.getString("nation"));
				nd.setMale_Population(rs.getLong("male_Population"));
				nd.setMale_Proportion(rs.getDouble("male_Proportion"));
				nd.setFemale_Population(rs.getLong("female_Population"));
				nd.setFemale_Proportion(rs.getDouble("female_Proportion"));
                                nd.setSex_ratio(rs.getDouble("sex_ratio"));
				return nd;
			}
			return null;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
        
        //根据男性人口数查询
	public nation_data findMpop(long male_Population){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from nation_data where male_Population = '" + male_Population +"'";
			System.out.println("单个查询SQL语句：" + sql);			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nation_data nd = new nation_data();
				nd.setNation(rs.getString("nation"));
				nd.setMale_Population(rs.getLong("male_Population"));
				nd.setMale_Proportion(rs.getDouble("male_Proportion"));
				nd.setFemale_Population(rs.getLong("female_Population"));
				nd.setFemale_Proportion(rs.getDouble("female_Proportion"));
                                nd.setSex_ratio(rs.getDouble("sex_ratio"));
				return nd;
			}
			return null;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
        //根据男性人口比重查询
	public nation_data findMpro(double male_Proportion){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
                        //MySQL查找浮点型数据时，用format 或 concat 查询
			String sql = "select * from nation_data where format(male_Proportion,3) = " + male_Proportion ;
			System.out.println("单个查询SQL语句：" + sql);			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nation_data nd = new nation_data();
				nd.setNation(rs.getString("nation"));
				nd.setMale_Population(rs.getLong("male_Population"));
				nd.setMale_Proportion(rs.getDouble("male_Proportion"));
				nd.setFemale_Population(rs.getLong("female_Population"));
				nd.setFemale_Proportion(rs.getDouble("female_Proportion"));
                                nd.setSex_ratio(rs.getDouble("sex_ratio"));
				return nd;
			}
			return null;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
        //根据女性人口数查询
	public nation_data findFpop(long female_Population){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from nation_data where female_Population = '" + female_Population +"'";
			System.out.println("单个查询SQL语句：" + sql);			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nation_data nd = new nation_data();
				nd.setNation(rs.getString("nation"));
				nd.setMale_Population(rs.getLong("male_Population"));
				nd.setMale_Proportion(rs.getDouble("male_Proportion"));
				nd.setFemale_Population(rs.getLong("female_Population"));
				nd.setFemale_Proportion(rs.getDouble("female_Proportion"));
                                nd.setSex_ratio(rs.getDouble("sex_ratio"));
				return nd;
			}
			return null;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}

        //根据女性人口比重查询
	public nation_data findFpro(double female_Proportion){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from nation_data where format(female_Proportion,3) = " + female_Proportion ;
			System.out.println("单个查询SQL语句：" + sql);			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nation_data nd = new nation_data();
				nd.setNation(rs.getString("nation"));
				nd.setMale_Population(rs.getLong("male_Population"));
				nd.setMale_Proportion(rs.getDouble("male_Proportion"));
				nd.setFemale_Population(rs.getLong("female_Population"));
				nd.setFemale_Proportion(rs.getDouble("female_Proportion"));
                                nd.setSex_ratio(rs.getDouble("sex_ratio"));
				return nd;
			}
			return null;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}   
        
        //根据男女性别比查询
	public nation_data findSr(double sex_ratio){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from nation_data where format(sex_ratio,3) = " + sex_ratio ;
			System.out.println("单个查询SQL语句：" + sql);			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nation_data nd = new nation_data();
				nd.setNation(rs.getString("nation"));
				nd.setMale_Population(rs.getLong("male_Population"));
				nd.setMale_Proportion(rs.getDouble("male_Proportion"));
				nd.setFemale_Population(rs.getLong("female_Population"));
				nd.setFemale_Proportion(rs.getDouble("female_Proportion"));
                                nd.setSex_ratio(rs.getDouble("sex_ratio"));
				return nd;
			}
			return null;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
        
	//删除
	public boolean delete(String id){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from nation_data limit " + id + ",1;";
                        System.out.println(sql);
                        String nation = null;
                        rs = stmt.executeQuery(sql);
                        while(rs.next()){
                        nation = rs.getString("nation");
                        }
                        String sql2 = "delete from nation_data where nation = '" + nation + "';";
                        
			System.out.println("删除的SQL语句是：" + sql2);
			int num = stmt.executeUpdate(sql2);
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
	

	//修改
	public boolean update(nation_data nd, String id){
	try{
		conn = JDBCUtils.getConnection();
		stmt = conn.createStatement();
                String sql = "select * from nation_data limit " + id + ",1;";
                System.out.println(sql);
                String old_nation = null;
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                    old_nation = rs.getString("nation");
                }
                
		String sql2 = "update nation_data set nation='" + nd.getNation() 
					+ "',male_Population=" + nd.getMale_Population()
					+ ",male_Proportion=" + nd.getMale_Proportion()
					+ ",female_Population=" + nd.getFemale_Population()
					+ ",female_Proportion=" + nd.getFemale_Proportion()
                                        + ",sex_ratio=" + nd.getSex_ratio()
                                        +" where nation = '"+old_nation  + "';";
		System.out.println("修改的SQL语句是：" + sql2);
		int num = stmt.executeUpdate(sql2);
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
