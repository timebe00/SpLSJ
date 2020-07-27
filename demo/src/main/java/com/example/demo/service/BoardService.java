package com.example.demo.service;

import com.example.demo.entity.Board;

import java.util.List;

//  다양성을 추구하기 위해서
//  각가의 이름을 통일하면서 사용 방식은 다르게 사용
//  데이터 처리의 일관성을 제공해 줄 수 있다.
public interface BoardService {
    //  DB처리할 때 오류가 발색할 수 있으므로
    //
    public void register(Board board) throws Exception;
    public List<Board> list() throws  Exception;
    public Board read(Integer boardNo) throws Exception;
    public void remove(Integer boardNo) throws Exception;
}
