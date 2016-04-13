package island.ims.bean;

import island.ims.entity.IMSStoreProductEntity;
import island.mrp.entity.MRPProductEntity;
//import island.scm.entity.SCMDeliveryOrderEntity;
import island.ims.util.exception.ConflictException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class InventoryManagementBean implements InventoryManagementBeanLocal {

    @PersistenceContext
    private EntityManager entityManager;
    
    private IMSStoreProductEntity storePdt;
    
    @Override
    public void updateFurnitureDetails(IMSStoreProductEntity s) {
        long id = s.getId();

        storePdt = new IMSStoreProductEntity();
        storePdt = entityManager.find(IMSStoreProductEntity.class, id);
        storePdt.setProductName(s.getProductName());
        storePdt.setType(s.getType());
        storePdt.setPrice(s.getPrice());
        storePdt.setStoreId(s.getStoreId());
        storePdt.setLocation(s.getLocation());
        storePdt.setTotalQuantity(s.getTotalQuantity());
        storePdt.setQtyInMarketplace(s.getQtyInMarketplace());
        storePdt.setQtyInWarehouse(s.getQtyInWarehouse());
        storePdt.setQtyInSelfService(s.getQtyInSelfService());
        storePdt.setQtyInDisplay(s.getQtyInDisplay());
        storePdt.setQtyInPickupArea(s.getQtyInPickupArea());
        storePdt.setQtyInOutboundWarehouse(s.getQtyInOutboundWarehouse());

        entityManager.flush();
        entityManager.refresh(storePdt);
    }
    
    @Override
    public void updateRetailDetails(IMSStoreProductEntity s){
        long id = s.getId();

        storePdt = new IMSStoreProductEntity();
        storePdt = entityManager.find(IMSStoreProductEntity.class, id);
        storePdt.setProductName(s.getProductName());
        storePdt.setType(s.getType());
        storePdt.setPrice(s.getPrice());
        storePdt.setStoreId(s.getStoreId());
        storePdt.setTotalQuantity(s.getTotalQuantity());
        storePdt.setQtyInWarehouse(s.getQtyInWarehouse());
        storePdt.setQtyInStore(s.getQtyInStore());
    }
    
    @Override
    public List<IMSStoreProductEntity> getAllStoreFurniture() {
        Query query = entityManager.createQuery("SELECT s FROM IMSStoreProductEntity s WHERE s.type = 2 OR s.type = 3 ORDER BY s.storeId ASC AND s.productName ASC");
        return query.getResultList();
    }
    
    @Override
    public List<IMSStoreProductEntity> getAllRetailProducts() {
        Query query = entityManager.createQuery("SELECT s FROM IMSStoreProductEntity s ORDER BY s.storeId ASC AND s.id ASC");
        return query.getResultList();
    }
    
    @Override
    public boolean deleteProduct(Long id, String storeId) {
        try {
            Query query = entityManager.createQuery("SELECT s FROM IMSStoreProductEntity s WHERE s.id = :id AND s.storeId = :storeId");
            query.setParameter("id", id);
            query.setParameter("storeId", storeId);
            IMSStoreProductEntity f = (IMSStoreProductEntity)query.getSingleResult();
            entityManager.remove(f);
            entityManager.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public Long addNewFurniture(Long id, String productName, int type, double price, String storeId, String location, int totalQuantity, int qtyInMarketplace, int qtyInWarehouse, int qtyInSelfService, int qtyInDisplay, int qtyInPickupArea, int qtyInOutboundWarehouse) 
            throws ConflictException {
        if (!checkConflict(productName, storeId)) {
            IMSStoreProductEntity sf = new IMSStoreProductEntity();
            sf.setId(id);
            sf.setProductName(productName);
            sf.setType(type);
            sf.setPrice(price);
            sf.setStoreId(storeId);
            sf.setLocation(location);
            sf.setTotalQuantity(totalQuantity);
            sf.setQtyInMarketplace(qtyInMarketplace);
            sf.setQtyInWarehouse(qtyInWarehouse);
            sf.setQtyInSelfService(qtyInSelfService);
            sf.setQtyInDisplay(qtyInDisplay);
            sf.setQtyInPickupArea(qtyInPickupArea);
            sf.setQtyInOutboundWarehouse(qtyInOutboundWarehouse);
            entityManager.persist(sf);
            entityManager.flush();
            return sf.getId();
        } else {
            throw new ConflictException(productName + ", this furniture already exists.");
        }
    }
    
    @Override
    public Long addNewRetailProduct(Long id, String productName, int type, double price, String storeId, int totalQuantity, int qtyInWarehouse, int qtyInStore) throws ConflictException {
        if (!checkConflict(productName, storeId)){
            IMSStoreProductEntity sf = new IMSStoreProductEntity();
            sf.setId(id);
            sf.setProductName(productName);
            sf.setType(type);
            sf.setPrice(price);
            sf.setStoreId(storeId);
            sf.setTotalQuantity(totalQuantity);
            sf.setQtyInWarehouse(qtyInWarehouse);
            sf.setQtyInStore(qtyInStore);
            entityManager.persist(sf);
            entityManager.flush();
            return sf.getId();
        } else {
            throw new ConflictException(productName + ", this furniture already exists.");
        }
    }
    
    private Boolean checkConflict(String productName, String storeId) {
        Query query = entityManager.createQuery("SELECT f FROM IMSStoreProductEntity f WHERE f.productName = :name AND f.storeId = :storeId");
        query.setParameter("name", productName);
        query.setParameter("storeId", storeId);
        List resultList = query.getResultList();
        
        if (resultList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<MRPProductEntity> getFurnitureProduct() {
        Query q = entityManager.createQuery("SELECT p.productName FROM MRPProductEntity p WHERE p.type=2 OR p.type=3");
        return q.getResultList();
    }

    @Override
    public List<MRPProductEntity> getProductRetail() {
        Query q = entityManager.createQuery("SELECT p.productName FROM MRPProductEntity p WHERE p.type=1");
        return q.getResultList();
    }
    
    @Override
    public Long getProductID(String name) {
        Query query = entityManager.createQuery("SELECT p FROM MRPProductEntity p WHERE p.productName = :name");
        query.setParameter("name", name);
        MRPProductEntity result = (MRPProductEntity)query.getSingleResult();
        return result.getId();
    }
    
    @Override
    public double getProductPrice(String name){
        Query query = entityManager.createQuery("SELECT p FROM MRPProductEntity p WHERE p.productName = :name");
        query.setParameter("name", name);
        MRPProductEntity result = (MRPProductEntity)query.getSingleResult();
        return result.getSellingPrice();
    }
    


    
    public void handleStockTransfer(String productName, int quantity, String currentLocation, String targetLocation, String storeId) {
        Query query = entityManager.createQuery("SELECT p FROM IMSStoreProductEntity p WHERE p.productName = :productName AND p.storeId = :storeId");
        query.setParameter("productName", productName);
        query.setParameter("storeId", storeId);
        IMSStoreProductEntity pdt = (IMSStoreProductEntity)query.getSingleResult();
        
        if (currentLocation == "Warehouse") {
            pdt.setQtyInWarehouse(pdt.getQtyInWarehouse() - quantity);
        }
        
        if (currentLocation == "Marketplace") {
            pdt.setQtyInMarketplace(pdt.getQtyInMarketplace() - quantity);
        }
        
        if (currentLocation == "Self-Service Area") {
            pdt.setQtyInSelfService(pdt.getQtyInSelfService() - quantity);
        }
        
        if (currentLocation == "Display Area") {
            pdt.setQtyInDisplay(pdt.getQtyInDisplay() - quantity);
        }
        
        if (currentLocation == "Pickup Area") {
            pdt.setQtyInPickupArea(pdt.getQtyInPickupArea() - quantity);
        }
        
        if (currentLocation == "Outbound Warehouse") {
            pdt.setQtyInOutboundWarehouse(pdt.getQtyInOutboundWarehouse() - quantity);
        }
        
        if (currentLocation == "Store") {
            pdt.setQtyInStore(pdt.getQtyInStore() - quantity);
        }
        
        
        if (targetLocation == "Warehouse") {
            pdt.setQtyInWarehouse(pdt.getQtyInWarehouse() + quantity);
        }
        
        if (targetLocation == "Marketplace") {
            pdt.setQtyInMarketplace(pdt.getQtyInMarketplace() + quantity);
        }
        
        if (targetLocation == "Self-Service Area") {
            pdt.setQtyInSelfService(pdt.getQtyInSelfService() + quantity);
        }
        
        if (targetLocation == "Display Area") {
            pdt.setQtyInDisplay(pdt.getQtyInDisplay() + quantity);
        }
        
        if (targetLocation == "Pickup Area") {
            pdt.setQtyInPickupArea(pdt.getQtyInPickupArea() + quantity);
        }
        
        if (targetLocation == "Outbound Warehouse") {
            pdt.setQtyInOutboundWarehouse(pdt.getQtyInOutboundWarehouse() + quantity);
        }
        
        if (targetLocation == "Store") {
            pdt.setQtyInStore(pdt.getQtyInStore() + quantity);
        }
        
        entityManager.flush();
    }
    

}
