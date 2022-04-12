package com.greedy.section02.mapperscan.run;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.greedy.section02.mapperscan.model.dto.MenuDTO;
import com.greedy.section02.mapperscan.model.service.MenuService;

public class Application {

	public static void main(String[] args) {
		
		/* 마이바티스 스프링의 매퍼 스캔 기법을 이용한 처리
		 * 최근 마이바티스를 이용한 설정 중 많이 사용하는 설정
		 * */
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section02/mapperscan/config/spring-context.xml");
		
		System.out.println("전체 메뉴 조회하기");
		
		MenuService menuService = context.getBean("menuService", MenuService.class);
		
		List<MenuDTO> menuList = menuService.selectMenuList();
		for(MenuDTO menu : menuList) {
			System.out.println(menu);
		}
		
		
	}

}
