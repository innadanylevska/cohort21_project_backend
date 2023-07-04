package de.ait.gethelp.services.impl;

import de.ait.gethelp.dto.CardDto;
import de.ait.gethelp.dto.CardsPage;
import de.ait.gethelp.dto.NewProfileDto;
import de.ait.gethelp.dto.ProfileDto;
import de.ait.gethelp.models.User;
import de.ait.gethelp.repositories.CardsRepository;
import de.ait.gethelp.repositories.UsersRepository;
import jdk.jfr.Name;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {

    @Mock
    private UsersRepository usersRepository;
    @Mock
    private CardsRepository cardsRepository;
    @InjectMocks
    private UsersServiceImpl usersService;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {

//ProfileDto builder
        user1 = User.builder()
                .id(1L)
                .createdAt(LocalDateTime.now())
                .username("xx")
                .hashPassword("qwerty")
                .email("xx@xx.xx")
                .phone("063898391")
                .role(User.Role.USER)
                .isHelper(true)
                //.cards(null)
                .isBlocked(false)
                .build();
        user2 = User.builder()
                .id(2L)
                .createdAt(LocalDateTime.now())
                .username("xx")
                .hashPassword("qwerty")
                .email("xx@xx.xx")
                .phone("063898393")
                .role(User.Role.USER)
                .isHelper(false)
                //.cards(null)
                .isBlocked(false)
                .build();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProfile() {
        when(usersRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));
//        CardsPage cardsPage=CardsPage.builder()
//                .cards(new ArrayList<CardDto>())
//                .build();
        ProfileDto expectedProfile = ProfileDto.builder()
                .id(1L)
                .username("xx")
                .email("xx@xx.xx")
                .phone("063898391")
                .role("USER")
                .isHelper(true)
                //.cards(cardsPage)
                .build();

        ProfileDto userProfile = usersService.getProfile(1L);

        assertEquals(expectedProfile, userProfile);
    }

    @Name("Update Profile")
    @Test
    void editProfile() {

        when(usersRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));

        NewProfileDto newProfileDto = new NewProfileDto("inna@gmail.com", "11111");
        CardsPage cardsPage = CardsPage.builder()
                .cards(new ArrayList<CardDto>())
                .build();
        ProfileDto expected = ProfileDto.builder()
                .id(1L)
                .username("xx")
                .email("inna@gmail.com")
                .phone("11111")
                .role("USER")
                .isHelper(true)
                .build();

        ProfileDto actual = usersService.editProfile(1L, newProfileDto);

        assertEquals(expected, actual);

    }

    @Name("карточка принадлежит пользователю")
    @Test
    void editCardStatus() {
        when(usersRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));
        when(usersRepository.save(Mockito.any(User.class))).thenReturn(user1);

        CardDto savedProfile = usersService.editCardStatus(1L, 1L, true );
    }

    @Name("карточка не принадлежит пользователю")
    @Test
    void editCardStatus_is_userNoExists() {}

    @Name("Category  cardId  not found")//cards field absent null
    @Test
    void editCardStatus_is_categoryNotFound() {


        when(usersRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));
        when(usersRepository.save(Mockito.any(User.class))).thenReturn(user1);
//        CardsPage cardsPage=CardsPage.builder()
//                .cards(new ArrayList<CardDto>())
//                .build();
        ProfileDto profileDto = ProfileDto.builder()
                .id(1L)
                .username("xx")
                .email("xx@xx.xx")
                .phone("063898391")
                .role("USER")
                .isHelper(true)
                //.cards(cardsPage)
                .build();
        CardDto savedProfile = usersService.editCardStatus(1L, 1L, true );

    }/*
    @Test
    void getUserCards() {
        when(usersRepository.findById(1L)).thenReturn(Optional.ofNullable(user1));

        CardsPage cardsPage=CardsPage.builder()
                .cards(new ArrayList<CardDto>())
                .build();
        ProfileDto exp = ProfileDto.builder()
                .cards(cardsPage)
                .build();

        ProfileDto act = usersService.getUserCards(1L);
        assertEquals(exp,act);
    }
    */

}