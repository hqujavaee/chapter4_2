package cn.edu.hqu.javaee.chapter4_2.repository.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.javaee.chapter4_2.entity.Hquer;
import cn.edu.hqu.javaee.chapter4_2.entity.Message;
import cn.edu.hqu.javaee.chapter4_2.repository.MessageRepository;

@Repository
@Transactional
public class MessageRepositoryImpl implements MessageRepository {
	@Autowired
	private SessionFactory sessionFactory;
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Message> findMessageByUserName(String userName) {
		//:userName为命名参数，直接采用Hibernate的 HQL语句进行查询
		String hql="from Hquer as hquer where hquer.userName=:uName";
		Query query=currentSession().createQuery(hql);
		query.setParameter("uName", userName);
		List<?> hquerList=query.getResultList();
		Hquer hquer=(Hquer) hquerList.get(0);
		hquer.getMessageList().size();
		return hquer.getMessageList();
	}

	@Override
	public void save(Message message) {
		currentSession().save(message);

	}

}
