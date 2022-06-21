package com.esctb.restapiserver.domain.category.service;

import com.esctb.restapiserver.domain.category.dto.CategoryDto.Response;

import java.util.List;


public interface CategoryService {

    List<Response> findAllCategories();

    Response save(String name);
}
