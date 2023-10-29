package org.tanjungchil.dummy.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Builder
@RequiredArgsConstructor
@Getter
public class DummyResponseDto {
    private final Boolean isFinished;
    private final String contentType;
    private final String content;
    private final LocalDateTime createdDate;
}
