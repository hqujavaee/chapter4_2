package cn.edu.hqu.javaee.chapter4_2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.hqu.javaee.chapter4_2.entity.Hquer;
import cn.edu.hqu.javaee.chapter4_2.repository.HquerRepository;
import cn.edu.hqu.javaee.chapter4_2.service.HquerService;

@Service
public class HquerServiceImpl implements HquerService{
	@Autowired
	HquerRepository hquerRepository;

	@Override
	public Hquer login(String userName, String password) {
		Hquer hquer;
		
		if((hquer=hquerRepository.findByUserName(userName))!=null 
				&& hquer.getPassword().equals(password)) {
			System.out.println(hquer.getUserName());
			return hquer;
		}
		return null;
	}

	@Override
	public boolean register(Hquer hquer) {
		if((hquerRepository.findByUserName(hquer.getUserName()))==null) {
			hquerRepository.save(hquer);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Hquer getUserDetail(String userName) {
		return hquerRepository.findByUserName(userName);
	}

}
