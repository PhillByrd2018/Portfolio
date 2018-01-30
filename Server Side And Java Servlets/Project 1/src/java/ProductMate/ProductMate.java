
package ProductMate;

import murach.business.Product;
import murach.data.ProductIO;



import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;


public class ProductMate extends HttpServlet {

    
    private static List<Product> products = null;
    
    
    public void init(){
        ProductIO.init(getServletContext()
                .getRealPath("/WEB-INF/products.txt"));
    
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           //removed code
        } finally {
            out.close();
        }
    }

    
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        
            
            
            
        
         //makes list and adds to request object
            products = ProductIO.selectProducts();
            request.setAttribute("ProductsList", products);
       
        
        if(action.equals("viewProducts")){
               products = ProductIO.selectProducts();
               request.setAttribute("ProductsList", products);
              
//            response.setContentType("text/HTML");
//            PrintWriter out = response.getWriter();
//            try{
//                out.println("<h1>we have found great success in ProductMate</h1>");
//            }
//            finally{
//                out.close();
//                
//            }
            //forward back to JSP
            String url = "/Display_Products.jsp";
            getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
            
            
//            RequestDispatcher rs = request.getRequestDispatcher(url);
//            rs.forward(request, response);
        }else if(action.equals("edit_Products")){
            
        
            request.setAttribute("code",code);
            request.setAttribute("description", description);
            request.setAttribute("price", price);
            
            String url = "/edit_Product.jsp";
            getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
      }
        else if(action.equals("delete_Product")){
           
            request.setAttribute("code",code);
            request.setAttribute("description", description);
            request.setAttribute("price", price);
            
            
            String url = "/confirm_product_delete.jsp";
            getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
      } 
        processRequest(request, response);
}
        

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        
    
        
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
         
        
          
        
        if(action.equals("updateProducts")){
            
          
            if(!code.equals("")&&!price.equals("")&&!description.equals("")){
            Product out = new Product();
            out.setCode(code);
            out.setDescription(description);
            out.setPrice(Double.parseDouble(price));
            ProductIO.updateProduct(out);
           /////////////////////////////////////////
            products = ProductIO.selectProducts();
            request.setAttribute("ProductsList", products);
            String url = "/Display_Products.jsp";
            getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
          }else{
            String errorMSG = "Please Fill out the form";
            request.setAttribute("MSG", errorMSG);
            request.setAttribute("code", code);
            
            String url = "/edit_Product.jsp";
            getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
             }
      } else if(action.equals("delete")){
          
            
          
          Product d_pro = ProductIO.selectProduct(code);
          
          ProductIO.deleteProduct(d_pro);
          
               products = ProductIO.selectProducts();
               request.setAttribute("ProductsList", products);
          String url = "/Display_Products.jsp";
          getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
          
          
      }else if(action.equals("add_product")){
          
          
          if(!code.equals("")&&!price.equals("")&&!description.equals("")){
            Product out = new Product();
            out.setCode(code);
            out.setDescription(description);
            out.setPrice(Double.parseDouble(price));
            ProductIO.insertProduct(out);
           /////////////////////////////////////////
            products = ProductIO.selectProducts();
            request.setAttribute("ProductsList", products);
            String url = "/Display_Products.jsp";
            getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
          }else{
            String errorMSG = "Please Fill out the form";
            request.setAttribute("MSG", errorMSG);
            String url = "/product.jsp";
            getServletConfig().getServletContext().getRequestDispatcher(url).forward(request, response);
          
          }
            
            
            
      }
        
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}