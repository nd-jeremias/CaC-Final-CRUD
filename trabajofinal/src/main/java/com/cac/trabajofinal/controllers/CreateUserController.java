package com.cac.trabajofinal.controllers;

import com.cac.trabajofinal.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

import com.cac.trabajofinal.domain.Usuarios;

@WebServlet("/createusercontroller")
public class CreateUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        String jsonDelFront = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        UserService service = new UserService();
    
        ObjectMapper mapper = new ObjectMapper();

        Usuarios usuario = mapper.readValue(jsonDelFront, Usuarios.class);
        
        try {
            service.createUsuario(usuario);
            //respondemos algo al front por medio del codigo de estado
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (Exception e) {
            System.out.println(e);
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
        }        
    }
}
