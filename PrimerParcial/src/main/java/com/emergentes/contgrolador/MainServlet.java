package com.emergentes.contgrolador;

import com.emergentes.modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException{
    
String op = request.getParameter("op");
Persona objper = new Persona();
int id, pos;
HttpSession ses = request.getSession();
ArrayList<Persona> lista = (ArrayList<Persona>)ses.getAttribute("listaper");


switch(op){
    case "nuevo":
        request.setAttribute("miobjper",objper);
        request.getRequestDispatcher("editar.jsp"). forward(request, response);
    break;
    case "editar":
        id=Integer.parseInt(request.getParameter("id"));
        pos = buscarPorIndice(request,id);
        objper = lista.get(pos);
        request.setAttribute("miobjper",objper);
        request.getRequestDispatcher("editar.jsp"). forward(request, response);
        
    break;
    case "eliminar":
        id=Integer.parseInt(request.getParameter("id"));
         pos = buscarPorIndice(request,id);
         if (pos >=0){
             lista.remove(pos);
         
             request.setAttribute ("listaper",lista);
             response.sendRedirect("index.jsp");
    break;
  
}
}
}

    public int buscarPorIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<Persona>lista = (ArrayList<Persona>) ses.getAttribute("listaper");
        
        int pos = -1;
        if(lista!=null){
        for(Persona ele: lista){
            ++pos;
                if(ele.getId() == id){
                    break;
                }
        }
        }
        return pos;
                
    }

    public int ObtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Persona>lista = (ArrayList<Persona>) ses.getAttribute("listaper");
        int idn =0;
        for(Persona ele : lista){
            idn = ele.getId();
        }
        return idn +1;
}    
    
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException{
    
    
    
    int id = Integer.parseInt(request.getParameter("id"));
    HttpSession ses= request.getSession();
    ArrayList<Persona>lista = (ArrayList<Persona>)ses.getAttribute("listaper");
    int pos = -1;
    Persona objper = new Persona();
    objper.setId(id);
    objper.setDescripcion(request.getParameter("descripcion"));
    objper.setCantidad(request.getParameter("cantidad"));
    objper.setPrecio(request.getParameter("precio"));
    objper.setCategoria(request.getParameter("categoria"));
    if (id == 0){
         int idNuevo = ObtenerId(request);
         objper.setId(idNuevo);
         lista.add(objper);
    }
    else{
        int post = buscarPorIndice(request, id);
        lista.set(pos, objper);
    }
    request.setAttribute("lista", id);
    response.sendRedirect("index.jsp");
    
       
}

}
    

