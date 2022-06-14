package service;

import model.Product;
import model.ProductDTO;
import utils.MySQLConUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDTOimp implements IProductDTOservice{
    private static final String FIND_ALL_PRODUCT3 ="CALL shoes_store.new_procedure();";
    private static final String VIEW ="SELECT * FROM shoes_store.new_view;";
    private static final String VIEW_BY_ID ="SELECT * FROM shoes_store.new_view WHERE id = ?;";
    private static final String FIND_PRODUCT_BY_ID ="SELECT id, name, image, price,title, statusId, categoryId, size, quantity, deleted, description FROM products WHERE id = ?;";
    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productList = new ArrayList<>();
        try (Connection connection = MySQLConUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(VIEW);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                BigDecimal price = resultSet.getBigDecimal("price");
                String title = resultSet.getString("title");
                String status = resultSet.getString("Status");
                String category = resultSet.getString("Category");
                int size = resultSet.getInt("size");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                productList.add(new ProductDTO(id,name,image,price,title,status,category,size,quantity,description));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }
    //    @Override
//    public List<ProductDTO> findAll() {
//        List<ProductDTO> productList = new ArrayList<>();
//        try (Connection connection = MySQLConUtil.getConnection();
//             CallableStatement callableStatement = connection.prepareCall(FIND_ALL_PRODUCT3);){
//            ResultSet resultSet = callableStatement.executeQuery();
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String image = resultSet.getString("image");
//                BigDecimal price = resultSet.getBigDecimal("price");
//                String title = resultSet.getString("title");
//                String status = resultSet.getString("Status");
//                String category = resultSet.getString("Category");
//                int size = resultSet.getInt("size");
//                int quantity = resultSet.getInt("quantity");
//
//                productList.add(new ProductDTO(id,name,image,price,title,status,category,size,quantity));
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return productList;
//    }

    @Override
    public ProductDTO findById(int id) {
        ProductDTO productDTO = null;
        try (Connection connection = MySQLConUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(VIEW_BY_ID);){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                BigDecimal price = resultSet.getBigDecimal("price");
                String title = resultSet.getString("title");
                String status = resultSet.getString("Status");
                String category = resultSet.getString("Category");
                int size = resultSet.getInt("size");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                productDTO = new ProductDTO(id1,name,image,price,title,status,category,size,quantity,description);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productDTO;
    }

    @Override
    public void save(ProductDTO productDTO) {

    }

    @Override
    public void insert(ProductDTO productDTO) {

    }

    @Override
    public boolean productExist(int id) {
        return findById(id) != null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ProductDTO productDTO) throws SQLException {
        return false;
    }
}
