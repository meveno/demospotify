package com.neosoft.demospofity.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.Query;

import com.neosoft.demospofity.dao.base.BaseDaoImpl;
import com.neosoft.demospofity.entity.Album;
import com.neosoft.demospofity.entity.Tag;

@Repository
@Transactional
public class TagDaoImpl extends BaseDaoImpl<Tag> implements TagDao {

	public TagDaoImpl() {
		super(Tag.class);
	}

	@Override
	public Tag findTagByName(String name) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(" from Tag t where t.name = ");
        queryBuilder.append("'");
        queryBuilder.append(name);
        queryBuilder.append("'");
        
        Query query = em.createQuery(queryBuilder.toString(), this.clazz);
        List<Tag> tags = query.getResultList();
        if(tags != null && !tags.isEmpty()) {
        	return tags.get(0);
        }
		return null;
	}
}
