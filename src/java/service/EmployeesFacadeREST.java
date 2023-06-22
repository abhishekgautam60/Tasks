/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.sample.Employees;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Abhishek.Gautam
 */

@Path("AllData")
public class EmployeesFacadeREST {
    Facade repo=new Facade();
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employees> findAll() 
    {
           System.out.println("starting.........");
           return repo.findAll();     
    }

    @GET
    @Path("/empid/{EmployeeID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Employees find(@PathParam("EmployeeID") int EmployeeID) {
        return repo.find(EmployeeID);
    }
    
    @GET
    @Path("SpecificData")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employees> findSpecificData() 
    {
           System.out.println("starting.........");
           return repo.findSpecificData();     
    }
    
    @GET
    @Path("Ln/{LastName}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Employees findByLastName(@PathParam("LastName") String LastName) 
    {
        return repo.findByLastName(LastName);
    }
    
    @GET
    @Path("ShortingTitle")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employees> ShortingTitle() 
    {
           System.out.println("starting.........");
           return repo.ShortingTitle();     
    }
    
    @GET
    @Path("ShortedByCity")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employees> ShortedByCity() 
    {
           System.out.println("starting.........");
           return repo.ShortedByCity();     
    }
    
    @GET
    @Path("SomeData")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Employees> SomeData() 
    {
           System.out.println("starting.........");
           return repo.SomeData();     
    }   
    
    @GET
    @Path("SomeData/{EmployeeID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Employees SomeDataWithId(@PathParam("EmployeeID") int EmployeeID) 
    {
           System.out.println("starting.........");
           return repo.SomeDataWithId(EmployeeID);     
    }
    
    @GET
    @Path("SomeData/Ln/{LastName}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Employees SomeDataWithLastName(@PathParam("LastName") String LastName) 
    {
           System.out.println("starting.........");
           return repo.SomeDataWithLastName(LastName);     
    }
    
//    passing parameter by using postman
    @GET
    @Path("PassingParameter")
    @Produces(MediaType.APPLICATION_JSON)
    public Employees PassingParameter(@PathParam("EmployeeID") int EmployeeID) 
    {
           System.out.println("starting.........");
           return repo.PassingParameter(EmployeeID);     
    }
   
}