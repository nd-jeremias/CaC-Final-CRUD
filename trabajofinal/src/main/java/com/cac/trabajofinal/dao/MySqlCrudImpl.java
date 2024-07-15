package com.cac.trabajofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.cac.trabajofinal.domain.Usuarios; 


public class MySqlCrudImpl implements ICrud{

    //FIND-USER-BY-ID
    public Usuarios getById(Long id) {

        String SqlQueryId = "select * from usuarios where id = " + id;

        Usuarios usuario = null;
        Connection connection = null;

        try {
            connection = AdminConection.conectar();
            PreparedStatement statement = connection.prepareStatement(SqlQueryId);
            ResultSet resultSet = statement.executeQuery(SqlQueryId);

            if(resultSet.next()) {
                Long idusuario = resultSet.getLong(1);
                String user = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                Long telefono = resultSet.getLong(5);
                String email = resultSet.getString(6);
                String password = resultSet.getString(7);

                usuario = new Usuarios(idusuario, user, nombre, apellido, telefono, email, password);
            }

        } catch (Exception e) {
            System.out.println("Error al conectarse: " + e.getMessage());
        }finally {
            AdminConection.desconectar(connection);
        }
        return usuario;

    }
    
    //FIND-ALL-USERS
    public ArrayList<Usuarios> FindAllUsers() {
        String SqlFindAll = "SELECT * FROM usuarios";

        Connection connection = null;
        
        ArrayList<Usuarios> usuarios = new ArrayList<>();

        try {
            connection = AdminConection.conectar();
            PreparedStatement statement = connection.prepareStatement(SqlFindAll);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String user = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                Long telefono = resultSet.getLong(5);
                String email = resultSet.getString(6);
                String password = resultSet.getString(7);

                Usuarios usuario = new Usuarios(id, user, nombre, apellido, telefono, email, password);
                
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al conectarse: " + e.getMessage());
        }finally {
            AdminConection.desconectar(connection);
        }

        return usuarios;
    }

    //CREATE-USER
    public void createUsuario(Usuarios nuevo) {
        String SqlCreateId = "INSERT INTO `usuarios` (`usuario`, `nombre`, `apellido`, `telefono`, `email`, `password`) VALUES ( ?, ?, ?, ?, ?, ?);";

        Connection connection = null;

        try {
            connection = AdminConection.conectar();
            PreparedStatement statement = connection.prepareStatement(SqlCreateId);

            statement.setString(1, nuevo.getUser());
            statement.setString(2, nuevo.getNombre());
            statement.setString(3, nuevo.getApellido());
            statement.setLong(4, nuevo.getTelefono());
            statement.setString(5, nuevo.getEmail());
            statement.setString(6, nuevo.getPassword());
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al conectarse: " + e.getMessage());
        }finally {
            AdminConection.desconectar(connection);
        }
    }


    //DELETE-USER-BY-ID
    public Usuarios deleteUser(Long id) {
        String SqlDeleteById = "delete from usuarios where id = " + id;
        String SqlQueryId = "select * from usuarios where id = " + id;
        Usuarios usuario = null;
        Connection connection = null;

        try {
            connection = AdminConection.conectar();
            PreparedStatement statement = connection.prepareStatement(SqlQueryId);
            ResultSet resultSet = statement.executeQuery(SqlQueryId);

            if(resultSet.next()) {
                Long idusuario = resultSet.getLong(1);
                String user = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                Long telefono = resultSet.getLong(5);
                String email = resultSet.getString(6);
                String password = resultSet.getString(7);

                usuario = new Usuarios(idusuario, user, nombre, apellido, telefono, email, password);
                
            }
            statement = connection.prepareStatement(SqlDeleteById);
            statement.execute(SqlDeleteById);

        } catch (Exception e) {
            System.out.println("Error al conectarse: " + e.getMessage());
        }finally {
            AdminConection.desconectar(connection);
        }
        return usuario;
    }
}
