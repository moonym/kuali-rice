/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */
 
 package com.javatunes.persist;

import java.util.Collection;

public interface MusicItemDAO {
	// TODO uncomment these methods as you implment them in JdbcMusicItemDAO
	public MusicItem searchById(Long id);
	public Collection<MusicItem> searchByKeyword(String keyword);
	public void create(MusicItem item);
	public void delete(MusicItem item);
}