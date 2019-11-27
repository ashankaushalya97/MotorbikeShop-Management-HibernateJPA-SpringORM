package lk.ijse.dep.rcrmoto.dao;

import lk.ijse.dep.rcrmoto.entity.SuperEntity;
import org.hibernate.Session;

import java.util.List;

public interface CrudDAO <T extends SuperEntity,ID> extends SuperDAO {

    public List<T> findAll() throws Exception;

    public T find(ID id) throws Exception;

    public void save(T entity) throws Exception;

    public void update(T entity) throws Exception;

    public void delete(ID id) throws Exception;
}
