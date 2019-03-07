package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.StuService;

/**
 * Servlet implementation class SelServlet
 */
@WebServlet("/SelServlet")
public class SelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StuService service=new StuService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelServlet() {
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
		
		int id=Integer.parseInt(s_id);
		
		Student student=service.find(id);
		ArrayList<Student> result=new ArrayList<>();
		result.add(student);
		request.setAttribute("result", result);
		request.getRequestDispatcher("select.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
