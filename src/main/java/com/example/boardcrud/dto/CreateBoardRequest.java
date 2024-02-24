package com.example.boardcrud.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBoardRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String createdBy;
}
