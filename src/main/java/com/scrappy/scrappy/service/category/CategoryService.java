package com.scrappy.scrappy.service.category;

import com.scrappy.scrappy.controller.dto.category.CategoryCreateDTO;
import com.scrappy.scrappy.controller.dto.category.CategoryDTO;
import com.scrappy.scrappy.domain.CategoryEntity;
import com.scrappy.scrappy.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Transactional
    public CategoryDTO createCategory(CategoryCreateDTO createDTO, Long userId) {
        logger.debug("Creating category with DTO: {}, userId: {}", createDTO, userId);
        // Проверка прав (например, только админ)
        if (categoryRepository.findByName(createDTO.getName()).isPresent()) {
            throw new IllegalArgumentException("Category already exists: " + createDTO.getName());
        }
        CategoryEntity category = categoryMapper.toEntity(createDTO);
        CategoryEntity savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> getAllCategories(Long userId) {
        logger.debug("Fetching all categories for userId: {}", userId);
        // Возвращаем все категории, если это глобальные данные
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
}