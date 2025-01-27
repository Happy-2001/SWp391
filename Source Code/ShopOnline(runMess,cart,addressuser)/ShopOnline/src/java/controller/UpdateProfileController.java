/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author nguye
 */
public class UpdateProfileController extends HttpServlet {

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
         response.setContentType("text/html;charset=UTF-8");
        UserDAO db = new UserDAO();
        
            String id = request.getParameter("id");
        User u = db.getUserById(id);
        
        
        String pass = request.getParameter("password");
        if(pass == null || pass.isEmpty()) {
            pass = u.getPassword();
        }
        
        String fname = request.getParameter("fname");
        if(pass == null || pass.isEmpty()) {
            fname = u.getFirstname();
        }
        
        String mdname = request.getParameter("mdname");
        if(pass == null || pass.isEmpty()) {
            mdname = u.getMiddlename();
        }
        String lname = request.getParameter("lname");
        if(pass == null || pass.isEmpty()) {
            lname = u.getLastname();
        }
        
        String gender = request.getParameter("gender");
        if(gender == null || gender.isEmpty()) {
            gender = "1";
        }
        
        db.updateProfile(Integer.parseInt(id), pass, fname, mdname, lname, Integer.parseInt(gender));
       
        response.sendRedirect("ProfileUser?userid="+id);
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
