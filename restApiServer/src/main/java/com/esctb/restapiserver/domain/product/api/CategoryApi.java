package com.esctb.restapiserver.domain.product.api;

import com.esctb.restapiserver.domain.product.dto.CategoryDto.Detail;
import com.esctb.restapiserver.domain.product.entity.Category;
import com.esctb.restapiserver.domain.product.repository.CategoryRepository;
import com.esctb.restapiserver.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@ResponseBody
@RequiredArgsConstructor
@Controller
@RequestMapping("api/v1.0/category")
public class CategoryApi {

    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 등록
     */
    @PostMapping("{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Detail> createCategory(@PathVariable String name) {
        Category build = Category.builder().name(name).build();

        Category response = categoryRepository.save(build);
        Detail detail = Detail.builder().build().toDto(response);
        return ApiResponse.createSuccess(detail);
    }
}
