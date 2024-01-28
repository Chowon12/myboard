package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myboard.shop.dto.Comment;
import com.myboard.shop.dto.User;
import com.myboard.shop.service.BoardService;
import com.myboard.shop.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;
	private final BoardService boardService;

	@PostMapping(value = "/comment")
	public ResponseEntity<String> insertComment(@RequestBody Comment comment, HttpSession session) {
		String view = "error";
		User userSession = (User) session.getAttribute("user");
		comment.setUserId(userSession.getId());
		try {
			System.out.println(comment);
			
			boolean result = commentService.insertComment(comment);
			if(result) {
				return ResponseEntity.ok("삽입성공"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(500).body("삽입실패");
	}
	
	@RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteComment(@PathVariable("id") int id, HttpSession session) {
	    User user = (User) session.getAttribute("user");
	    if (user != null) {
	        try {
	            // 댓글을 삭제합니다.
	            boolean result = commentService.deleteComment(id);
	            if (result) {
	                return ResponseEntity.ok("댓글 삭제 성공");
	            } else {
	                return ResponseEntity.status(500).body("댓글 삭제 실패");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("댓글 삭제 실패");
	        }
	    }
	    return ResponseEntity.status(403).body("삭제 권한 없음");
	}
	
	@RequestMapping(value = "/comment/board/{fileNo}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCommentByBoardId(@PathVariable("fileNo") int fileNo) {
        try {
            boolean result = commentService.deleteCommentByBoardId(fileNo);
            if (result) {
                return ResponseEntity.ok("댓글 삭제 성공");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 삭제 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 삭제 실패");
        }
    }
	
}
