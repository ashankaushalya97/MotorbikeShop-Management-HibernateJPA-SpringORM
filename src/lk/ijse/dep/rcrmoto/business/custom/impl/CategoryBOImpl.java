package lk.ijse.dep.rcrmoto.business.custom.impl;


import lk.ijse.dep.rcrmoto.business.custom.CategoryBO;
import lk.ijse.dep.rcrmoto.dao.custom.CategoryDAO;
import lk.ijse.dep.rcrmoto.dto.CategoryDTO;
import lk.ijse.dep.rcrmoto.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class CategoryBOImpl implements CategoryBO {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> getCategories() throws Exception {
            List<CategoryDTO> categories = new ArrayList<>();
            List<Category> all = categoryDAO.findAll();
            for (Category category : all) {
                categories.add(new CategoryDTO(category.getCategoryId(),category.getDescription()));
            }
        return categories;

    }
}
