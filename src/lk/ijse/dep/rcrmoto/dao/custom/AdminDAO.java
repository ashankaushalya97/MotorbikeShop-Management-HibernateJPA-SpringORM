package lk.ijse.dep.rcrmoto.dao.custom;

import lk.ijse.dep.rcrmoto.dao.CrudDAO;
import lk.ijse.dep.rcrmoto.entity.Admin;

public interface AdminDAO extends CrudDAO<Admin,String> {

    boolean authentication(Admin admin)throws Exception;
}
