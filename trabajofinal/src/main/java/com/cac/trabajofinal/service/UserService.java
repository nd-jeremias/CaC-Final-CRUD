package com.cac.trabajofinal.service;

import java.util.ArrayList;

import com.cac.trabajofinal.dao.ICrud;
import com.cac.trabajofinal.dao.MySqlCrudImpl;
import com.cac.trabajofinal.domain.Usuarios;

public class UserService {

    private ICrud crud = new MySqlCrudImpl();

    public void createUsuario (Usuarios nuevo) {
        this.crud.createUsuario(nuevo);
    }

    public Usuarios getUsuario (Long id) {
        return this.crud.getById(id);
    }

    public ArrayList<Usuarios> FindAllUsers() {
        return this.crud.FindAllUsers();
    }

    public Usuarios deleteUser (Long id) {
        return this.crud.deleteUser(id);
    }
}
