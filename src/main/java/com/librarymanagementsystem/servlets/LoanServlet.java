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
import com.librarymanagementsystem.beans.Document;
import com.librarymanagementsystem.beans.Emprunt;
import com.librarymanagementsystem.beans.Exemplaire;
import com.librarymanagementsystem.dao.EmpruntDao;
import com.librarymanagementsystem.dao.ExemplaireDao;
import com.librarymanagementsystem.dao.ClientDao;
import com.librarymanagementsystem.dao.DaoFactory;
import com.librarymanagementsystem.dao.DocumentDao;

/**
 * Servlet implementation class LoanServlet
 */
public class LoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private EmpruntDao empruntDao;
	private ClientDao clientDao;
	private DocumentDao documentDao;
	private ExemplaireDao exemplaireDao;
	
	private Gson gson = new Gson();

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.empruntDao = daoFactory.getEmpruntDao();
        this.clientDao = daoFactory.getClientDao();
        this.documentDao = daoFactory.getDocumentDao();
        this.exemplaireDao = daoFactory.getExemplaireDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoanServlet() {
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
			displayNewLoanPage(request, response);
			break;
		case "/list":
			displayLoansListPage(request, response);
			break;
		default:
			displayLoansListPage(request, response);
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
	
	private void displayLoansListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Emprunt> loansList = new ArrayList<Emprunt>();
		loansList = empruntDao.findAll();
		
		List<Client> customersList = new ArrayList<Client>();
		customersList = clientDao.findAll();
		
		List<Exemplaire> copiesList = new ArrayList<Exemplaire>();
		copiesList = exemplaireDao.findAll();
		
		List<Document> documentsList = new ArrayList<Document>();
		documentsList = documentDao.findAll();
		
		request.setAttribute("loansList", loansList);
		request.setAttribute("jsonLoansList", gson.toJson(loansList));
		
		request.setAttribute("customersList", customersList);
		request.setAttribute("jsonCustomersList", gson.toJson(customersList));
		
		request.setAttribute("copiesList", copiesList);
		request.setAttribute("jsonCopiesList", gson.toJson(copiesList));
		
		request.setAttribute("documentsList", documentsList);
		request.setAttribute("jsonDocumentsList", gson.toJson(documentsList));
		this.getServletContext().getRequestDispatcher("/WEB-INF/app/loans/list.jsp").forward(request, response);
	}
	
	private void displayNewLoanPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/app/loans/new.jsp").forward(request, response);
	}

}
