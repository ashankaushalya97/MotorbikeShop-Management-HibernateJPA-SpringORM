package lk.ijse.dep.rcrmoto.dao.custom;

import lk.ijse.dep.rcrmoto.dao.CrudDAO;
import lk.ijse.dep.rcrmoto.entity.Item;

import java.util.List;

public interface ItemDAO extends CrudDAO<Item,String> {

    String getLastItemId() throws Exception;

    List<Item> searchItems(String text)throws Exception;

}
