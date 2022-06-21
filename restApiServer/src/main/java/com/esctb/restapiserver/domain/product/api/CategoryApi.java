package com.esctb.restapiserver.domain.product.api;

import com.esctb.restapiserver.domain.product.dto.CategoryDto.Response;
import com.esctb.restapiserver.domain.product.entity.Category;
import com.esctb.restapiserver.domain.product.service.CategoryService;
import com.esctb.restapiserver.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@ResponseBody
@RequiredArgsConstructor
@Controller
@RequestMapping("api/v1.0/category")
public class CategoryApi {

    private final CategoryService categoryService;

    /**
     * 카테고리 등록
     */
    @PostMapping("{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Response> createCategory(@PathVariable String name) {
        Response result = categoryService.save(name);
        return ApiResponse.createSuccess(result);
    }

    /**
     * 모든 카테고리 조회
     */
    @GetMapping
    public ApiResponse<List<Response>> readCategories() {
        return ApiResponse.createSuccess(categoryService.findAllCategories());
    }
}
