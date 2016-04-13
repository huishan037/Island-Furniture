/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package island.ims.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author HuiShan
 */
@Entity
public class IMSStoreProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private int type;
    private double price;
    private String storeId;
    private String location;
    private int totalQuantity;
    private int qtyInMarketplace;
    private int qtyInWarehouse;
    private int qtyInSelfService;
    private int qtyInDisplay;
    private int qtyInPickupArea;
    private int qtyInOutboundWarehouse;
    private int qtyInStore;
    /*
    private List<SCMDeliveryOrderEntity> deliveryOrder;
    private List<SCMPurchaseOrderEntity> purchaseOrder;
    private List<MRPProductEntity> productList;
    private StoreEntity store;
    */
    
    public IMSStoreProductEntity(){
        
    }
    
    public IMSStoreProductEntity(Long id, String productName, int type, double price, String storeId, String location, int totalQuantity, int qtyInMarketplace, int qtyInWarehouse, int qtyInSelfService, int qtyInDisplay, int qtyInPickupArea, int qtyInOutboundWarehouse){
        this.id = id;
        this.productName = productName;
        this.type = type;
        this.price = price;
        this.storeId = storeId;
        this.location = location;
        this.totalQuantity = totalQuantity;
        this.qtyInMarketplace = qtyInMarketplace;
        this.qtyInWarehouse = qtyInWarehouse;
        this.qtyInSelfService = qtyInSelfService;
        this.qtyInDisplay = qtyInDisplay;
        this.qtyInPickupArea = qtyInPickupArea;
        this.qtyInOutboundWarehouse = qtyInOutboundWarehouse;
    }
    
    public IMSStoreProductEntity(Long id, String productName, int type, double price, String storeId, int totalQuantity, int qtyInWarehouse, int qtyInStore){
        this.id = id;
        this.productName = productName;
        this.type = type;
        this.price = price;
        this.storeId = storeId;
        this.totalQuantity = totalQuantity;
        this.qtyInWarehouse = qtyInWarehouse;
        this.qtyInStore = qtyInStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getQtyInMarketplace() {
        return qtyInMarketplace;
    }

    public void setQtyInMarketplace(int qtyInMarketplace) {
        this.qtyInMarketplace = qtyInMarketplace;
    }

    public int getQtyInWarehouse() {
        return qtyInWarehouse;
    }

    public void setQtyInWarehouse(int qtyInWarehouse) {
        this.qtyInWarehouse = qtyInWarehouse;
    }

    public int getQtyInSelfService() {
        return qtyInSelfService;
    }

    public void setQtyInSelfService(int qtyInSelfService) {
        this.qtyInSelfService = qtyInSelfService;
    }

    public int getQtyInDisplay() {
        return qtyInDisplay;
    }

    public void setQtyInDisplay(int qtyInDisplay) {
        this.qtyInDisplay = qtyInDisplay;
    }

    public int getQtyInPickupArea() {
        return qtyInPickupArea;
    }

    public void setQtyInPickupArea(int qtyInPickupArea) {
        this.qtyInPickupArea = qtyInPickupArea;
    }

    public int getQtyInOutboundWarehouse() {
        return qtyInOutboundWarehouse;
    }

    public void setQtyInOutboundWarehouse(int qtyInOutboundWarehouse) {
        this.qtyInOutboundWarehouse = qtyInOutboundWarehouse;
    }

    public int getQtyInStore() {
        return qtyInStore;
    }

    public void setQtyInStore(int qtyInStore) {
        this.qtyInStore = qtyInStore;
    }
    
    /*
    public <any> getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(<any> deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }

    public <any> getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(<any> purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public <any> getProductList() {
        return productList;
    }

    public void setProductList(<any> productList) {
        this.productList = productList;
    }

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }
    
    */

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IMSStoreProductEntity)) {
            return false;
        }
        IMSStoreProductEntity other = (IMSStoreProductEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "island.ims.entity.IMSStoreProductEntity[ id=" + id + " ]";
    }
    
}
