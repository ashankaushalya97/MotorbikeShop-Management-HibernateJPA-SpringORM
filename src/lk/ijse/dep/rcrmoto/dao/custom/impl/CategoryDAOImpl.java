package lk.ijse.dep.rcrmoto.dao.custom.impl;

import lk.ijse.dep.rcrmoto.dao.CrudDAOImpl;
import lk.ijse.dep.rcrmoto.dao.custom.CategoryDAO;
import lk.ijse.dep.rcrmoto.entity.Category;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAOImpl extends CrudDAOImpl<Category,String> implements CategoryDAO {

}
