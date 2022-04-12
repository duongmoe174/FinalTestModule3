package com.finaltest3.service;

import com.finaltest3.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
List<Product> selectAll ();
void insert (Product product);
Product getById (int id);
boolean delete (int id) throws SQLException;
boolean update (Product product) throws SQLException;
}
