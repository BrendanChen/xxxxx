package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CookWayDAO_interface;
import com.spring.entity.CookWayCodeVO;

@Service("cookWayCodeService")
public class CookWayCodeServiceImpl implements CookWayCodeService {

	@Autowired
	private CookWayDAO_interface cookWayDao;

	public List<CookWayCodeVO> getAll() {

		return cookWayDao.getAll();
	}
}
