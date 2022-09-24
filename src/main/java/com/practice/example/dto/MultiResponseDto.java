package com.practice.example.dto;

import lombok.*;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MultiResponseDto <T> {

    private List<T> data;
    private PageInfo pageInfo;

    public MultiResponseDto(List<T> data, Page page) {
        this.data = data;
        PageInfo pageInfo = PageInfo.builder().page(page.getPageable().getPageNumber()).size(page.getSize()).
                totalPages(page.getTotalPages()).totalElement(page.getTotalElements()).build();
        this.pageInfo = pageInfo;
    }
}
