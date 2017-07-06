package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.dao.StepDAO_interface;
import com.spring.entity.StepVO;


@Service("stepService")
public class StepServiceImpl implements StepService {
	
	@Autowired(required = true)
	@Qualifier("stepDAO")
	private StepDAO_interface stepDAO;
	
	
	public List<StepVO> getAll() {
		return null;
	}

	public void insert(StepVO stepVO) {

	}

	public void update(StepVO stepVO) {

	}

	public void delete(StepVO stepVO) {
		
	}

	public List<StepVO> findByPrimaryKey(int rcpSeq) {
		return stepDAO.findByPrimaryKey(rcpSeq);
	}
}
