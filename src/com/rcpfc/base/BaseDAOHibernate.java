package com.rcpfc.base;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseDAOHibernate<T> implements BaseDAO<T> {
	
	@Autowired
	protected SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Delets the entity
	 *
	 * @param object
	 * @throws Exception
	 */
	public void delete(T object)
	{
		Session session = sessionFactory.getCurrentSession();
		session.delete(object);
	}


	/**
	 * Inserts/Add new Entity
	 *
	 * @param object
	 * @throws Exception
	 */
	public void insert(T object)
	{
		Session session = sessionFactory.getCurrentSession();
		session.setFlushMode(FlushMode.AUTO);
		session.save(object);
		session.flush();
	}

	/**
	 * Inserts/Add new Entity
	 *
	 * @param objectList
	 * @throws Exception
	 */
	public void insertAll(Collection<T> objectList)
	{
		Session session = sessionFactory.getCurrentSession();
		session.setFlushMode(FlushMode.AUTO);
		for (T object : objectList)
		{
			session.save(object);
		}
		session.flush();
	}


	/**
	 * Updates existing entity
	 *
	 * @param object
	 * @throws Exception
	 */
	public void update(T object)
	{
		Session session = sessionFactory.getCurrentSession();
		session.setFlushMode(FlushMode.AUTO);
		session.update(object);
		session.flush();
	}


	/**
	 * Inserts or update object based on value of identity column
	 *
	 * @param object
	 * @throws Exception
	 */
	public void insertOrUpdate(T object)
	{
		Session session = sessionFactory.getCurrentSession();
		session.setFlushMode(FlushMode.AUTO);
		session.saveOrUpdate(object);
		session.flush();
	}


	/**
	 * Facilitates find by Id operation
	 *
	 * @param object
	 * @param id
	 * @return
	 * @throws Exception
	 */

	public Object findById(T object, Long id)
	{
		Session session = sessionFactory.getCurrentSession();
		return session.get(object.getClass(), id);
	}

	protected List<T> getList(Class<T> clazz, int size, Criterion criterion1, Criterion criterion2)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);

		criteria.add(criterion1);
		criteria.add(criterion2);

		criteria.setMaxResults(size);

		return criteria.list();
	}

	public void save(T object)
	{
		sessionFactory.getCurrentSession().save(object);
	}

	public void save(Collection<T> objects)
	{
		for (T object : objects)
		{
			sessionFactory.getCurrentSession().save(object);
		}
	}

	public void delete(Collection<T> objects)
	{
		for (T object : objects)
		{
			sessionFactory.getCurrentSession().delete(object);
		}
	}

}
