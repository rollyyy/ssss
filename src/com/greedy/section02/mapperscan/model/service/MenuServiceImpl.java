package com.greedy.section02.mapperscan.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.section02.mapperscan.model.dao.MenuDAO;
import com.greedy.section02.mapperscan.model.dto.MenuDTO;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	public MenuServiceImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MenuDTO> selectMenuList() {
		/* MenuDAO의 메소드 호출이 아닌 Mapper를 불러와서 메소드를 호출한다.
		 * 이 때 sqlSession을 전달할 필요가 없으며 MenuDAO 빈을 MenuService에서 주입 받을 필요도 없게 된다. */
		return sqlSession.getMapper(MenuDAO.class).selectMenuList();
	}


}








