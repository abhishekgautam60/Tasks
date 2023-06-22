/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.sample.Employees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abhishek.Gautam
 */
public class Facade{

    Connection con = null;

    public Facade() {
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
     public List<Employees> findAll() 
    {        
        List<Employees> aliens=new ArrayList<>();
        
//        for getting data from database
        String sql="select * from Employees";
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
               Employees a= new Employees();
				a.setEmployeeID(rs.getInt(1));
				a.setLastName(rs.getString(2));
				a.setFirstName(rs.getString(3));
                                a.setTitle(rs.getString(4));
				a.setTitleOfCourtesy(rs.getString(5));
				a.setBirthDate(rs.getDate(6));
                                a.setHireDate(rs.getDate(7));
				a.setAddress(rs.getString(8));
				a.setCity(rs.getString(9));
                                a.setRegion(rs.getString(10));
				a.setPostalCode(rs.getString(11));
                                a.setCountry(rs.getString(12));
				a.setHomePhone(rs.getString(13));
                                a.setExtension(rs.getString(14));
				a.setNotes(rs.getString(15));      
                aliens.add(a);
            }
        }
        catch(SQLException e)          
        {
             System.out.println(e);          
        }       
        return aliens;
    }   

//  Retriving data with specific id
    public Employees find(int EmployeeID) {
      String sql="select * from employees where EmployeeID="+EmployeeID;
      Employees a= new Employees();        
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                a.setEmployeeID(rs.getInt(1));
                a.setLastName(rs.getString(2));
		a.setFirstName(rs.getString(3));
                a.setTitle(rs.getString(4));
		a.setTitleOfCourtesy(rs.getString(5));
		a.setBirthDate(rs.getDate(6));
                a.setHireDate(rs.getDate(7));
		a.setAddress(rs.getString(8));
		a.setCity(rs.getString(9));
                a.setRegion(rs.getString(10));
		a.setPostalCode(rs.getString(11));
                a.setCountry(rs.getString(12));
                a.setHomePhone(rs.getString(13));
                a.setExtension(rs.getString(14));
                a.setNotes(rs.getString(15));		
            }
        }
        catch(SQLException e)          
        {
             System.out.println(e);
        }
        return a;
    }  

   // For retriving Data for specific country.
    public Employees findByLastName(String LastName) 
    {
        String sql="select employeeID, LastName, FirstName, Title, City  from Employees where LastName="+LastName;
        Employees a2= new Employees();
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {     
                    a2.setEmployeeID(rs.getInt(1));
                    a2.setLastName(rs.getString(2));
                    a2.setFirstName(rs.getString(3));
                    a2.setTitle(rs.getString(4));
                    a2.setCity(rs.getString(5));                                   
            }
        }
        catch(SQLException e)          
        {
             System.out.println(e);
        }
        return a2;
    }
// For retriving specific column data into the table
    public List<Employees> findSpecificData() {
        List<Employees> aliens=new ArrayList<>();
        String sql="select employeeID, LastName, FirstName, Title, City  from Employees";
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                Employees a= new Employees();
                    a.setEmployeeID(rs.getInt(1));
                    a.setLastName(rs.getString(2));
                    a.setFirstName(rs.getString(3));
                    a.setTitle(rs.getString(4));
                    a.setCity(rs.getString(5));
                aliens.add(a);
            }
        }
        catch(SQLException e)          
        {
             System.out.println(e);          
        }       
        return aliens;
    }
    // For counting all TItle's.
    public List<Employees> ShortingTitle() 
    {     
        List<Employees> aliens=new ArrayList<>();        
        String sql="select count(*), Title from employees group By Title;";
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                Employees a= new Employees();
                    a.setCount(rs.getInt(1));
                    a.setTitle(rs.getString(2));                
                aliens.add(a);
            }
        }        
        catch(SQLException e)          
        {
             System.out.println(e);          
        }       
        return aliens;
        
    }
//Reterving the data by using group by from city     
    public List<Employees> ShortedByCity() 
    {     
        List<Employees> aliens=new ArrayList<>();        
        String sql="select count(*), City from employees group By City;";
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                Employees a= new Employees();
                    a.setCount(rs.getInt(1));
                    a.setCity(rs.getString(2));                
                aliens.add(a);
            }
        }        
        catch(SQLException e)          
        {
             System.out.println(e);          
        }       
        return aliens;
        
    }

//    Retrving some specific data with phone number
    public List<Employees> SomeData() 
    {
        List<Employees> aliens=new ArrayList<>();        
        String sql="select employeeID, LastName, FirstName, HomePhone from Employees";
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                Employees a= new Employees();
                    a.setEmployeeID(rs.getInt(1));
                    a.setLastName(rs.getString(2));
                    a.setFirstName(rs.getString(3));
                    a.setHomePhone(rs.getString(4));
                aliens.add(a);
            }
        }        
        catch(SQLException e)          
        {
             System.out.println(e);          
        }       
        return aliens;
    }

//    Retrving the some data with specific id
    public Employees SomeDataWithId(int EmployeeID) {
        String sql="select employeeID, LastName, FirstName, HomePhone from Employees where EmployeeID="+EmployeeID;
        Employees a= new Employees();        
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                a.setEmployeeID(rs.getInt(1));
                a.setLastName(rs.getString(2));
                a.setFirstName(rs.getString(3));
                a.setHomePhone(rs.getString(4));		
            }
        }
        catch(SQLException e)          
        {
             System.out.println(e);
        }
        return a;
    }

//    retriving some speicifc data with lastname
    public Employees SomeDataWithLastName(String LastName) 
    {
        String sql="select employeeID, LastName, FirstName, HomePhone from Employees where LastName="+LastName;
        Employees a= new Employees();        
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                a.setEmployeeID(rs.getInt(1));
                a.setLastName(rs.getString(2));
                a.setFirstName(rs.getString(3));
                a.setHomePhone(rs.getString(4));		
            }
        }
        catch(SQLException e)          
        {
             System.out.println(e);
        }
        return a;
    }


//    passing parameter by using postman    
    public Employees PassingParameter(int EmployeeID) {
     
        String sql="select employeeID, LastName, FirstName, HomePhone from Employees where EmployeeID='"+EmployeeID+"'";
        Employees a= new Employees();        
        try
        {
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next())
            {
                a.setEmployeeID(rs.getInt(1));
                a.setLastName(rs.getString(2));
                a.setFirstName(rs.getString(3));
                a.setHomePhone(rs.getString(4));		
            }
        }
        catch(SQLException e)          
        {
             System.out.println(e);
        }
        return a;
    }
}