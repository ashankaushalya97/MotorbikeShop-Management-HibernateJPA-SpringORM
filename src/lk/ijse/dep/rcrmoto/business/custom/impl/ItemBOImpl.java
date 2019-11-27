package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.DB.JPAUtil;
import lk.ijse.dep.rcrmoto.business.custom.ItemBO;
import lk.ijse.dep.rcrmoto.dao.DAOFactory;
import lk.ijse.dep.rcrmoto.dao.DAOTypes;
import lk.ijse.dep.rcrmoto.dao.custom.ItemDAO;
import lk.ijse.dep.rcrmoto.dto.ItemDTO;
import lk.ijse.dep.rcrmoto.entity.Category;
import lk.ijse.dep.rcrmoto.entity.Item;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO= DAOFactory.getInstance().getDAO(DAOTypes.ITEM);

    @Override
    public void saveItem(ItemDTO item) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        itemDAO.setEntityManager(em);
        em.getTransaction().begin();
            itemDAO.save(new Item(item.getItemId(), em.getReference (Category.class,item.getCategoryId()),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateItem(ItemDTO item) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        itemDAO.setEntityManager(em);
        em.getTransaction().begin();
            itemDAO.update(new Item(item.getItemId(),em.getReference(Category.class,item.getCategoryId()),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteItem(String id) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        itemDAO.setEntityManager(em);
        em.getTransaction().begin();
            itemDAO.delete(id);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<ItemDTO> findAllItems() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        itemDAO.setEntityManager(em);
        em.getTransaction().begin();
            List<Item> all = itemDAO.findAll();
            List<ItemDTO> itemDTOS = new ArrayList<>();
            for (Item item : all) {
            itemDTOS.add(new ItemDTO(item.getItemId(),item.getCategory().getCategoryId(),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
            }

        em.getTransaction().commit();
        em.close();
            return itemDTOS;
    }

    @Override
    public String getLastItemId() throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        itemDAO.setEntityManager(em);
        em.getTransaction().begin();
            String lastItemId = itemDAO.getLastItemId();

        em.getTransaction().commit();
        em.close();
            return lastItemId;
    }

    @Override
    public List<ItemDTO> searchItems(String text) throws Exception {
        EntityManager em = JPAUtil.getEmf().createEntityManager();
        itemDAO.setEntityManager(em);
        em.getTransaction().begin();
            List<Item> search = itemDAO.searchItems(text);
            List<ItemDTO> items = new ArrayList<>();
            for (Item item : search) {
                items.add(new ItemDTO(item.getItemId(),item.getCategory().getCategoryId(),item.getBrand(),item.getDescription(),item.getQtyOnHand(),item.getBuyPrice(),item.getUnitPrice()));
            }

        em.getTransaction().commit();
        em.close();
            return items;
    }
}
