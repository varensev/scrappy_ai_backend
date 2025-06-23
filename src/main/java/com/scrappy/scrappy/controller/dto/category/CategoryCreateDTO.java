package com.scrappy.scrappy.controller.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryCreateDTO {
    @NotBlank(message = "Category name is required")
    private String name;
}