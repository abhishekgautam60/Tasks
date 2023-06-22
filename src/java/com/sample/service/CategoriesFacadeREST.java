/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sample.service;


import com.sample.Categories;
import com.sample.Employees;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Abhishek.Gautam
 */
@Path("allAliens")
public class CategoriesFacadeREST{

    AbstractFacade repo=new AbstractFacade();
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categories> getAliens() 
    {
           System.out.println("starting.........");
           return repo.getAliens();     
    }
    
    @GET
    @Path("alien/{categoryID}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Categories getAlien(@PathParam("categoryID") int categoryID)
    {	
        System.out.println("starting.........");
        return repo.getAlien(categoryID);
    }
    
//    @GET
//    @Path("alien1")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Categories getAlien(int categoryID)
//    {	
//        System.out.println("starting.........");
//        return repo.getAlien(categoryID);
//    }
    
//    @POST
//  
//    @Path("alien")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Categories create(Categories a1)
//    {
//        System.out.println(a1);
//        repo.create(a1);
//        return a1;
//    }
    @POST
    @Path("alien")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Categories a1) {
        repo.create(a1);
              

    }
}
