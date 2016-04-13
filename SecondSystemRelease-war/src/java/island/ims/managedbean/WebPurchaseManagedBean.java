/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package island.ims.managedbean;

import island.ims.bean.WebPurchaseSessionLocal;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author HuiShan
 */
@Named(value = "webPurchaseManagedBean")
@RequestScoped
public class WebPurchaseManagedBean {

    @EJB
    private WebPurchaseSessionLocal webPurchase;
    
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
    
    public WebPurchaseManagedBean() {
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
    public List<SCMDeliveryOrderEntity> getPendingCustomerOrder(){
        return inventorymanagement.getPendingDeliveryOrder(storeId);
    }
    */
    
    /*
    public List<SCMDeliveryOrderEntity> getCompletedCustomerOrder(){
        return inventorymanagement.getCompletedDeliveryOrder(storeId);
    }
    */
    
    /*
    public void confirmCODelivery(Long id) {
        try {
            if (inventorymanagement.confirmCODelivery(id))) {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "The status of this customer order has been changed.", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "The status of this customer order can't be changed.", ""));
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public MRPProductEntity retrievePdtByBarcode(Long id) {
        return webPurchase.retrievePdtByBarcode(id);
    }
    
    public String[] getPOSPdtInfo(String storeId, Long barcode) {
        return getPOSPdtInfo(storeId, id);
    }
    
    public List<MRPProductEntity> retrievePdtByKeywords(String keywords){
        return retrievePdtByKeywords(keywords);
    }
    */
}
