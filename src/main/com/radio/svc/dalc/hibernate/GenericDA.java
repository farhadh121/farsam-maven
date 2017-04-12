package com.radio.svc.dalc.hibernate;

import com.radio.svc.dalc.Dialect;
import com.radio.svc.dalc.IGenericDA;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.HibernateException;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

/**
 * Created by IntelliJ IDEA.
 * User: saman
 * Date: 5/10/12
 * Time: 9:30 AM
 * To change this template use CommonFile | Settings | CommonFile Templates.
 */
    public class GenericDA<TEntity, TId extends Serializable> extends HibernateDaoSupport implements IGenericDA<TEntity, TId>
    {
        private Boolean isDateString = false;
        private Dialect mappingDialect = Dialect.mysql;

        public Boolean isDateString()
        {
            return isDateString;
        }

        public void setDateString(Boolean dateString)
        {
            isDateString = dateString == null ? false : dateString;
        }

        public Dialect getMappingDialect()
        {
            return mappingDialect;
        }

        public Dialect dialect()
        {
            return this.getMappingDialect();
        }

        public void setMappingDialect(Dialect mappingDialect)
        {
            this.mappingDialect = mappingDialect;
        }

        public Class getType()
        {
            Type tClass = null;
            Type type = this.getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType)
            {
                ParameterizedType paramType = (ParameterizedType) type;
                tClass = paramType.getActualTypeArguments()[0];
            }
            return (Class) tClass;
        }

        public String getStringType()
        {
            return this.getType().getName();
        }

        public TEntity get(TId id)
        {
            return (TEntity) this.getSession().get(getType(), id);
        }

        public List<TEntity> get()
        {
            return (List<TEntity>) this.getSession().createCriteria(getType()).list();
        }

        public List<TEntity> get(long from, long size)
        {
            return this.getSession().createCriteria(getType())
                    .setFirstResult((int) from)
                    .setMaxResults((int) size)
                    .list();
        }

        public TEntity insert(TEntity entity)
        {
            this.getSession().save(entity);
            return entity;
        }

        public TEntity update(TEntity entity)
        {
            try
            {
                this.getSession().evict(entity);
                this.getSession().update(entity);
                //this.getSession().flush();
            }
            catch (HibernateException ex)
            {
                this.getSession().evict(entity);
                this.getSession().clear();
    //            this.getSession().update(entity);
                throw ex;
            }
            return entity;
        }

        public void delete(TId id)
        {
            this.getSession().delete(get(id));
        }

        public void delete(TEntity entity)
        {
            this.getSession().delete(entity);
        }

        public List<TEntity> get(int from, int size)
        {
            //noinspection unchecked
            return this.getSession().createCriteria(getType())
                    .setFirstResult(from)
                    .setMaxResults(size)
                    .list();
        }

        public long getCount()
        {
            return (Long) this.getSession().createQuery("select count(entity.id) from " + getStringType() + " entity")
                    .uniqueResult();
        }

        public Object getProperty(Long id, String property)
        {
            Criteria criteria = this.getSession().createCriteria(getType());
            criteria.add(Restrictions.eq("id", id));
            criteria.setProjection(Projections.property(property));
            criteria.setMaxResults(1);
            return criteria.uniqueResult();
        }

        public org.hibernate.Session prepareFilteredSession(Date effectiveDate)
        {
            org.hibernate.Session session = this.getSession();
            if (effectiveDate != null)
                session.enableFilter("effectiveDate").setParameter("fDate", effectiveDate);

            return session;
        }

        public void DisableFilter(org.hibernate.Session session)
        {
            session.disableFilter("effectiveDate");
        }

        public String getLikeExpression(String filter, String parameter)
        {
            String result = "LIKE";
            if (filter.startsWith("*"))
            {
                if (this.mappingDialect.equals(Dialect.oracle))
                    result += " '%' ||";
                else
                    result += " '%' +";
            }

            result += " :" + parameter + " ";
            if (filter.endsWith("*"))
            {
                if (this.mappingDialect.equals(Dialect.oracle))
                    result += " || '%'";
                else
                    result += " + '%'";
            }
            return result;
        }

        public String getLikeParameter(String parameter)
        {
            if (parameter.startsWith("*"))
                parameter = parameter.substring(1);

            if (parameter.endsWith("*"))
                parameter = parameter.substring(0, parameter.length() - 1);

            return parameter;
        }

        public Query setDateParameter(Query query, String name, Date value)
        {
            if (this.isDateString)
                return query.setString(name, String.format("%1$tY-%1$tm-%1$td %tT", value));
            else
                return query.setParameter(name, value);

        }
    }
