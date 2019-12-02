package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.business.custom.ItemBO;
import lk.ijse.dep.rcrmoto.dao.custom.CategoryDAO;
import lk.ijse.dep.rcrmoto.dao.custom.ItemDAO;
import lk.ijse.dep.rcrmoto.dto.ItemDTO;
import lk.ijse.dep.rcrmoto.entity.Category;
import lk.ijse.dep.rcrmoto.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
@Component
@Transactional
public class ItemBOImpl implements ItemBO {
    @Autowired
    ItemDAO itemDAO;
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public void saveItem(ItemDTO item) throws Exception {
            itemDAO.save(new Item(item.getItemId(),categoryDAO.find(item.getCategoryId()),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
    }

    @Override
    public void updateItem(ItemDTO item) throws Exception {
            itemDAO.update(new Item(item.getItemId(),categoryDAO.find(item.getCategoryId()),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
    }

    @Override
    public void deleteItem(String id) throws Exception {
            itemDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemDTO> findAllItems() throws Exception {
            List<Item> all = itemDAO.findAll();
            List<ItemDTO> itemDTOS = new ArrayList<>();
            for (Item item : all) {
            itemDTOS.add(new ItemDTO(item.getItemId(),item.getCategory().getCategoryId(),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
            }
            return itemDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public String getLastItemId() throws Exception {
            String lastItemId = itemDAO.getLastItemId();
            return lastItemId;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemDTO> searchItems(String text) throws Exception {
            List<Item> search = itemDAO.searchItems(text);
            List<ItemDTO> items = new ArrayList<>();
            for (Item item : search) {
                items.add(new ItemDTO(item.getItemId(),item.getCategory().getCategoryId(),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
            }
            return items;
    }
}
