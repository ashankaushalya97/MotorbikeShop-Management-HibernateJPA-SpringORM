package lk.ijse.dep.rcrmoto.business.custom;

import lk.ijse.dep.rcrmoto.business.SuperBO;
import lk.ijse.dep.rcrmoto.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO{

    void saveItem(ItemDTO item)throws Exception;

    void updateItem(ItemDTO item)throws Exception;

    void deleteItem(String id)throws Exception;

    List<ItemDTO> findAllItems()throws Exception;

    String getLastItemId()throws Exception;

    List<ItemDTO> searchItems(String text)throws Exception;

}
