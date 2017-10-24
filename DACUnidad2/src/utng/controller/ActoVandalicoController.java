package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dom.ActoDOM;
import utng.model.Acto;


/**
 * Servlet implementation class ActoVandalicoController
 */
@WebServlet("/ActoVandalicoController")
public class ActoVandalicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Acto acto;
	private List<Acto> actos;
	private ActoDOM actoDOM;
	private List<String> ids = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActoVandalicoController() {
        super();
        acto = new Acto();
        actos=new ArrayList<Acto>();
        actoDOM = new ActoDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
			acto.setFecha(request.getParameter("fecha"));
			
			try {
				acto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			} catch (NumberFormatException e) {
				acto.setCodigo(123);
			}
			
			acto.setLugar(request.getParameter("lugar"));
			acto.setDescripcion(request.getParameter("descripcion"));
			
			if (acto.getId()=="") {
				String newId = "act" + String.format("%04d", 1);
				acto.setId(newId);
				if (actos.size()>0) {
					ids.clear();
					for (Acto a : actos) {
						ids.add(a.getId());
					}
					for (int i = 0; i <= ids.size(); i++) {
						newId = "act" + String.format("%04d",i+1);
						if (!ids.contains(newId)) {
							acto.setId(newId);
							break;
						}
					}
				}
				
				actoDOM.add(acto);
			} else {
				actoDOM.update(acto);
			}
			
			actos = actoDOM.getActos();
			request.setAttribute("actos", actos);
			request.getRequestDispatcher("acto_vandalico_list.jsp").forward(request, response);
			
			
		}else if(request.getParameter("btn_new") != null) {
			acto = new Acto();
			request.getRequestDispatcher("acto_vandalico_form.jsp").forward(request, response);
		}else if (request.getParameter("btn_edit") != null) {
			try {
				String id = request.getParameter("id");
				acto = actoDOM.findById(id);
			} catch (Exception e) {
				acto = new Acto();
			}
			request.setAttribute("acto", acto);
			request.getRequestDispatcher("acto_vandalico_form.jsp").forward(request, response);
		} else if (request.getParameter("btn_delete") != null) {
			try {
				String id = request.getParameter("id");
				actoDOM.delete(id);
				actos = actoDOM.getActos();

			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("actos", actos);
			request.getRequestDispatcher("acto_vandalico_list.jsp").forward(request, response);

		} else {
			actos = actoDOM.getActos();
			request.setAttribute("actos", actos);
			request.getRequestDispatcher("acto_vandalico_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
