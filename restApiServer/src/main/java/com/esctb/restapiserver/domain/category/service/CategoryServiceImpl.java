package com.esctb.restapiserver.domain.category.service;

import com.esctb.restapiserver.domain.category.dto.CategoryDto;
import com.esctb.restapiserver.domain.category.dto.CategoryDto.Response;
import com.esctb.restapiserver.domain.category.entity.Category;
import com.esctb.restapiserver.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Response> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<Response> result = categories.stream()
                .map(category -> Response.builder().build().toDto(category))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public Response save(String name) {
        Category saved = categoryRepository.save(Category.builder().name(name).build());
        return CategoryDto.Response.builder().build().toDto(saved);
    }
}
