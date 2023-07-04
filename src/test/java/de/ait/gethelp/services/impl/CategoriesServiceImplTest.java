package de.ait.gethelp.services.impl;

import de.ait.gethelp.dto.CategoryDto;
import de.ait.gethelp.dto.NewCategoryDto;
import de.ait.gethelp.models.Category;
import de.ait.gethelp.repositories.CategoriesRepository;
import jdk.jfr.Name;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoriesServiceImplTest {
    @Mock
    private CategoriesRepository categoriesRepository;

    @InjectMocks
    private CategoriesServiceImpl categoriesService;

    private Category expected;
    private Category category1;
    private Category category2;


    @BeforeEach
    void setUp() {
        LocalDateTime time = LocalDateTime.now();
        Category expected = Category.builder()
                .id(1L)
                .title("cars")
                .description("cars cars")
                .createdAt(time)
                .subCategory(null)
                .cards(null)
                .build();

        category1 = Category.builder()
                .id(null)
                .title("cars")
                .description("cars cars")
                .build();


        category2 = Category.builder()
                .id(2L)
                .title("car")
                .description("car cars")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Name("Add Category with reported bug")
    @Test
    void addCategory() {


        when(categoriesRepository.save(any())).thenReturn(expected);

        CategoryDto exp = CategoryDto.builder()
                .id(1L)
                .title("cars")
                .description("cars cars")
                .build();

        NewCategoryDto newCategoryDto = new NewCategoryDto("cars", "cars cars");


        CategoryDto act = categoriesService.addCategory(newCategoryDto);

        assertEquals(exp, act);
    }

    @Test
    void editCategory() {
    }
}