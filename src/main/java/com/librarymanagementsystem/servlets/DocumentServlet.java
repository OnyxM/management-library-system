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
 * Servlet implementation class DocumentServlet
 */
public class DocumentServlet extends HttpServlet {
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
    public DocumentServlet() {
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
			displayNewDocumentPage(request, response);
			break;
		case "/list":
			displayDocumentsListPage(request, response);
			break;
		default:
			displayDocumentsListPage(request, response);
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
	
	private void displayDocumentsListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Document> documentsList = new ArrayList<Document>();
		documentsList = documentDao.findAll();
		
		List<Exemplaire> exemplairesList = new ArrayList<Exemplaire>();
		exemplairesList = exemplaireDao.findAll();
		
		request.setAttribute("documentsList", documentsList);
		request.setAttribute("jsonDocumentsList", gson.toJson(documentsList));
		
		request.setAttribute("exemplairesList", exemplairesList);
		request.setAttribute("jsonExemplairesList", gson.toJson(exemplairesList));
		this.getServletContext().getRequestDispatcher("/WEB-INF/app/documents/list.jsp").forward(request, response);
	}
	
	private void displayNewDocumentPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/app/documents/new.jsp").forward(request, response);
	}

}
