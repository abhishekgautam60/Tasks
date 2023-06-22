/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample.service;
import java.sql.*;

import com.sample.Categories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Abhishek.Gautam
 */
public class AbstractFacade{
    
//    List<Categories> aliens;
    
Connection con = null;
    public AbstractFacade() {
        
        
        String url="jdbc:mysql://localhost:3306/northwind";
        String username="root";
        String password= "123456789";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }    

    }
 
    public List<Categories> getAliens()
    {
        List<Categories> aliens=new ArrayList<>();
        
//        for getting data from database
        String sql="select * from categories";
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
               Categories a= new Categories();
				a.setCategoryID(rs.getInt(1));
				a.setCategoryName(rs.getString(2));
				a.setDescription(rs.getString(3));
                
                aliens.add(a);
            }
        }
        catch(SQLException e)          
        {
             System.out.println(e);          
        }       
        return aliens;
    }
    
    public Categories getAlien(int categoryID)
    {
        
//        for getting data from database with specific id.
        String sql="select * from categories where categoryID="+categoryID;
        Categories cr= new Categories();
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                
                cr.setCategoryID(rs.getInt(1));
		cr.setCategoryName(rs.getString(2));
		cr.setDescription(rs.getString(3));
		
            }
        }
        catch(SQLException e)          
        {
             System.out.println(e);       
   
        }
        return cr;
    }

    public void create(Categories a1) {
        String sql="insert into Categories values(?,?,?)";
        try
        {
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, a1.getCategoryID());
            st.setString(2, a1.getCategoryName());
            st.setString(3, a1.getDescription());
            int i =st.executeUpdate();
            if(i>0)
            {
                System.out.println("All data is inserted successfully");                
            }
            else
            {
                System.out.println("data is not inserted properly, please try again later");
            }
           
        }
        catch(SQLException e)
        {
           System.out.println(e); 
        }
    } 

    
}
