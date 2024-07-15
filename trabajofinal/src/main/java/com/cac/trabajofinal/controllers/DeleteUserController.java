package com.cac.trabajofinal.controllers;

import java.io.IOException;

import com.cac.trabajofinal.domain.Usuarios;
import com.cac.trabajofinal.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deleteusercontroller")
public class DeleteUserController extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserService();
    
        String id = req.getParameter("id");
        Long idLong = Long.parseLong(id);

        Usuarios usuario = service.deleteUser(idLong);
    
        
        try {
            service.createUsuario(usuario);
            //respondemos algo al front por medio del codigo de estado
            System.out.println("Se ha borrado el usuario: " + usuario);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            System.out.println(e);
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}
