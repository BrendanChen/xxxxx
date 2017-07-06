package com.spring.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.dao.RcpDAO_interface;
import com.spring.entity.RecipeVO;



@Service("rcpService")
@Transactional
public class RcpServiceImpl implements RcpService{
	
	@Autowired(required = true)
	@Qualifier("rcpDAO")
	private RcpDAO_interface rcpDAO;

	public List<RecipeVO> getAll() {
		return rcpDAO.getAll();
	}

	public void addRcpData(RecipeVO recipeVO) {
		rcpDAO.insert(recipeVO);
	}

	public void update(RecipeVO recipeVO) {
		rcpDAO.update(recipeVO);
	}

	public void delete(RecipeVO recipeVO) {
		rcpDAO.delete(recipeVO);
	}

	public RecipeVO findByPk(RecipeVO recipeVO) {
		return rcpDAO.findByPrimaryKey(recipeVO);
	}

	public List<RecipeVO> findByCriteria(Map<String, String[]> map) {
		return rcpDAO.findByCriteria(map);
	}
}
