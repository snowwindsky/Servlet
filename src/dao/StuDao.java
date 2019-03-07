package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Student;
import other.Jdbc;

public class StuDao {
	public String add(Student student){
		Connection conn=Jdbc.open();
		String info=null;
		String sql="insert into student values(?,?,?,?)";
		try {
			PreparedStatement pStat=conn.prepareStatement(sql);
			pStat.setInt(1, student.getId());
			pStat.setString(2, student.getName());
			pStat.setInt(3, student.getAge());
			pStat.setString(4, student.getS_class());
			pStat.execute();
			info="1插入成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			info="0插入失败";
		}finally {
			Jdbc.close(conn);	
		}
		return info;
	}
	public Student find(Integer id){
		Connection conn=Jdbc.open();
		String sql="select * from student where id=?";
		try {
			PreparedStatement pStat=conn.prepareStatement(sql);
			pStat.setInt(1, id);
			ResultSet rs=pStat.executeQuery();
			Student student=new Student();
			if(rs.next()){
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setS_class(rs.getString(4));
				return student;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jdbc.close(conn);
		}
		return null;
	}
	public String delete(Integer id){
		Connection conn=Jdbc.open();
		String sql="delete from student where id=?";
		String info=null;
		try {
			PreparedStatement pStat=conn.prepareStatement(sql);
			pStat.setInt(1, id);
			pStat.execute();
			info="1删除成功";
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			info="0删除失败";
		}finally {
			Jdbc.close(conn);
		}
		return info;
	}
	public String update(Student student){
		Connection conn=Jdbc.open();
		String sql="update student set name=?,age=?,s_class=? where id=?";
		String info=null;
		try {
			PreparedStatement pStat=conn.prepareStatement(sql);
			pStat.setString(1, student.getName());
			pStat.setInt(2, student.getAge());
			pStat.setString(3, student.getS_class());
			pStat.setInt(4, student.getId());
			pStat.execute();
			info="1更新成功";
			return info;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			info="0更新失败";
		}finally {
			Jdbc.close(conn);
		}
		return info;
	}
}
