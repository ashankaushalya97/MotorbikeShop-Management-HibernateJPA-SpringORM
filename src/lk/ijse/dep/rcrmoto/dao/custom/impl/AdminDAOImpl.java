package lk.ijse.dep.rcrmoto.dao.custom.impl;

import lk.ijse.dep.rcrmoto.dao.CrudDAOImpl;
import lk.ijse.dep.rcrmoto.dao.custom.AdminDAO;
import lk.ijse.dep.rcrmoto.entity.Admin;
import org.springframework.stereotype.Component;


public class AdminDAOImpl extends CrudDAOImpl<Admin,String> implements AdminDAO {

    @Override
    public boolean authentication(Admin admin) throws Exception {
        int result = (int) entityManager.createNativeQuery("SELECT COUNT(username) FROM admin WHERE username=?1 AND password=?2").setParameter(1, admin.getUsername()).setParameter(2, admin.getPassword()).getSingleResult();
        if(result==1){
            return true;
        }
        return false;
    }
}
