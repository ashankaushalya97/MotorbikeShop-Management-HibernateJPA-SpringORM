package lk.ijse.dep.rcrmoto.dao.custom.impl;

import lk.ijse.dep.rcrmoto.dao.CrudDAOImpl;
import lk.ijse.dep.rcrmoto.dao.custom.ItemDAO;
import lk.ijse.dep.rcrmoto.entity.Item;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ItemDAOImpl extends CrudDAOImpl<Item,String> implements ItemDAO {

    @Override
    public String getLastItemId() throws Exception {
        return (String) entityManager.createNativeQuery("SELECT item_id FROM Item ORDER BY item_id DESC LIMIT 1").getSingleResult();
    }

    @Override
    public List<Item> searchItems(String text) throws Exception {
        return entityManager.createNativeQuery("SELECT * FROM Item WHERE item_id LIKE ?1 OR category_id LIKE ?2 OR brand LIKE ?3 OR description LIKE ?4 OR qty_on_hand LIKE ?5 OR buy_price LIKE ?6 OR unit_price LIKE ?7")
            .setParameter(1,text).setParameter(2,text).setParameter(3,text).setParameter(4,text).setParameter(5,text)
                .setParameter(6,text).setParameter(7,text).getResultList();
    }
}
