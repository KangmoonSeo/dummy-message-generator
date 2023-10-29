package org.tanjungchil.dummy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tanjungchil.dummy.dto.DummyRequestDto;
import org.tanjungchil.dummy.dto.DummyResponseDto;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DummyApiControllerTest {


    @Autowired DummyApiController dummyApiController;
    @Test
    public void 메시지_반환() {
        // given
        DummyRequestDto requestDto = DummyRequestDto.builder()
                .query("hello")
                .build();

        // when
        DummyResponseDto responseDto = dummyApiController.sendMessage(requestDto);

        // then
        assertEquals(responseDto.getContentType(), "text");


    }
}