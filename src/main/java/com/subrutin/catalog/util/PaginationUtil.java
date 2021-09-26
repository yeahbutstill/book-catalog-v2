package com.subrutin.catalog.util;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.subrutin.catalog.dto.ResultPageDTO;

public class PaginationUtil {

	public static  <T> ResultPageDTO<T> createResultPageDTO(List<T> dtos, Long totalElements, Integer pages) {
        ResultPageDTO<T> result = new ResultPageDTO<T>();
        result.setElements(totalElements);
        result.setPages(pages);
        result.setResult(dtos);
		return result;

	}
	
	public static Sort.Direction getSortBy(String sortBy) {
        if (sortBy.equalsIgnoreCase("asc")) {
            return Sort.Direction.ASC;
        } else {
            return Sort.Direction.DESC;
        }
    }


}
