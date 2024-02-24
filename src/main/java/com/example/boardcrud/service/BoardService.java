package com.example.boardcrud.service;


import com.example.boardcrud.dto.CreateBoardRequest;
import com.example.boardcrud.dto.CreateBoardResponse;
import com.example.boardcrud.dto.ReadAllBoardResponse;
import com.example.boardcrud.dto.ReadBoardResponse;
import com.example.boardcrud.entity.BoardEntity;
import com.example.boardcrud.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // 생성자 주입
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public CreateBoardResponse createBoard(CreateBoardRequest createBoardRequest){
        BoardEntity board = new BoardEntity(createBoardRequest);
        boardRepository.save(board);
        return CreateBoardResponse.toDto(board);
    }

    public List<ReadAllBoardResponse> readAllBoard(){
        return boardRepository.findAll().stream()
                .map(ReadAllBoardResponse::new)
                .collect(Collectors.toList());
    }

    public ReadBoardResponse readBoard(Integer id){
        BoardEntity board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return ReadBoardResponse.toDto(board);
    }
}
