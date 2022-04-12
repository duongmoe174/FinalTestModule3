package com.finaltest3.service;

import com.finaltest3.config.SingletonConnection;
import com.finaltest3.model.Category;
import com.finaltest3.model.Product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    Connection connection = SingletonConnection.getConnect();

    @Override
    public List<Product> selectAll() {
        List<Product> products = new ArrayList<>();
        String query = "{CALL selectAllProduct()}";
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String name = resultSet.getString("name_product");
                int number = resultSet.getInt("number");
                float price = resultSet.getFloat("price");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String nameCategory = resultSet.getString("name_category");
                Category category = new Category(nameCategory);
                Product product = new Product(id, name, price, number, color, description, category);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void insert(Product product) {
        String query = "{CALL insertNewProduct(?,?,?,?,?,?)}";
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, product.getName());
            callableStatement.setInt(2, product.getNumber());
            callableStatement.setFloat(3, product.getPrice());
            callableStatement.setString(4, product.getColor());
            callableStatement.setString(5, product.getDescription());
            callableStatement.setInt(6, product.getCategory().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getById(int id) {
        String query = "{CALL getProductById(?)}";
        Product product = null;
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int number = resultSet.getInt("number");
                float price = resultSet.getFloat("price");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                product = new Product(name, price, number, color, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowProduct;
        String query = "{CALL deleteProductById(?)}";
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            rowProduct = callableStatement.executeUpdate() > 0;
        }
        return rowProduct;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdate;
        String query = "{CALL updateProduct(?,?,?,?,?,?,?)}";
        try (CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1,  product.getId());
            callableStatement.setString(2, product.getName());
            callableStatement.setInt(3, product.getNumber());
            callableStatement.setFloat(4, product.getPrice());
            callableStatement.setString(5, product.getColor());
            callableStatement.setString(6, product.getDescription());
            callableStatement.setInt(7, product.getCategory().getId());
            rowUpdate = callableStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }
}
