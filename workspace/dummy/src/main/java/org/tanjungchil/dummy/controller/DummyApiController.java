package org.tanjungchil.dummy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tanjungchil.dummy.dto.DummyRequestDto;
import org.tanjungchil.dummy.dto.DummyResponseDto;

import java.time.LocalDateTime;

@RestController
public class DummyApiController {


    @GetMapping(value = {"/api", "/api/*"})
    DummyResponseDto sendMessage(DummyRequestDto requestDto) {

        DummyResponseDto response = createResponse(requestDto.getQuery());

        return response;
    }


    DummyResponseDto createResponse(String query) {
        Boolean isFinished = (Math.random() < 0.2); // 0.8: continue, 0.2: finish

        DummyResponseDto ret;
        if (isFinished) {
            ret = DummyResponseDto.builder()
                    .isFinished(true)
                    .contentType("text")
                    .content("fin: from " + query + "\n")
                    .createdDate(LocalDateTime.now())
                    .build();
        } else {
            ret = DummyResponseDto.builder()
                    .isFinished(false)
                    .contentType("text")
                    .content("cont: from " + query + "\n")
                    .createdDate(LocalDateTime.now())
                    .build();
        }
        return ret;
    }
}
