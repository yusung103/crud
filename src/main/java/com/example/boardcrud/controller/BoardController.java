package com.example.boardcrud.controller;

import com.example.boardcrud.dto.CreateBoardRequest;
import com.example.boardcrud.dto.CreateBoardResponse;
import com.example.boardcrud.dto.ReadAllBoardResponse;
import com.example.boardcrud.dto.ReadBoardResponse;
import com.example.boardcrud.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public CreateBoardResponse creatBoard(@Valid @RequestBody CreateBoardRequest createBoardRequest){
        return boardService.createBoard(createBoardRequest);
    }

    @GetMapping
    public List<ReadAllBoardResponse> readAllBoard(){
        return boardService.readAllBoard();
    }

    @GetMapping("{id}")
    public ReadBoardResponse readBoard(@PathVariable Integer id){
        return boardService.readBoard(id);
    }
}
