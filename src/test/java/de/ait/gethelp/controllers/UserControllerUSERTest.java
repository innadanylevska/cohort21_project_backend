package de.ait.gethelp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ait.gethelp.security.config.TestConfig;
import de.ait.gethelp.models.Card;
import de.ait.gethelp.models.User;
import de.ait.gethelp.repositories.CardsRepository;
import de.ait.gethelp.repositories.CategoriesRepository;
import de.ait.gethelp.repositories.SubCategoriesRepository;
import de.ait.gethelp.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.Optional;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = TestConfig.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerUSERTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private static final String END_POINT_PATH = "/api/users";
    //@MockBean
    //private final UsersServiceImpl usersService;
    @MockBean
    private UsersRepository usersRepository;
    @MockBean
    private CardsRepository cardsRepository;
    @MockBean
    private CategoriesRepository categoriesRepository;
    @MockBean
    private SubCategoriesRepository subCategoriesRepository;

    @BeforeEach
    void setUp() {
        when(usersRepository.findById(1L)).thenReturn(
                Optional.of(User.builder()
                        .id(1L)
                        .role(User.Role.USER)
                        .email("jack")
                        .build()));
        when(cardsRepository.findAllByUser_Id(1l)).thenReturn(
                new ArrayList<Card>()
        );

    }


    @WithUserDetails(value = "jack")
    @Test
    @DisplayName("Get User Profile")
    void getProfileUser() throws Exception {


        mockMvc
                .perform((RequestBuilder) get("/api/users/my/profile")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.email", is("jack")))
                .andExpect(jsonPath("$.role", is("USER")));
    }


}
