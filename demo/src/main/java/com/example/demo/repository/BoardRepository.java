package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// DB처리에 대한 어노테이션(Conponent)
@Repository
//  BoardDataAccessObject(BoardDAO)
public class BoardRepository {
    static final Logger log = LoggerFactory.getLogger(BoardRepository.class);

    //  JdbcTemplate은 DB Query를 생성하는데 활용한다ㅏ.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws  Exception
    {
        log.info(("Repository create"));

        //  insert는 데이터를 입력한다.
        //  board는 create table로 만든 내용
        //  board에 있는 title, content, writer에
        //  특정값 3개를 삽입하기 위해 ?, ?, ?를 세팅한 상태
        String query = "insert into board (" + "title, content, writer) values(?, ?, ?)";
        //  아래 getter를 이용해서 ? 부분들의 값을 채운다.
        //  즉 물을표가 2개면 getter도 2개를 사용하면 된다.
        jdbcTemplate.update(query, board.getTitle(),
                board.getContent(), board.getWriter());
    }

    public List<Board> list() throws  Exception
    {
        log.info("Repository list");

        //  select는 값을 선태해오는 녀석이고 board샤싣 .. 등등은 board에 있는 정보들
        //  조건을 줄 때 where를 사용하낟.
        //  board_no가 0보다 크다는 조건을 가지고 있음
        //  order by는 정렬 조건에 해당한다.
        //  board_no
        List<Board> results = jdbcTemplate.query("select board_no, title, content, " +
                                                     "writer, reg_date from board " +
                                                     "where board_no > 0 order by " +
                                                     "board_no desc, reg_date desc",
        new RowMapper<Board>() {
            @Override
            public Board mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Board board = new Board();
                board.setBoardNo(rs.getInt("board_no"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setWriter(rs.getString("writer"));
                board.setReg_Date(rs.getDate("reg_date"));
                return board;
            }
        });
        return results;
    }

    public Board read(Integer boardNo) throws Exception
    {
        List<Board> results = jdbcTemplate.query(
                "select board_no, title, content, writer, " +
                        "reg_date from board where board_no = ?",
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setWriter(rs.getString("writer"));
                        board.setContent(rs.getString("content"));
                        board.setReg_Date(rs.getDate("reg_date"));
                        return board;
                    }
                }, boardNo
        );
        return results.isEmpty() ? null : results.get(0);
    }

    public void remove(Integer boardNo) throws Exception
    {
        String query = "delete from board where board_no = ?";
        jdbcTemplate.update(query, boardNo);
    }
}
