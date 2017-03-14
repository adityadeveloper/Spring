package com.rcpfc.login.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rcpfc.base.BaseDAOHibernate;
import com.rcpfc.login.model.LoginUserVO;

@Component
public class LoginUserDAOImpl extends BaseDAOHibernate<LoginUserVO> implements LoginUserDAO{
	
	@Override
	public void save(LoginUserVO loginuser) {
		sessionFactory.getCurrentSession().save(loginuser);
	}

	@Override
	public void delete(LoginUserVO loginuser) {
		sessionFactory.getCurrentSession().delete(loginuser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginUserVO> getByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LoginUserVO.class);
		criteria.add(Restrictions.eq("username", username));
		
		List<LoginUserVO> list = criteria.list();
		
		if(list != null && list.size()>0){
			return list;
		}
		else return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public LoginUserVO getByMobileNumber(String mobileNumber) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(LoginUserVO.class);
		criteria.add(Restrictions.eq("mobileNumber", mobileNumber));		
		
		List<LoginUserVO> list = criteria.list();
		
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
