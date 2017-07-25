package com.spring.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.spring.entity.IngredientVO;
import com.spring.entity.RecipeVO;

@Repository("ingreDao")
@Transactional
public class IngreDAO implements IngreDAO_interface {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<IngredientVO> getAll() {
		return entityManager.createNativeQuery("select * from ingredient",IngredientVO.class).getResultList();
	}

	@Transactional
	public void insert(IngredientVO ingredientVO) {
		entityManager.persist(ingredientVO);
	}

	@Transactional
	public void update(IngredientVO ingredientVO) {
		entityManager.merge(ingredientVO);
	}

	@Transactional
	public void delete(IngredientVO ingredientVO) {
		ingredientVO = entityManager.find(IngredientVO.class, ingredientVO.getIngreNo());
		entityManager.remove(ingredientVO);
	}

	@Transactional
	public IngredientVO findByIngreNo(IngredientVO ingredientVO) {
		return entityManager.find(IngredientVO.class, ingredientVO.getIngreNo());
	}

	@Transactional
	public List<IngredientVO> findByRcpSeq(RecipeVO recipeVO) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<IngredientVO> criteria = criteriaBuilder.createQuery(IngredientVO.class);
		Root<IngredientVO> ingredientRoot = criteria.from(IngredientVO.class);

		criteria.select(ingredientRoot);

		Predicate predicate = criteriaBuilder.equal(ingredientRoot.get("rcpSeq"), recipeVO.getRcpSeq());

		criteria.where(predicate);

		List<IngredientVO> list = entityManager.createQuery(criteria).getResultList();

		return list;
	}

	@Transactional
	public List<IngredientVO> findByCriteria(Map<String, String[]> map) {
		return null;
	}

	@Transactional
	public List<Integer> findHowManyGroup(int rcpSeq) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Integer> criteria = criteriaBuilder.createQuery(Integer.class);

		Root<IngredientVO> ingredientRoot = criteria.from(IngredientVO.class);
		
		criteria.multiselect(ingredientRoot.get("groupNo"));

		Predicate predicate = criteriaBuilder.equal(ingredientRoot.get("rcpSeq"), rcpSeq);

		criteria.where(predicate);

		criteria.groupBy(ingredientRoot.get("groupNo"));

		return entityManager.createQuery(criteria).getResultList();
	}

	@Transactional
	public List<IngredientVO> findByPkGroupByGroupNo(int rcpSeq, int groupNo) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<IngredientVO> criteria = criteriaBuilder.createQuery(IngredientVO.class);

		Root<IngredientVO> ingredientRoot = criteria.from(IngredientVO.class);

		criteria.select(ingredientRoot);

		Predicate predicate = criteriaBuilder.equal(ingredientRoot.get("rcpSeq"), rcpSeq);

		Predicate predicate2 = criteriaBuilder.and(criteriaBuilder.equal(ingredientRoot.get("groupNo"), groupNo));

		criteria.where(predicate, predicate2);

		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	@Transactional
	public List<IngredientVO> findAllGroupByGroupNo(int rcpSeq) {
		
		Query query = entityManager.createNativeQuery("select COUNT(*) from ingredient where rcp_seq = :rcp_seq group by group_no order by group_no");
		query.setParameter("rcp_seq", rcpSeq);
		List<IngredientVO> list = (List<IngredientVO>)query.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<IngredientVO> findByGroupNo(int rcpSeq,int groupNo) {
		return entityManager.createNativeQuery("select * from ingredient where rcp_seq="+rcpSeq+" and GROUP_NO="+groupNo+"",IngredientVO.class).getResultList();
	}
}