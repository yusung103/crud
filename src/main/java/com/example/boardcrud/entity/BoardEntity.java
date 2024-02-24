package com.example.boardcrud.entity;

import com.example.boardcrud.dto.CreateBoardRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curd_board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;
    private String title;
    private String createdBy;

    public BoardEntity(CreateBoardRequest createBoardRequest){
        this.title=createBoardRequest.getTitle();
        this.content=createBoardRequest.getContent();
        this.createdBy=createBoardRequest.getCreatedBy();
    }
}
