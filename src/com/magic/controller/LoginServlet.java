package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee/login.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String url = "employee/login.jsp";
		EmployeesDAO emDao = EmployeesDAO.getInstance();
		int result = emDao.userCheck(id, pwd, lev);
		
		if(result == 1) {
			url = "main.jsp";
			HttpSession session = request.getSession();
			EmployeesVO emVo = new EmployeesVO();
			emVo = emDao.getEmployee(id);
			session.setAttribute("loginUser", emVo);
			session.setAttribute("result", lev);
		} else if(result == 0) {
			request.setAttribute("message", "로그인 정보가 틀렸습니다.");
		} else {
			request.setAttribute("message", "회원정보가 존재하지 않습니다");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}//class
