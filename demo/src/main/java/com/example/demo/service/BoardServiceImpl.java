package com.example.demo.service;

import com.example.demo.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.BoardRepository;

import java.util.List;

//  클리스 implements 인터페이스
//  Service  어노테이션이 붙음
//  Spring <<- Event Driven 방식으로 동작하고 있음(의존성중 하나로 관리함)
@Service
public class BoardServiceImpl implements BoardService {
    //  클래스 사용할 때 객체가 필요하다.
    //  new를 해야 한다는 의미
    //  Autowired가 붙으면 이것을 자동으로 해줌
    @Autowired
    private BoardRepository boardRepository;

    //
    @Override
    public void register(Board board) throws Exception {
        boardRepository.create(board);
    }

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.list();
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return boardRepository.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        boardRepository.remove(boardNo);
    }

    @Override
    public void modify(Board boardNo) throws Exception {
        boardRepository.modify(boardNo);
    }
}
