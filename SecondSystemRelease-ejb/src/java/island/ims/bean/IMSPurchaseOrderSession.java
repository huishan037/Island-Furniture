
package island.ims.bean;

import javax.ejb.Stateless;

@Stateless
public class IMSPurchaseOrderSession implements IMSPurchaseOrderSessionLocal {

    
    /*
    public List<PurchaseOrderEntity> getPendingPurchaseOrder(String storeId) {
        Query query = entityManager.createQuery("SELECT p FROM PurchaseOrderEntity p WHERE p.status = 'Pending' AND p.store = :storeId");
        query.setParameter("storeId", storeId);
        PurchaseOrderEntity result = (PurchaseOrderEntity)query.getResultList();
        return result;
    }
    */
    
    /*
    public List<PurchaseOrderEntity> getCompletedPurchaseOrder(String storeId) {
        Query query = entityManager.createQuery("SELECT p FROM PurchaseOrderEntity p WHERE p.status = 'Completed' AND p.store = :storeId");
        query.setParameter("storeId", storeId);
        PurchaseOrderEntity result = (PurchaseOrderEntity)query.getResultList();
        return result;
    }
    */
    
    /*
    public void confirmPODelivery(Long id) {
        Query query = entityManager.createQuery("SELECT p FROM PurchaseOrderEntity p WHERE p.id = :id");
        query.setParameter("id", id);
        PurchaseOrderEntity result = (PurchaseOrderEntity)query.getSingleResult();
        result.setStatus("Completed");
        List<MRPProductEntity> productList = result.getProducts();
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
}
