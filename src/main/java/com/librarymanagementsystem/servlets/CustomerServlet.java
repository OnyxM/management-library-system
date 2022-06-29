package com.librarymanagementsystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.librarymanagementsystem.beans.Client;
import com.librarymanagementsystem.beans.Emprunt;
import com.librarymanagementsystem.dao.ClientDao;
import com.librarymanagementsystem.dao.DaoFactory;
import com.librarymanagementsystem.dao.EmpruntDao;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClientDao clientDao;
	private EmpruntDao empruntDao;
	private Gson gson = new Gson();

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.clientDao = daoFactory.getClientDao();
        this.empruntDao = daoFactory.getEmpruntDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();
		action = action == null ? "" : action;
		
		switch (action) {
		case "/new":
			displayNewCustomerPage(request, response);
			break;
		case "/list":
			displayCustomersListPage(request, response);
			break;
		default:
			displayCustomersListPage(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void displayCustomersListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> customersList = new ArrayList<Client>();
		customersList = clientDao.findAll();
		
		List<Emprunt> empruntsList = new ArrayList<Emprunt>();
		empruntsList = empruntDao.findAll();
		
		request.setAttribute("customersList", customersList);
		request.setAttribute("jsonCustomersList", gson.toJson(customersList));
		
		request.setAttribute("empruntsList", empruntsList);
		request.setAttribute("jsonEmpruntsList", gson.toJson(empruntsList));
		this.getServletContext().getRequestDispatcher("/WEB-INF/app/customers/list.jsp").forward(request, response);
	}
	
	private void displayNewCustomerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/app/customers/new.jsp").forward(request, response);
	}

}
