package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.DB.HibernateUtil;
import lk.ijse.dep.rcrmoto.business.custom.LoginBO;
import lk.ijse.dep.rcrmoto.dao.DAOFactory;
import lk.ijse.dep.rcrmoto.dao.DAOTypes;
import lk.ijse.dep.rcrmoto.dao.custom.AdminDAO;
import lk.ijse.dep.rcrmoto.dto.LoginDTO;
import lk.ijse.dep.rcrmoto.entity.Admin;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class LoginBOImpl implements LoginBO {
    @Autowired
    AdminDAO adminDAO;

    @Override
    public boolean authentication(LoginDTO loginDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            adminDAO.setSession(session);
            session.beginTransaction();
            boolean authentication = adminDAO.authentication(new Admin(loginDTO.getUsename(), loginDTO.getPassword()));
            session.getTransaction().commit();
            return authentication;
        }
    }

}
