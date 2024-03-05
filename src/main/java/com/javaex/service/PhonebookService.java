package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	//등록
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");
		System.out.println(personVo);
		
		int count = phonebookDao.personInsert(personVo);
		return count;
	}
	
	//리스트
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");
		
		List<PersonVo> personList = phonebookDao.personList();
		
		return personList;
	}
	
	//삭제
	public int exeDelete(int personId) {
		System.out.println("PhonebookService.exeDelete()");
		
		return phonebookDao.personDelete(personId);
	}
	
	//수정폼: 하나만 가져오기
	public PersonVo exeSelectOne(int personId) {
		
		return phonebookDao.personSelectOne(personId);
	}
	
	//수정 
	public int exeModify(PersonVo personVo) {
		
		return phonebookDao.personModify(personVo);
	}
}
