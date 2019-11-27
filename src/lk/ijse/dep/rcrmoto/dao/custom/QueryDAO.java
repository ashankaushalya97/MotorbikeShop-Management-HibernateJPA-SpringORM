package lk.ijse.dep.rcrmoto.dao.custom;

import lk.ijse.dep.rcrmoto.dao.SuperDAO;
import lk.ijse.dep.rcrmoto.entity.CustomEntity;

import javax.persistence.EntityManager;
import java.util.List;

public interface QueryDAO extends SuperDAO {

    List<CustomEntity> getOrderInfo()throws Exception;

    List<CustomEntity> searchOrder(String text)throws Exception;

    void setEntityManager(EntityManager entityManager);

}
