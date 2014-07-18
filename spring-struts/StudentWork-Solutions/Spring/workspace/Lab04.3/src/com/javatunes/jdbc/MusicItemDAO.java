/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */
 
 package com.javatunes.jdbc;

import java.util.Collection;

import com.javatunes.util.MusicItem;

public interface MusicItemDAO {
	public MusicItem searchById(Long id);
	public Collection<MusicItem> searchByKeyword(String keyword);
	public void create(MusicItem item);
}