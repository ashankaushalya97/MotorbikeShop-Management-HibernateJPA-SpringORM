package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.DB.JPAUtil;
import lk.ijse.dep.rcrmoto.business.custom.CategoryBO;
import lk.ijse.dep.rcrmoto.dao.custom.CategoryDAO;
import lk.ijse.dep.rcrmoto.dto.CategoryDTO;
import lk.ijse.dep.rcrmoto.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class CategoryBOImpl implements CategoryBO {

    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public List<CategoryDTO> getCategories() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        categoryDAO.setEntityManager(em);
        em.getTransaction().begin();
            List<CategoryDTO> categories = new ArrayList<>();
            List<Category> all = categoryDAO.findAll();
            for (Category category : all) {
                categories.add(new CategoryDTO(category.getCategoryId(),category.getDescription()));
            }

        em.getTransaction().commit();
        em.close();
            return categories;

    }
}
