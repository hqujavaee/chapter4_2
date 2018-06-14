package cn.edu.hqu.javaee.chapter4_2.service;

import cn.edu.hqu.javaee.chapter4_2.entity.Hquer;

public interface HquerService {
	public Hquer login(String userName,String password);
	public boolean register(Hquer hquer);
	public Hquer getUserDetail(String userName);
}
