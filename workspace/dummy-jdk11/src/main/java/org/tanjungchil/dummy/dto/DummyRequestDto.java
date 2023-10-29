package org.tanjungchil.dummy.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class DummyRequestDto {
    private final String query;
}
