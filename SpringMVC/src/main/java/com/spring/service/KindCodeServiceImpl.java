package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.dao.KindCodeDAO_interface;
import com.spring.entity.KindCodeVO;

@Service("kindCodeService")
public class KindCodeServiceImpl implements KindCodeService {

	@Autowired(required = true)
	@Qualifier("kindCodeDAO")
	private KindCodeDAO_interface kindCodeDAO;

	public List<KindCodeVO> getAll() {
		return kindCodeDAO.getAll();
	}
}
