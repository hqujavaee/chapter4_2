package cn.edu.hqu.javaee.chapter4_2.repository;

import cn.edu.hqu.javaee.chapter4_2.entity.Hquer;

public interface HquerRepository {
	public void save(Hquer hquer);
	public Hquer findByUserName(String userName);
}
