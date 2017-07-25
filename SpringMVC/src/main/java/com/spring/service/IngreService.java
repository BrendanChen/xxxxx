package com.spring.service;

import java.util.List;
import java.util.Map;

import com.spring.entity.IngredientVO;
import com.spring.entity.RecipeVO;


public interface IngreService {
	
	public IngredientVO findByIngreNo(IngredientVO ingredientVO);
	
	public List<IngredientVO> getAll();
	
	public void addRcpData(IngredientVO ingredientVO);
	
	public void update(IngredientVO ingredientVO);
	
	public void delete(IngredientVO ingredientVO);
	
	public List<IngredientVO> findByRcpSeq(RecipeVO recipeVO);
	
	public List<RecipeVO> findByCriteria(Map<String,String[]> map);
	
	public List<Integer> findHowManyGroup(int rcpSeq);
	
	public List<IngredientVO> findByPkGroupByGroupNo(int rcpSeq,int groupNo);
	
	public List<IngredientVO> findAllGroupByGroupNo(int rcpSeq); 
	
	public List<IngredientVO> findByGroupNo(int rcpSeq,int groupNo);
}
