package lk.ijse.dep.rcrmoto.business.custom;

import lk.ijse.dep.rcrmoto.business.SuperBO;
import lk.ijse.dep.rcrmoto.dto.CategoryDTO;

import java.util.List;

public interface CategoryBO extends SuperBO {
    public List<CategoryDTO> getCategories()throws Exception;
}
