package io.springboot2.x.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot2.x.domain.NetflixAcc;
import io.springboot2.x.repository.NetflixAccRepository;
import io.springboot2.x.service.INetflixService;

@Service
public class NetflixServiceImpl implements INetflixService {
	
	@Autowired
	private NetflixAccRepository netflixAccRepository;

	@Override
	public boolean generateNetflixAcc(NetflixAcc netflixAcc) {
		// TODO Auto-generated method stub
		if(netflixAccRepository.existsById(netflixAcc.getNetflixid())!=true) {
			netflixAccRepository.saveAndFlush(netflixAcc);
			return true ;
		}
		return false ;
	}

}
