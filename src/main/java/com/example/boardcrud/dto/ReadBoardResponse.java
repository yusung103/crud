package com.example.boardcrud.dto;

import com.example.boardcrud.entity.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReadBoardResponse {
    private String title;
    private String content;
    private String createdBy;

    public static ReadBoardResponse toDto(BoardEntity boardEntity){
        ReadBoardResponse response = new ReadBoardResponse();
        response.title = boardEntity.getTitle();
        response.content = boardEntity.getContent();
        response.createdBy = boardEntity.getCreatedBy();
        return response;
    }
}
