package com.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.dao.IngreDAO_interface;
import com.spring.entity.IngredientVO;
import com.spring.entity.RecipeVO;

@Service("ingreService")
public class IngreServiceImpl implements IngreService {

	@Autowired(required = true)
	@Qualifier("ingreDao")
	private IngreDAO_interface ingreDao;

	public IngredientVO findByIngreNo(IngredientVO ingredientVO) {
		return ingreDao.findByIngreNo(ingredientVO);
	}

	public List<IngredientVO> getAll() {
		return ingreDao.getAll();
	}

	public void addRcpData(IngredientVO ingredientVO) {
		ingreDao.insert(ingredientVO);
	}

	public void update(IngredientVO ingredientVO) {
		ingreDao.update(ingredientVO);
	}

	public void delete(IngredientVO ingredientVO) {
		ingreDao.delete(ingredientVO);
	}

	public List<IngredientVO> findByRcpSeq(RecipeVO recipeVO) {
		return ingreDao.findByRcpSeq(recipeVO);
	}

	public List<RecipeVO> findByCriteria(Map<String, String[]> map) {
		return null;
	}

	public List<Integer> findHowManyGroup(int rcpSeq) {
		return ingreDao.findHowManyGroup(rcpSeq);
	}

	public List<IngredientVO> findByPkGroupByGroupNo(int rcpSeq, int groupNo) {
		return ingreDao.findByPkGroupByGroupNo(rcpSeq, groupNo);
	}

	@Override
	public List<IngredientVO> findAllGroupByGroupNo(int rcpSeq) {
		return ingreDao.findAllGroupByGroupNo(rcpSeq);
	}

	@Override
	public List<IngredientVO> findByGroupNo(int rcpSeq, int groupNo) {
		return ingreDao.findByGroupNo(rcpSeq, groupNo);
	}
}
