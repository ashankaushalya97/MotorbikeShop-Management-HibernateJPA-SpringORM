package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.business.custom.LoginBO;
import lk.ijse.dep.rcrmoto.dao.custom.AdminDAO;
import lk.ijse.dep.rcrmoto.dto.LoginDTO;
import lk.ijse.dep.rcrmoto.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Transactional
public class LoginBOImpl implements LoginBO {

    @Autowired
    AdminDAO adminDAO;

    @Override
    @Transactional(readOnly = true)
    public boolean authentication(LoginDTO loginDTO) throws Exception {
            boolean authentication = adminDAO.authentication(new Admin(loginDTO.getUsename(), loginDTO.getPassword()));
        return authentication;
    }

}
