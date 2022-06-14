package controller;

import exception.CategoryException;
import model.Product;
import model.ProductDTO;
import service.ProductDTOimp;
import service.ProductServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@WebServlet (name = "HomeController" ,urlPatterns = "/home")
public class HomeController extends HttpServlet {
    private ProductServiceImp productServiceImp = new ProductServiceImp();
    ;
    private ProductDTOimp productDTOimp = new ProductDTOimp();
    ;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateform(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "market":
                showMarket(req, resp);
                break;
            case "detail":
                showDetailProduct(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void showDetailProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductDTO productExist = productDTOimp.findById(id);
        List<ProductDTO> productList = productDTOimp.findAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/detailproduct.jsp");
        req.setAttribute("productExist", productExist);
        req.setAttribute("productList", productList);
        dispatcher.forward(req, resp);
    }


    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> productList = productDTOimp.findAll();
        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void showMarket(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> productList = productDTOimp.findAll();
        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/market.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product productExist = productServiceImp.findById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/edit.jsp");
        req.setAttribute("productExist", productExist);
        dispatcher.forward(req, resp);
    }

    private void showCreateform(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                doCreate(req, resp);
                break;
            case "edit":
                doEdit(req, resp);
                break;
//            case "market":
//                showMarket(req,resp);
//                break;
//            default:
//                showList(req,resp);
//                break;
        }

    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String name = req.getParameter("name");
            String image = req.getParameter("image");
            String title = req.getParameter("title");
            BigDecimal price = BigDecimal.valueOf(Integer.parseInt(req.getParameter("price")));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int size = Integer.parseInt(req.getParameter("size"));
            int category = Integer.parseInt(req.getParameter("category"));
            int status = Integer.parseInt(req.getParameter("status"));
            String description = req.getParameter("description");


            if (category < 1 || category > 4) {
                throw new CategoryException("Category is invalid");
            }
            Product newProduct = new Product(name, image, price, title, status, category, size, quantity, description);

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<Product>> constraintViolations = validator.validate(newProduct);
            if (!constraintViolations.isEmpty()) {
                String errors = "<ul>";
                for (ConstraintViolation<Product> constraintViolation : constraintViolations) {
                    errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
                            + "</li>";
                }
                errors += "</ul>";

                req.setAttribute("errors", errors);
                RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
                dispatcher.forward(req, resp);

            } else {
                productServiceImp.insert(newProduct);
                req.setAttribute("success", "Add product successful !");
                RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (NumberFormatException ex) {
            System.out.println(this.getClass() + " NumberFormatException");
            req.setAttribute("errors", "Format input not right");
            RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
            dispatcher.forward(req, resp);
            ex.printStackTrace();
        } catch (CategoryException cateEx) {
            System.out.println(this.getClass() + " " + cateEx.getMessage());
            req.setAttribute("errors", cateEx.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("errors", "Error while input...");
            RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
            dispatcher.forward(req, resp);
            e.printStackTrace();
        }


    }


    private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String image = req.getParameter("image");
            String title = req.getParameter("title");
            BigDecimal price = BigDecimal.valueOf(Integer.parseInt(req.getParameter("price")));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int size = Integer.parseInt(req.getParameter("size"));
            int category = Integer.parseInt(req.getParameter("category"));
            int status = Integer.parseInt(req.getParameter("status"));
            String description = req.getParameter("description");
            if (category < 1 || category > 4) {
                throw new CategoryException("Category is invalid");
            }
            Product productUpdated = new Product(id, name, image, price, title, status, category, size, quantity, description);
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<Product>> constraintViolations = validator.validate(productUpdated);
            if (!constraintViolations.isEmpty()) {
                String errors = "<ul>";
                for (ConstraintViolation<Product> constraintViolation : constraintViolations) {
                    errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
                            + "</li>";
                }
                errors += "</ul>";

                req.setAttribute("errors", errors);
                RequestDispatcher dispatcher = req.getRequestDispatcher("customer/edit.jsp");
                dispatcher.forward(req, resp);
            } else {
                productServiceImp.update(productUpdated);
                req.setAttribute("success", "Edit product successful !");
                RequestDispatcher dispatcher = req.getRequestDispatcher("customer/edit.jsp");
                dispatcher.forward(req, resp);
            }
        }
        catch(NumberFormatException ex){
            System.out.println(this.getClass() + " NumberFormatException");
            req.setAttribute("errors", "Format input not right");
            RequestDispatcher dispatcher = req.getRequestDispatcher("customer/edit.jsp");
            dispatcher.forward(req, resp);
            ex.printStackTrace();
        } catch(CategoryException cateEx){
            System.out.println(this.getClass() + " " + cateEx.getMessage());
            req.setAttribute("errors", cateEx.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("customer/edit.jsp");
            dispatcher.forward(req, resp);
        } catch(Exception e){
            req.setAttribute("errors", "Error while input...");
            RequestDispatcher dispatcher = req.getRequestDispatcher("customer/edit.jsp");
            dispatcher.forward(req, resp);
            e.printStackTrace();
        }

    }
}



