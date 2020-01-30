package app.web;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.modelo.Contacto;

import app.persistencia.AccesoContactos;



/**
 * Servlet implementation class controlUsuarios
 */
@WebServlet("/control")
public class controlContactos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("op");
		
			switch (opcion) {
				case "consultarTodos": 
					
					ArrayList<Contacto> lista = new ArrayList<Contacto>();
					AccesoContactos acceso = new AccesoContactos();
					
					try {
						lista = acceso.verTodos();
						request.setAttribute("lista", lista);
						RequestDispatcher rd = request.getRequestDispatcher("/mostrarAgenda.jsp");
						rd.forward(request, response);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.toString());
					}
							
					break;				
				default:
					break;
					
			}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String opcion = request.getParameter("op");
		
		switch (opcion) {
		case "insertar": 
			insertarContacto(request,response);			
			break;
		case "consultar":
			consultarContacto(request, response);
			break;		
		case "modificar":
			modificarContacto(request, response);
			break;
		case "borrar":
			borrarContacto(request, response);
			break;		
		default:
			break;
		}			
	}	
	
	private void insertarContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");		
		Contacto c = new Contacto(nombre, email, telefono);
		RequestDispatcher rd;
		AccesoContactos acceso = new AccesoContactos();
		HttpSession session = request.getSession();
		session.setAttribute("contacto", c);
		
		try {
			acceso.registrarContacto(c);
			rd = request.getRequestDispatcher("/ContactoInsertado.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.toString());
		}	 	    
	}
	
	private void consultarContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idContacto = Integer.parseInt(request.getParameter("idContacto"));
		Contacto c = null;
		RequestDispatcher rd;
		AccesoContactos acceso = new AccesoContactos();
		HttpSession session = request.getSession();
		
			try {
				c = acceso.VerContacto(idContacto);
				session.setAttribute("contacto", c);
				rd = request.getRequestDispatcher("/MostrarContacto.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 	    
	}		
	
	private void modificarContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idContacto = Integer.parseInt(request.getParameter("idContacto"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		Contacto contA = new Contacto();
		Contacto contB = new Contacto();
		RequestDispatcher rd;
		AccesoContactos acceso = new AccesoContactos();
		HttpSession session = request.getSession();
		boolean modificado;		
		
		try {
			contA = acceso.VerContacto(idContacto);
			session.setAttribute("contacto1", contA);
			modificado = acceso.modificarContacto(idContacto, nombre, email, telefono);
			contB = acceso.VerContacto(idContacto);
			session.setAttribute("contacto2", contB);
			if (modificado) {
				rd = request.getRequestDispatcher("/ContactoModificado.jsp");
			rd.forward(request, response);
			}			
			
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.toString());
		}	 	    
	}
	
	private void borrarContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idContacto = Integer.parseInt(request.getParameter("idContacto"));
		Contacto cont = new Contacto();		
		RequestDispatcher rd;
		AccesoContactos acceso = new AccesoContactos();		
		HttpSession session = request.getSession();
		boolean borrado;		
		
		try {
			cont = acceso.VerContacto(idContacto);
			session.setAttribute("contacto", cont);
			borrado = acceso.borrarContacto(idContacto);
			if (borrado) {
				rd = request.getRequestDispatcher("/ContactoBorrado.jsp");
				rd.forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.toString());
		}	 	    
	}
}