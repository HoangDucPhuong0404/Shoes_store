package service;

import model.Category;
import model.Product;
import model.ProductDTO;
import utils.MySQLConUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImp implements IProductService{

    private static final String FIND_PRODUCT_BY_ID ="SELECT id, name, image, price,title, statusId, categoryId, size, quantity, deleted, description FROM products WHERE id = ?;";
    private static final String FIND_ALL_CATEGORY ="SELECT id, name FROM categories;";
    private static final String FIND_ALL_PRODUCT2 = "SELECT products.id,products.name,products.image, products.price,products.quantity,products.size,status.name AS `Status` ,products.title, categories.name AS `Category`  FROM products, categories, status WHERE products.categoryId = categories.id AND products.statusId = status.id AND products.deleted = 0;";
    private static final String FIND_ALL_PRODUCT3 ="CALL shoes_store.new_procedure();";

    private static final String FIND_ALL_PRODUCT = "SELECT id, name, image, price,title, statusId, categoryId, size, quantity, deleted FROM products;";
    private static final String ADD_PRODUCT = "INSERT INTO products (name, image, price, title, statusId, categoryId, size, quantity, description) VALUES (?,?,?,?,?,?,?,?,?);";
   private static final String UPDATE_PRODUCT ="UPDATE products SET name =?, image =?, price = ?, title = ?, statusId = ?, categoryId = ?, size = ?, quantity = ?, description = ? WHERE id = ?;";
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = MySQLConUtil.getConnection();
             CallableStatement callableStatement = connection.prepareCall(FIND_ALL_PRODUCT);){
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                BigDecimal price = resultSet.getBigDecimal("price");
                String title = resultSet.getString("title");
                int status = resultSet.getInt("statusId");
                int category = resultSet.getInt("categoryId");
                int size = resultSet.getInt("size");
                int quantity = resultSet.getInt("quantity");

                productList.add(new Product(id,name,image,price,title,status,category,size,quantity));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }
    public List<Category> findAllCAT(){
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = MySQLConUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CATEGORY);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categoryList.add(new Category(id,name));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public Product findById(int id) {
       Product product = null;
        try (Connection connection = MySQLConUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_ID);){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                BigDecimal price = resultSet.getBigDecimal("price");
                String title = resultSet.getString("title");
                int status = resultSet.getInt("statusId");
                int category = resultSet.getInt("categoryId");
                int size = resultSet.getInt("size");
                int quantity = resultSet.getInt("quantity");
                boolean deleted = resultSet.getBoolean("deleted");
                String description = resultSet.getString("description");
                product = new Product(id1,name,image,price,title,status,category,size,quantity,deleted,description);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void insert(Product product) {
        try (Connection connection = MySQLConUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT);){
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImage());
            preparedStatement.setBigDecimal(3, product.getPrice());
            preparedStatement.setString(4, product.getTitle());
            preparedStatement.setInt(5,product.getStatusId());
            preparedStatement.setInt(6,product.getCategoryId());
            preparedStatement.setInt(7,product.getSize());
            preparedStatement.setInt(8,product.getQuantity());
            preparedStatement.setString(9, product.getDescription());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
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
    public boolean update(Product product) throws SQLException {
        boolean productUpdated;
        try (Connection connection = MySQLConUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getImage());
            preparedStatement.setBigDecimal(3,product.getPrice());
            preparedStatement.setString(4,product.getTitle());
            preparedStatement.setInt(5,product.getStatusId());
            preparedStatement.setInt(6,product.getCategoryId());
            preparedStatement.setInt(7,product.getSize());
            preparedStatement.setInt(8,product.getQuantity());
            preparedStatement.setString(9,product.getDescription());
            preparedStatement.setInt(10,product.getId());
            productUpdated = preparedStatement.executeUpdate() > 0;
        }
        return productUpdated;
    }

}
