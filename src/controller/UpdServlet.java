package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.StuService;

/**
 * Servlet implementation class UpdServlet
 */
@WebServlet("/UpdServlet")
public class UpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StuService service=new StuService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String s_id=request.getParameter("id");
		String name=request.getParameter("name");
		String s_age=request.getParameter("age");
		String s_class=request.getParameter("s_class");
		
		int id=Integer.parseInt(s_id);
		int age=Integer.parseInt(s_age);
		
		
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		student.setS_class(s_class);
		
		//System.out.println(student.toString());
		service.update(student);
		ArrayList<Student> result=new ArrayList<>();
		result.add(service.find(id));
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("after_update.jsp").forward(request, response);
//		String info=service.update(student);
//		info=new String(info.getBytes("UTF-8"), "ISO-8859-1");
//		PrintWriter out=response.getWriter();
//		out.println(info);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
