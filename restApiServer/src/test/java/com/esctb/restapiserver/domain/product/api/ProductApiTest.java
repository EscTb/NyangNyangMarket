package com.esctb.restapiserver.domain.product.api;

import com.esctb.restapiserver.domain.product.dto.ProductDto;
import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.product.entity.ProductImage;
import com.esctb.restapiserver.domain.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductApi.class)
@DisplayName("ProductApi 테스트")
class ProductApiTest {
    private MockMvc mvc;
    @MockBean
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        mvc =
                MockMvcBuilders.standaloneSetup(new ProductApi(productService))
                        .addFilters(new CharacterEncodingFilter("UTF-8", true)) // utf-8 필터 추가
                        .build();
    }

    @Test
    void insertProductTest() throws Exception {

        //given
        List<ProductImage> productImages = new ArrayList<>();
        ProductImage image = ProductImage.builder().imageName("testImg").imagePath("testImgPath").build();
        productImages.add(image);
        Product product = Product.builder()
//                .id(1L)
                .title("test")
                .price(100)
                .viewCount(0)
                .content("content")
                .productImages(productImages)
                .build();
        given(productService.addProduct(any()))
                .willReturn(
                        ProductDto
                                .CreateResponse
                                .builder()
                                .build()
                                .toDto(product));

        //when
        final ResultActions actions = mvc.perform(
                post("/api/v1.0/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(
                                "{"
                                        + " \"title\":\"test\", "
                                        + " \"price\":100, "
                                        + " \"viewCount\":0, "
                                        + " \"content\": \"content\" "
                                        + "\"productImages\":[\n"
                                        + "    {\"imageName\":\"testImg\",\n"
                                        + "    \"imagePath\":\"testImgPath\"\n"
                                        + "    }\n"
                                        + "]"
                                        + "}"
                        ));
        actions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("title").value("test"))
                .andExpect(jsonPath("price").value(100))
                .andExpect(jsonPath("viewCount").value(0))
                .andExpect(jsonPath("content").value("content"));
    }
}