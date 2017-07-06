package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.StepVO;

@Repository("stepDAO")
@Transactional
public class StepDAO implements StepDAO_interface {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<StepVO> getAll() {
		return null;
	}
	
	@Transactional
	public void insert(StepVO stepVO) {

	}
	
	@Transactional
	public void update(StepVO stepVO) {

	}
	
	@Transactional
	public void delete(StepVO stepVO) {

	}
	
	@Transactional
	public List<StepVO> findByPrimaryKey(int rcpSeq) {

		CriteriaQuery<StepVO> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(StepVO.class);
		criteriaQuery.from(StepVO.class);
		List<StepVO> list = entityManager.createQuery(criteriaQuery).getResultList();
		return list;
	}
}
