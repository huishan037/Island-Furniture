/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package island.ims.bean;

import javax.ejb.Stateless;


@Stateless
public class IMSDeliveryOrderSession implements IMSDeliveryOrderSessionLocal {

    /*
    public List<SCMDeliveryOrderEntity> getPendingDeliveryOrder(String storeId) {
        Query query = entityManager.createQuery("SELECT p FROM SCMDeliveryOrderEntity p WHERE p.status = 'Pending' AND p.store = :storeId");
        query.setParameter("storeId", storeId);
        SCMDeliveryOrderEntity result = (SCMDeliveryOrderEntity)query.getResultList();
        return result;
    }
    */
    
    /*
    public List<SCMDeliveryOrderEntity> getCompletedDeliveryOrder(String storeId) {
        Query query = entityManager.createQuery("SELECT p FROM SCMDeliveryOrderEntity p WHERE p.status = 'Completed' AND p.store = :storeId");
        query.setParameter("storeId", storeId);
        SCMDeliveryOrderEntity result = (SCMDeliveryOrderEntity)query.getResultList();
        return result;
    }
    */
    
    /*
    public void confirmDODelivery(Long id) {
        Query query = entityManager.createQuery("SELECT p FROM SCMDeliveryOrderEntity p WHERE p.id = :id");
        query.setParameter("id", id);
        SCMDeliveryOrderEntity result = (SCMDeliveryOrderEntity)query.getSingleResult();
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
