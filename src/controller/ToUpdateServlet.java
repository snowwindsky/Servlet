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
 * Servlet implementation class ToUpdateServlet
 */
@WebServlet("/ToUpdateServlet")
public class ToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StuService service=new StuService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s_id=request.getParameter("id");
		int id=Integer.parseInt(s_id);
		ArrayList<Student> result=new ArrayList<>();
		result.add(service.find(id));
		request.setAttribute("result",result);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
