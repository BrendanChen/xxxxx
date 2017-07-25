package com.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.RecipeVO;

@Repository("rcpDAO")

public class RcpDAO implements RcpDAO_interface {

	@PersistenceContext
	private EntityManager entityManager;

	public List<RecipeVO> getAll() {

		CriteriaQuery<RecipeVO> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(RecipeVO.class);
		@SuppressWarnings("unused")
		Root<RecipeVO> root = criteriaQuery.from(RecipeVO.class);

		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Transactional
	public void insert(RecipeVO recipeVO) {
		entityManager.persist(recipeVO);
	}

	@Transactional
	public void update(RecipeVO recipeVO) {
		entityManager.merge(recipeVO);
	}

	@Transactional
	public void delete(RecipeVO recipeVO) {
		RecipeVO recipe = entityManager.find(RecipeVO.class, recipeVO.getRcpSeq());
		entityManager.remove(recipe);
	}
	
	@Transactional
	public RecipeVO findByPrimaryKey(RecipeVO recipeVO) {
		return entityManager.find(RecipeVO.class, recipeVO.getRcpSeq());
	}
	
	@Transactional
	public List<RecipeVO> findByCriteria(Map<String, String[]> map) {

		List<Predicate> predicates = new ArrayList<Predicate>();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<RecipeVO> criteria = criteriaBuilder.createQuery(RecipeVO.class);

		Root<RecipeVO> recipeRoot = criteria.from(RecipeVO.class);

		criteria.select(recipeRoot);

		Set<String> keys = map.keySet();

		int count = 0;

		for (String key : keys) {

			String value = map.get(key)[0];

			if (value != null && value.trim().length() != 0 && !"action".equals(key)) {

				count++;
				if (count == 1) {

					if (!key.equals("rName")) {

						Predicate predicate = criteriaBuilder.equal(recipeRoot.get(key), value.trim());
						predicates.add(predicate);

					} else {

						Predicate predicate = criteriaBuilder.like(recipeRoot.<String>get(key),
								"%" + value.trim() + "%");
						predicates.add(predicate);
					}

				} else if (count == 2 || count == 3) {

					if (!key.equals("rName")) {

						Predicate predicate = criteriaBuilder
								.and(criteriaBuilder.equal(recipeRoot.get(key), value.trim()));
						predicates.add(predicate);

					} else {

						Predicate predicate = criteriaBuilder.like(recipeRoot.<String>get(key),
								"%" + value.trim() + "%");
						predicates.add(predicate);
					}
				}
			}
		}
		criteria.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<RecipeVO> tq = entityManager.createQuery(criteria);

		List<RecipeVO> list = new ArrayList<RecipeVO>();

		list = tq.getResultList();

		return list;
	}

	public static void main(String[] args) {

		RcpDAO dao = new RcpDAO();
		List<RecipeVO> list = dao.getAll();

	}
}
