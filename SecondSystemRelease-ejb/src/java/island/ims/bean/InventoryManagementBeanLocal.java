/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package island.ims.bean;

import island.ims.entity.IMSStoreProductEntity;
import island.ims.util.exception.ConflictException;
import island.mrp.entity.MRPProductEntity;
import java.util.List;
import javax.ejb.Local;

@Local
public interface InventoryManagementBeanLocal {

    public void updateFurnitureDetails(IMSStoreProductEntity s);
    public void updateRetailDetails(IMSStoreProductEntity s);
    public List<IMSStoreProductEntity> getAllStoreFurniture();
    public List<IMSStoreProductEntity> getAllRetailProducts();
    public Long addNewFurniture(Long id,String productName, int type, double price, String storeId, String location, int totalQuantity, int qtyInMarketplace, int qtyInWarehouse, int qtyInSelfService, int qtyInDisplay, int qtyInPickupArea, int qtyInOutboundWarehouse) throws ConflictException;
    public Long addNewRetailProduct(Long id,String productName, int type, double price, String storeId, int totalQuantity, int qtyInWarehouse, int qtyInStore) throws ConflictException;
    public void handleStockTransfer(String productName, int quantity, String currentLocation, String targetLocation, String storeId);
    public boolean deleteProduct(Long id, String storeId);
    public Long getProductID(String name);
    public double getProductPrice(String name);
    public List<MRPProductEntity> getFurnitureProduct();
    public List<MRPProductEntity> getProductRetail();
    
}
