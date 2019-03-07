package service;

import dao.StuDao;
import domain.Student;

public class StuService {
	StuDao stuDao=new StuDao();
	public String add(Student stu){
		return stuDao.add(stu);
	}
	public Student find(Integer id){
		return stuDao.find(id);
	}
	public String delete(Integer id){
		return stuDao.delete(id);
	}
	public String update(Student stu){
		return stuDao.update(stu);
	}
}
