
package com.kmitsystem.servlets.team;

import com.kmitsystem.services.team.TeamServiceProvider;
import com.kmitsystem.services.team.input.EditTeamInput;
import com.kmitsystem.tools.database.queries.DBTeamQueries;
import com.kmitsystem.tools.database.queries.DBUserQueries;
import com.kmitsystem.tools.errorhandling.Errors;
import com.kmitsystem.tools.errorhandling.Error;
import com.kmitsystem.tools.objects.BaseResult;
import com.kmitsystem.tools.objects.Team;
import com.kmitsystem.tools.objects.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Smadback
 */
public class TeamDashboardServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        String teamname = request.getParameter("team");

        // get the team and write it into the session
        Team team = DBTeamQueries.getTeam(teamname);
        request.setAttribute("team", team);
        
        // get all users and write them into an attribute 
        List<User> users = DBUserQueries.getAllUser();
        request.setAttribute("users", users);
        
        // check if the user filled the form or if he came from another page
        if(request.getParameter("name_old") != null) {
            
            // prepare the input
            String name_old  = request.getParameter("name_old");
            String name_new  = request.getParameter("name_new");
            String name_new2 = request.getParameter("name_new2");
            
            // prepare the output
            BaseResult result = new BaseResult();
            
            // check if the name of the team is correct
            if(name_old.equals(team.getName())) {
                // check if both names are equal, if true change the teamname
                if(name_new.equals(name_new2)) {
                    TeamServiceProvider provider = new TeamServiceProvider();
                    EditTeamInput input = new EditTeamInput(name_old, name_new, null, null, null);
                    result = provider.editTeam(input);
                } else {
                    List<Error> errorList = new ArrayList<Error>();
                    errorList.add(Errors.NAMES_NOT_EQUAL);
                    result.setErrorList(errorList);
                    request.setAttribute("errors", result.getErrorList());
                }
            } else {
                List<Error> errorList = new ArrayList<Error>();
                errorList.add(Errors.NAME_IS_FALSE);
                result.setErrorList(errorList);
                request.setAttribute("errors", result.getErrorList());
            }

            // write the errorlist into the session-attribute "errors"
            if(result.getErrorList().size() > 0) 
                request.setAttribute("errors", result.getErrorList());
                
        }
        
        // redirect to the dashboard page of the team
        rd = request.getRequestDispatcher("/WEB-INF/teams/dashboard/index.jsp");
        rd.include(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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