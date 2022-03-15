package com.yeahbutstill.catalog.service;

import com.yeahbutstill.catalog.domain.dao.Category;
import com.yeahbutstill.catalog.domain.dto.CategoryCreateUpdateRequestDTO;
import com.yeahbutstill.catalog.domain.dto.CategoryListResponseDTO;
import com.yeahbutstill.catalog.domain.dto.ResultPageResponseDTO;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto);

    ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages,
                                                                    Integer limit, String sortBy, String direction, String categoryName);

    List<Category> findCategories(List<String> categoryCodeList);

    List<CategoryListResponseDTO> constructDTO(List<Category> categories);

    Map<Long, List<String>> findCategoriesMap(List<Long> bookIdList);

}
