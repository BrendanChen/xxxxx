package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

		Query query = entityManager.createNativeQuery("select * from step where rcp_seq= :rcp_seq",StepVO.class);
		
		query.setParameter("rcp_seq", rcpSeq);
		
		List<StepVO> list = (List<StepVO>)query.getResultList();
		
		return list;
	}
}
