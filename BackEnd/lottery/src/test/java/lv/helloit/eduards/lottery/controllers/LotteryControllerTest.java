package lv.helloit.eduards.lottery.controllers;

import lv.helloit.eduards.lottery.DAOs.LotteryDAO;
import lv.helloit.eduards.lottery.DTOs.LotteryActionDTO;
import lv.helloit.eduards.lottery.enums.LotteryStatus;
import lv.helloit.eduards.lottery.mainObjects.Lottery;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.beans.PropertyEditor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
class LotteryControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private LotteryController lotteryController;

    @InjectMocks
    private LotteryDAO lotteryDAO;
    private LotteryActionDTO lotteryActionDTO;

    @BeforeClass
    void createLottery() throws Exception {
        Lottery l = new Lottery();
//        l.setId(100);
        l.setStatus(LotteryStatus.REGISTRATION_OPEN);
        l.setStartDate(LocalDateTime.now());
        l.setTitle("LotteryTest");
        l.setLimit(100l);
        lotteryDAO.save(l);

    }

    @Before
    void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(lotteryController).build();
    }


    @Test
    void startRegistrationTest() throws Exception {
        Lottery lottery = new Lottery();
        lottery.setTitle("LotteryTest1");
        lottery.setLimit(100l);

//        when(lotteryController.startRegistration(lottery).thenReturn(lotteryActionDTO));

        mockMvc.perform(MockMvcRequestBuilders.post("/start-registration")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is("OK")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is("1")));
    }

    @Test
    void stopRegistration() {
    }

    @Test
    void chooseWinner() {
    }

    @Test
    void showStatistics() {
    }
}