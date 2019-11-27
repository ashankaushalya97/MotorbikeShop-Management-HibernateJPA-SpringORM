package lk.ijse.dep.rcrmoto.business.custom;

import lk.ijse.dep.rcrmoto.business.SuperBO;
import lk.ijse.dep.rcrmoto.dto.LoginDTO;

public interface LoginBO extends SuperBO {

    boolean authentication (LoginDTO loginDTO) throws Exception;

}
