package com.cac.trabajofinal.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.cac.trabajofinal.domain.Usuarios;
import com.cac.trabajofinal.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/findalluserscontroller")
public class FindAllUsersController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    // Configurar cabeceras CORS
    resp.setHeader("Access-Control-Allow-Origin", "*"); // Permitir acceso desde cualquier origen
    resp.setHeader("Access-Control-Allow-Methods", "*"); // Métodos permitidos
    resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // Cabeceras permitidas

    UserService service = new UserService();

    ArrayList <Usuarios> listado = service.FindAllUsers();

    ObjectMapper mapper = new ObjectMapper();
    String usuariosJSON = mapper.writeValueAsString(listado);
    
    try {
      //respondemos algo al front por medio del codigo de estado
      System.out.println("JSON de respuesta: " + usuariosJSON);
      resp.getWriter().println(usuariosJSON);
      resp.setStatus(HttpServletResponse.SC_OK);
    } catch (Exception e) {
      System.out.println(e);
      resp.setStatus(HttpServletResponse.SC_CONFLICT);
    }
  }
}