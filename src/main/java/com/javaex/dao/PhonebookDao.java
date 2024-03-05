package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private SqlSession sqlSession;
	
	//등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");
		
		return sqlSession.insert("phonebook.insert", personVo);
	}
	
	//리스트
	public List<PersonVo> personList(){
		System.out.println("PhonebookDao.personList()");

		List<PersonVo> personList = sqlSession.selectList("phonebook.select");
		
		return personList;
	}
	
	//삭제
	public int personDelete(int peronId) {
		System.out.println("PhonebookDao.personDelete()");
		
		return sqlSession.delete("phonebook.delete", peronId);
	}
	
	//수정폼 - 하나만 가져오기 
	public PersonVo personSelectOne(int personId) {
		
		return sqlSession.selectOne("phonebook.selectOne", personId);
	}
	
	//수정
	public int personModify(PersonVo personVo) {
		
		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count);
		return count;
	}
	
}
