package com.yeahbutstill.catalog.repository;

import com.yeahbutstill.catalog.domain.dao.Category;
import com.yeahbutstill.catalog.domain.dto.CategoryQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    public Optional<Category> findByCode(String code);

    public Page<Category> findByNameLikeIgnoreCase(String categoryName, Pageable pageable);

    public List<Category> findByCodeIn(List<String> codes);

    @Query("SELECT new com.yeahbutstill.catalog.domain.dto.CategoryQueryDTO(b.id, bc.code) "
            + "FROM Book b "
            + "JOIN b.categories bc "
            + "WHERE b.id IN :bookIdList")
    public List<CategoryQueryDTO> findCategoryByBookIdList(List<Long> bookIdList);

}
