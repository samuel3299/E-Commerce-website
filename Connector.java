package com.example.supplychain;
import java.sql.*;
public class Connector {
    String URL = "jdbc:mysql://localhost:3306/commerce?useSSL=false";
    String root = "root";
    String pass = "Ksamuel@1";
    Connection con = null;
    Connector(){
        try {
            con = DriverManager.getConnection(URL, root, pass);
            if (con != null) {
                System.out.println("Connected");
            }
        }
            catch(Exception e){
                e.printStackTrace();
        }
    }
    public ResultSet executeQuery(String query){
        ResultSet res = null;
        try{
            Statement statement = con.createStatement();
            res = statement.executeQuery(query);
            return res;

        } catch (Exception e) {
           e.printStackTrace();
        }
        return res;
    }
    public int UpdateQuery(String query){
        int res =0;
        try{
            Statement statement = con.createStatement();
            res = statement.executeUpdate(query);
            return res;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
