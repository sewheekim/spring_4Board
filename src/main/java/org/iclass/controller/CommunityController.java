package org.iclass.controller;

import org.iclass.dto.CommunityDTO;
import org.iclass.dto.PageReqDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/community")
public class CommunityController {
	
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1")
			int page, String columns, String keyword) {
		
		return "community/list";
	}
	
	@GetMapping("/write")   //글쓰기 화면
	public String write(int page) {
		
		return "community/write";
	}
	
	@PostMapping("/write")  //글 저장 후 글 목록으로 url 이동
	public String write(CommunityDTO dto) {
		
		return "redirect:list";
	}
	
	@GetMapping("/modify")  //글수정 화면
	public String modify(int page) {
		
		return "community/modify";
	}
	
	@PostMapping("/modify")  //글 수정 저장 후 글 목록(또는 수정)으로 url 이동
	public String write(int page, CommunityDTO dto,Model model) {
		
//		return "redirect:list";
		return "redirect:modify";
	}
	
	
	@GetMapping("/read")
	public String read(int idx,int page, Model model) {
		
		return "community/read";
	}
	
	@PostMapping("/remove")    //글 삭제 후 글 목록으로 url 이동
	public String remove(int idx, int page) {
		
		return "redirect:list";
	}
	
	
}
