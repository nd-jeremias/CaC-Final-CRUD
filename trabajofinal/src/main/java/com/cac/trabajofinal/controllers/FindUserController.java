package com.cac.trabajofinal.controllers;

import com.cac.trabajofinal.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.cac.trabajofinal.domain.Usuarios;

@WebServlet("/findusercontroller")
public class FindUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        UserService service = new UserService();
    
        String id = req.getParameter("id");
        System.out.println("id del front: " + id);
        Long idLong = Long.parseLong(id);

        Usuarios usuario = service.getUsuario(idLong);

        ObjectMapper mapper = new ObjectMapper();
        String usuarioJSON = mapper.writeValueAsString(usuario);
    
        System.out.println("JSON de respuesta: " + usuarioJSON);
        resp.getWriter().println(usuarioJSON);
    }
}
