package com.magic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

/**
 * Servlet implementation class CustomServlet
 */
@WebServlet("/custom.do")
public class CustomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("employee/custom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String lev = request.getParameter("lev");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		EmployeesDAO emDao = EmployeesDAO.getInstance();
		EmployeesVO emVo = new EmployeesVO();
		emVo = emDao.custom(id, pwd, name, lev, gender, phone);
		HttpSession session = request.getSession();
		if(emVo != null) {
		session.setAttribute("customUser", emVo);
		session.setAttribute("update","회원 등록에 성공했습니다");
		} else {
			session.setAttribute("update","회원 등록에 실패했습니다");
			session.removeAttribute("customUser");
		}
		
		
		request.getRequestDispatcher("employee/myPage2.jsp").forward(request, response);
	}

}
