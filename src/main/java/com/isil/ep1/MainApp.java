package com.isil.ep1;

import javax.xml.transform.Result;
import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Ep1",
                "root",
                "123456"
        );

        //Listar Registro

        Statement stmt1 = con.createStatement();

        ResultSet result1 = stmt1.executeQuery("Select * from Pokemon");

        while(result1.next()){
            System.out.println(result1.getString("iduser")+"\n"+
                    result1.getString("name")+"\n"+
                    result1.getString("type")+"\n"+
                    result1.getString("lvl")+"\n");

        }

        //Actualizar Registro


        Statement stmt2= con.createStatement();

        int resultupdate1 = stmt2.executeUpdate("Update Pokemon set name='Cindaquil' where name = 'Charmander' ");

        System.out.println("Filas Afectadas"+ resultupdate1);

        ResultSet resultSet2= stmt2.executeQuery("Select * from Pokemon where type = 'fuego'");

        while(resultSet2.next()){
            System.out.println(resultSet2.getString("iduser")+"\n"+
                    resultSet2.getString("name")+"\n"+
                    resultSet2.getString("type")+"\n"+
                    resultSet2.getString("lvl")+"\n");

        }

        //Crear Registro

        Statement stmt3 = con.createStatement();

        int resultUpdate2 = stmt3.executeUpdate("Insert into Pokemon Values (5,'Zubat','Volador',7)");
        System.out.println("Filas Afectadas: "+ resultUpdate2);

        PreparedStatement preparedStatement1 = con.prepareStatement("Select * from Pokemon where name =?");
        preparedStatement1.setString(1,"Zubat");

        ResultSet resultSet3 = preparedStatement1.executeQuery();

        while (resultSet3.next()){
            System.out.println(resultSet3.getString("name")+"\n"+
                    resultSet3.getString("Type")+"\n"+
                    resultSet3.getString("lvl")+"\n");
        }

        //Eliminar Registro

        Statement stmt4 = con.createStatement();
        int resultUpdate3 = stmt4.executeUpdate("Delete from Pokemon where name='Zubat' ");

        System.out.println("Filas Afectadas: "+ resultUpdate3);

        ResultSet resultSet4= stmt4.executeQuery("Select * from Pokemon");

        while(resultSet4.next()){
            System.out.println(resultSet4.getString("iduser")+"\n"+
                    resultSet4.getString("name")+"\n"+
                    resultSet4.getString("type")+"\n"+
                    resultSet4.getString("lvl")+"\n");

        }



    }
}
