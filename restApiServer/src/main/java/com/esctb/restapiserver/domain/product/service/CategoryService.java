package com.esctb.restapiserver.domain.product.service;

import com.esctb.restapiserver.domain.product.dto.CategoryDto;
import com.esctb.restapiserver.domain.product.dto.CategoryDto.Response;
import com.esctb.restapiserver.domain.product.entity.Category;

import java.util.List;


public interface CategoryService {

    List<Response> findAllCategories();

    Response save(String name);
}
