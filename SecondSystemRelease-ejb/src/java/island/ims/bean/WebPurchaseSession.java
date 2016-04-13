/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package island.ims.bean;

import island.ims.entity.IMSStoreProductEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class WebPurchaseSession implements WebPurchaseSessionLocal {
    
    @PersistenceContext
    private EntityManager entityManager;

        /*
    public List<SalesRecordEntity> getPendingCustomerOrder(String storeId) {
        Query query = entityManager.createQuery("SELECT p FROM SalesRecordEntity p WHERE p.status = 'Pending' AND p.storeVisited = :storeId");
        query.setParameter("storeId", storeId);
        SalesRecordEntity result = (SalesRecordEntity)query.getResultList();
        return result;
    }
    */
    
    /*
    public List<SalesRecordEntity> getCompletedCustomerOrder(String storeId) {
        Query query = entityManager.createQuery("SELECT p FROM SalesRecordEntity p WHERE p.status = 'Completed' AND p.storeVisited = :storeId");
        query.setParameter("storeId", storeId);
        SalesRecordEntity result = (SalesRecordEntity)query.getResultList();
        return result;
    }
    */
    
    /* To be edited 
   public void confirmCODelivery(Long id) {
        Query query = entityManager.createQuery("SELECT p FROM SalesRecordEntity p WHERE p.salesRecId = :id");
        query.setParameter("id", id);
        SalesRecordEntity result = (SalesRecordEntity)query.getSingleResult();
        result.setStatus("Completed");
        List<IMSStoreProductEntity> productList = result.getProducts();
        for (int i = 0; i < productList.size(); i++) {
		String pdtName = productList.getProductName(i);
                int pdtQty = productList.getQuantity(i);
                Query query1 = entityManager.createQuery("SELECT p FROM IMSStoreProductEntity p WHERE p.productName = :productName");
                query1.setParameter("productName", pdtName);
                IMSStoreProductEntity pdt = (IMSStoreProductEntity)query1.getSingleResult();
                int tempTotal = pdt.getTotalQuantity();
                int tempWarehouse = pdt.getQtyInWarehouse();
                int newTotal = tempTotal + pdtQty;
                int newWarehouse = tempWarehouse + pdtQty;
                pdt.setTotalQuantity(newTotal);
                pdt.setQtyInWarehouse(newWarehouse);
                entityManager.flush();
	}
    }
    */
    
    /*
    public MRPProductEntity retrievePdtByBarcode(Long id) {
        MRPProductEntity pdt = new MRPProductEntity();
        pdt = entityManager.find(MRPProductEntity.class, id);
        return pdt;
    }
    */
    
    public String[] getPOSPdtInfo(String storeId, Long barcode){
        Query query = entityManager.createQuery("SELECT p FROM IMSStoreProductEntity p WHERE p.storeId = :storeId AND p.id = :id");
        query.setParameter("storeId", storeId);
        query.setParameter("id", barcode);
        IMSStoreProductEntity pdt = (IMSStoreProductEntity)query.getSingleResult();
        String[] quantity = {String.valueOf(pdt.getTotalQuantity()), String.valueOf(pdt.getQtyInWarehouse()),
                             String.valueOf(pdt.getQtyInMarketplace()), String.valueOf(pdt.getQtyInDisplay()), 
                             String.valueOf(pdt.getQtyInSelfService())};
        
        return quantity;
    }
    
    /*
    public List<MRPProductEntity> retrievePdtByKeywords(String keywords) {
        Query query = entityManager.createQuery("SELECT m FROM MRPProductEntity m WHERE m.productName LIKE :productName");
        query.setParameter("productName", "%" + keywords + "%");
        List<MRPProductEntity> pdtList = query.getResultList();
        return pdtList;
    }
    */
}
