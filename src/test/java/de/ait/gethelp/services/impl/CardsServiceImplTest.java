package de.ait.gethelp.services.impl;

import de.ait.gethelp.dto.*;
import de.ait.gethelp.models.Card;
import de.ait.gethelp.models.Category;
import de.ait.gethelp.repositories.CardsRepository;
import de.ait.gethelp.repositories.CategoriesRepository;
import de.ait.gethelp.repositories.SubCategoriesRepository;
import de.ait.gethelp.repositories.UsersRepository;
import de.ait.gethelp.services.CardsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardsServiceImplTest {

    @Mock
    private CardsRepository cardsRepository;
    @Mock
    private CategoriesRepository categoriesRepository;
    @Mock
    private SubCategoriesRepository subCategoriesRepository;
    @Mock
    private UsersRepository usersRepository;
    @InjectMocks
    private CardsServiceImpl cardsService;

    private Card expected;
    private Card card1;
    private Card card2;
    private Card card3;
    @BeforeEach
    void setUp() {

        LocalDateTime time = LocalDateTime.now();
        expected = Card.builder()
                .id(1L)
                .title("smth")
                .description("smth")
                .createdAt(time)
                .user(null)
                .price(33.33)
                .isActive(true)
                .subcategory(null)
                .fullDescription("smth")
                .category(null)
                .build();

        card1 = Card.builder()
                .id(1L)
                .user(null)
                .title("smth")
                .category(null)
                .subcategory(null)
                .price(33.33)
                .description("smth")
                .fullDescription("smth")
                .isActive(true)
                .build();
//null,"smth",null,null,33.33,"smth","smth",true);


        card2 = Card.builder()
                .id(null)
                .user(null)
                .title("smth")
                .category(null)
                .subcategory(null)
                .price(33.33)
                .description("smth")
                .fullDescription("smth")
                .isActive(true)
                .build();

        card3 = Card.builder()
                .id(3L)
                .user(null)
                .title("smth ")
                .category(null)
                .subcategory(null)
                .price(33.33)
                .description("smth")
                .fullDescription("smth")
                .isActive(true)
                .build();
    }


    @AfterEach
    void tearDown() {

    }
/*
    @Test
    void getAll() {
        // Create a list of cards for testing
        List<Card> cards = List.of(card1,card2);


        // Mock the behavior of the cardsRepository to return the list of cards
        Mockito.when(cardsRepository.findAll()).thenReturn(cards);
        CardsPage all = categoriesService.getAll();
        // Create an instance of the CardsService using the mocked repository
        CardsService cardsService = new CardsServiceImpl(cardsRepository);

        // Call the getAll method
        List<CardDto> allCards = cardsService.getAll();

        // Assert that the returned list of CardDto matches the expected size
        assertEquals(cards.size(), allCards.size());

    }
*/
 /*   @Test
    void getById() {

        when(cardsRepository.findById(1L)).thenReturn(Optional.of(card1));
        CardDto actual = cardsService.getById(1L);//static

        UserDto userDto=UserDto.builder()
                .username(String.valueOf(new UserDto()))
                .build();
        CardDto expected = CardDto.builder()
                .id(1L)
                .user(userDto)
                .title("smth smth")
                .category(null)//categoriesPage)
                .subCategory(null)//subCategoriesPage)
                .price(33.33)
                .description("smth")
                .fullDescription("smth smth smth")
                .isActive(false)
                .build();
        assertEquals(actual,expected);
    }*/
/*
    @Test
    void addCard() {
        //lenient().when(categoriesRepository.save(category)).thenReturn(expected);
        when(cardsRepository.save(any())).thenReturn(expected);

        CardDto exp = CardDto.builder()
                .id(1L)
                //.createdAt(LocalDateTime.now())
                .user(null)
                .title("smth")
                .category(null)
                .subCategory(null)
                .price(33.33)
                .description("smth")
                .fullDescription("smth")
                .isActive(true)
                .build();




        NewCardDto newCardDto = new NewCardDto(null,"smth",null,null,33.33,"smth","smth",true);


        CardDto act = cardsService.addCard(newCardDto);

        assertEquals(exp, act);
    }
*/
    @Test
    void editCard() {
    }

    @Test
    void deleteCard() {
    }
}