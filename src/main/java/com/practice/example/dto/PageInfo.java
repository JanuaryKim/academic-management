package com.practice.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class PageInfo {
    private int page;
    private int size;
    private long totalElement;
    private int totalPages;
}
