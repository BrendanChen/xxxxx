package com.spring.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.KindCodeVO;


@Repository("kindCodeDAO")
@Transactional
public class KindCodeDAO implements KindCodeDAO_interface{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public List<KindCodeVO> getAll() {
	      CriteriaQuery<KindCodeVO> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(KindCodeVO.class);
	      @SuppressWarnings("unused")
	      Root<KindCodeVO> root = criteriaQuery.from(KindCodeVO.class);
	      return entityManager.createQuery(criteriaQuery).getResultList();
	}
}
