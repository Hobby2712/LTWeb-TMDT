package DAO;

import java.util.List;

import Entity.Category;

public interface CategoryDAO {
	List<Category> getAllCategory1();
	List<Category> getAllCategory2();
	void deleteCate2(int cId);
	void addCategory2(Category cate);
	int countCategory();
	List<Category> getAllCategory2PT(int index);
	int countSearch(String search);
	List<Category> getAllCategory2Search(String search, int index);
}
