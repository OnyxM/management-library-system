package com.librarymanagementsystem.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.librarymanagementsystem.beans.Document;
import com.librarymanagementsystem.beans.Exemplaire;
import com.librarymanagementsystem.dao.DaoFactory;
import com.librarymanagementsystem.dao.DocumentDao;
import com.librarymanagementsystem.dao.ExemplaireDao;

/**
 * Servlet implementation class CopyServlet
 */
public class CopyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DocumentDao documentDao;
	private ExemplaireDao exemplaireDao;
	private Gson gson = new Gson();

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.documentDao = daoFactory.getDocumentDao();
        this.exemplaireDao = daoFactory.getExemplaireDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CopyServlet() {
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
			displayNewCopyPage(request, response);
			break;
		case "/list":
			displayCopiesListPage(request, response);
			break;
		default:
			displayCopiesListPage(request, response);
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
	
	private void displayCopiesListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Document> documentsList = new ArrayList<Document>();
		documentsList = documentDao.findAll();
		
		List<Exemplaire> copiesList = new ArrayList<Exemplaire>();
		copiesList = exemplaireDao.findAll();
		
		request.setAttribute("documentsList", documentsList);
		request.setAttribute("jsonDocumentsList", gson.toJson(documentsList));
		
		request.setAttribute("copiesList", copiesList);
		request.setAttribute("jsonCopiesList", gson.toJson(copiesList));
		this.getServletContext().getRequestDispatcher("/WEB-INF/app/copies/list.jsp").forward(request, response);
	}
	
	private void displayNewCopyPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/app/copies/new.jsp").forward(request, response);
	}

}
