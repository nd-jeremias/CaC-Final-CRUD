package com.cac.trabajofinal.dao;

import java.util.ArrayList;
import com.cac.trabajofinal.domain.Usuarios;

public interface ICrud {
    
    public Usuarios getById(Long id);

    public void createUsuario(Usuarios nuevo);

    public ArrayList<Usuarios> FindAllUsers();

    public Usuarios deleteUser(Long id);

}
