package kr.or.connect.mavenweb.service.impl;

import kr.or.connect.mavenweb.dao.CategoryDao;
import kr.or.connect.mavenweb.dto.Category;
import kr.or.connect.mavenweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;


    @Override
    public List<Category> getCategoryResponse() {
        return categoryDao.select();
    }
}
