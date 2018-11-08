package com.neosoft.demospofity.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.neosoft.demospofity.dao.base.BaseDaoImpl;
import com.neosoft.demospofity.entity.Library;

@Repository
@Transactional
public class LibraryDaoImpl extends BaseDaoImpl<Library> implements LibraryDao {

	public LibraryDaoImpl() {
		super(Library.class);
	}
	
}
