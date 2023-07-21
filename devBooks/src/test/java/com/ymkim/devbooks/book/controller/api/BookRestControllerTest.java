package com.ymkim.devbooks.book.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymkim.devbooks.book.domain.dto.request.CreateBookRequestDto;
import com.ymkim.devbooks.book.domain.entity.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@Transactional
@SpringBootTest
@ActiveProfiles("test")
class BookRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("BOOK 생성 테스트")
    void test() throws Exception {
        // given
        CreateBookRequestDto bookRequestDto = new CreateBookRequestDto("TestController-Title",
                "Test-Author",
                Category.FICTION,
                1000L,
                LocalDate.now());

        // when, then
        mockMvc.perform(post("/api/v1/books")
                    .content(objectMapper.writeValueAsString(bookRequestDto))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }
}