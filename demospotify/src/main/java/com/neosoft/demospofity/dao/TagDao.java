package com.neosoft.demospofity.dao;

import com.neosoft.demospofity.dao.base.BaseDao;
import com.neosoft.demospofity.entity.Album;
import com.neosoft.demospofity.entity.Library;
import com.neosoft.demospofity.entity.Tag;

public interface TagDao extends BaseDao<Tag>{

	Tag findTagByName(String name);
}
