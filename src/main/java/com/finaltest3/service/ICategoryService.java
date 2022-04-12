package com.finaltest3.service;

import com.finaltest3.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getById (int id);
    List<Category> selectAll ();
}
