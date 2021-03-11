package com.example.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.SuperVillain;

/**
 * Servlet implementation class HelperSessionServlet
 */
public class HelperSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//this sevlet will be used to grab the session when the button is cliscked in index.html
// and it will show us the most recent SuperVillain pushed to the session
    public HelperSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
        
    /*
     * In doGet() this is where we'll do the work and capture the session,
     * 
     * then we will format the object we retrieve from the session...
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SuperVillain villain = (SuperVillain) session.getAttribute("villain");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
			if(villain != null) {
				out.println("We've captured the villain!");
				out.println("<h1>Villain name: " + villain.getName() + "</h1><br/>");
				out.println("<b>Superpower: " + villain.getSuperpower() + "</b><br/>");
				out.println("<i>Bounty: " + villain.getBounty() + "</i>");
			}
			else
			{
				out.println("<i>Can't find any villains...</i>");
			}
		
		
		out.println("</body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
