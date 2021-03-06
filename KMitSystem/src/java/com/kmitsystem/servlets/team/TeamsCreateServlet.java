package com.kmitsystem.servlets.team;

import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.services.team.input.CreateTeamInput;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kmitsystem.tools.errorhandling.Error;
import com.kmitsystem.tools.errorhandling.Errors;
import java.util.List;
import javax.servlet.RequestDispatcher;
/**
 * @author Maik
 */
public class TeamsCreateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;      
        
        // get all users and write them into an attribute 
        List<User> users;   
        users = DBUserQueries.getAllUser();
        request.setAttribute("users", users);
        
        // check if the user filled the form or if he came from another page
        if(request.getParameter("name") != null) {

            // prepare the input
            String name = request.getParameter("name");
            String tag = request.getParameter("tag");
            String password = request.getParameter("password");
            String reenter_password = request.getParameter("reenter_password");
            // @TODO: get the username from the leader out of the session
            User leader = (User) request.getSession().getAttribute("user");
            
            // prepare the output
            BaseResult result = new BaseResult();
            
            // check if both passwords are equal, if true create the team
            if(password.equals(reenter_password)) {
                TeamServiceProvider provider = new TeamServiceProvider();
                CreateTeamInput input = new CreateTeamInput(name, tag, password, leader.getUsername());
                result = provider.createTeam(input);

                // redirect to the profile of the new team
                response.sendRedirect(request.getContextPath() + "/team/profile?team="+name);
            } else {
                List<Error> errorList = new ArrayList<Error>();
                errorList.add(Errors.PASSWORDS_NOT_EQUAL);
                result.setErrorList(errorList);
                request.setAttribute("errors", result.getErrorList());

                // redirect to the teamcreation page and show the error
                rd = request.getRequestDispatcher("/WEB-INF/teams/create/index.jsp");
                rd.include(request, response);
            }

            // write the errorlist into the session-attribute "errors"
            if(result.getErrorList().size() > 0) 
                request.setAttribute("errors", result.getErrorList());
        
        } else {
            // redirect to the teamcreation page without doing anything
            rd = request.getRequestDispatcher("/WEB-INF/teams/create/index.jsp");
            rd.include(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
