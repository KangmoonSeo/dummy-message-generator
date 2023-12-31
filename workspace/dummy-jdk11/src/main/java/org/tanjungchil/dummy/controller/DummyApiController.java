package org.tanjungchil.dummy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tanjungchil.dummy.dto.DummyRequestDto;
import org.tanjungchil.dummy.dto.DummyResponseDto;

import java.time.LocalDateTime;

@RestController
public class DummyApiController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/upload")
    String upload() throws InterruptedException {

        Thread.sleep(2000 + Math.round(Math.random() * 2000));
        return "upload completed";
    }
    @RequestMapping("/embed")
    String embed() throws InterruptedException {

        Thread.sleep(8000 + Math.round(Math.random() * 2000));
        return "embed completed";
    }


    @RequestMapping(value = {"/query", "/query/*"})
    DummyResponseDto sendMessage(DummyRequestDto requestDto) throws InterruptedException {

        DummyResponseDto response = createResponse(requestDto.getQuery());
        Thread.sleep(2000 + Math.round(Math.random() * 2000));
        return response;
    }


    DummyResponseDto createResponse(String query) {
        Boolean isFinished = (Math.random() < 0.3); // 0.7: continue, 0.3: finish

        DummyResponseDto ret;
        if (isFinished) {
            ret = DummyResponseDto.builder()
                    .isFinished(true)
                    .contentType("text")
                    .content("[last content] from " + query + "\n")
                    .createdDate(LocalDateTime.now())
                    .build();
        } else {
            ret = DummyResponseDto.builder()
                    .isFinished(false)
                    .contentType("text")
                    .content("[content] from " + query + "\n")
                    .createdDate(LocalDateTime.now())
                    .build();
        }
        log.info(ret.getContent());
        return ret;
    }
}
