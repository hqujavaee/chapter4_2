package cn.edu.hqu.javaee.chapter4_2.repository.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.chapter4_2.entity.Hquer;
import cn.edu.hqu.javaee.chapter4_2.repository.HquerRepository;

@Repository
@Transactional
public class HquerRepositoryImpl implements HquerRepository {
	@Autowired
	private SessionFactory sessionFactory;
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(Hquer hquer) {
		currentSession().save(hquer);

	}

	@Override
	public Hquer findByUserName(String userName) {
		//:userName为命名参数，直接采用Hibernate的 HQL语句进行查询
		String hql="from Hquer as hquer where hquer.userName=:uName";
		Query query=currentSession().createQuery(hql);
		query.setParameter("uName", userName);
		List<?> hquerList=query.getResultList();
		if(hquerList.size()==0)
			return null;
		else
			return (Hquer) hquerList.get(0);
	}

}
