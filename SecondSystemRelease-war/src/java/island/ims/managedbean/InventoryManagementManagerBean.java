package island.ims.managedbean;

import island.ims.bean.InventoryManagementBeanLocal;
import island.ims.entity.IMSStoreProductEntity;
import island.ims.util.exception.ConflictException;
import island.mrp.entity.MRPProductEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;

@Named(value = "immb")
@RequestScoped
public class InventoryManagementManagerBean {
    
    @EJB
    private InventoryManagementBeanLocal inventorymanagement;
    
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
    
    private List<IMSStoreProductEntity> allStoreFurniture;
    private List<IMSStoreProductEntity> allRetailProduct;
    private List<MRPProductEntity> allMRPFurnitureProduct;
    private String statusMessage;
    private String[] productList;
    
    public InventoryManagementManagerBean() {
        /*
        FacesContext fctx=FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest)fctx.getExternalContext().getRequest();
        HttpSession session = req.getSession();
        storeId = (String)session.getAttribute("facility");
        */
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
    
    public List<IMSStoreProductEntity> getAllStoreFurniture() {
        if (allStoreFurniture == null) {
            allStoreFurniture = inventorymanagement.getAllStoreFurniture();
        }
        return allStoreFurniture;
    }
    
    public List<IMSStoreProductEntity> getAllRetailProduct() {
        if (allRetailProduct == null) {
            allRetailProduct = inventorymanagement.getAllRetailProducts();
        }
        return allRetailProduct;
    }
    
    
    public String[] getFurnitureProduct(){
        if (allMRPFurnitureProduct == null) {
            allMRPFurnitureProduct = inventorymanagement.getFurnitureProduct();
        }
        productList = allMRPFurnitureProduct.toArray(new String[allMRPFurnitureProduct.size()]);
        return productList;
    }
    
    
    public String[] getRetailProduct(){
        if (allMRPFurnitureProduct == null) {
            allMRPFurnitureProduct = inventorymanagement.getProductRetail();
        }
        productList = allMRPFurnitureProduct.toArray(new String[allMRPFurnitureProduct.size()]);
        return productList;
    }
    
    
    
     public void saveNewFurniture(ActionEvent event) {
        try {
            Long pdtID = inventorymanagement.getProductID(productName);
            double pdtprice = inventorymanagement.getProductPrice(productName);
            inventorymanagement.addNewFurniture(pdtID, productName, type, pdtprice, storeId, location, totalQuantity, qtyInMarketplace, qtyInWarehouse, qtyInSelfService, qtyInDisplay, qtyInPickupArea, qtyInOutboundWarehouse);
            statusMessage = "New Store Furniture Saved Successfully";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Add New Furniture Result: " + statusMessage, ""));
        } catch (ConflictException fce) {
            statusMessage = "Furniture is already selling in the store";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Add New Furniture Result: " + statusMessage, ""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /*
    public void saveNewRetail(ActionEvent event) {
        try {
            double pdtprice = inventorymanagement.getProductPrice(productName);
            inventorymanagement.addNewRetailProduct(id, productName, type, price, storeId, totalQuantity, qtyInWarehouse, qtyInStore);
            statusMessage = "New Retail Product Saved Successfully";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Add New Furniture Result: " + statusMessage, ""));
        } catch (ConflictException fce) {
            statusMessage = "Retail Product is already selling in the store";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Add New Furniture Result: " + statusMessage, ""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     
    public void onEditFurniture(RowEditEvent event) {
        IMSStoreProductEntity s = (IMSStoreProductEntity) event.getObject();
        inventorymanagement.updateFurnitureDetails(s);
        FacesMessage msg = new FacesMessage("Item Edited", ((IMSStoreProductEntity) event.getObject()).getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    */
    
    public void onEditRetail(RowEditEvent event) {
        IMSStoreProductEntity s = (IMSStoreProductEntity) event.getObject();
        inventorymanagement.updateRetailDetails(s);
        FacesMessage msg = new FacesMessage("Item Edited", ((IMSStoreProductEntity) event.getObject()).getProductName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onCancel(RowEditEvent event) {

    }
    
    public void deleteFurniture(Long id) {
        try {
            if (inventorymanagement.deleteProduct(id, storeId)) {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "This furniture has been permanently deleted.", ""));
                FacesContext.getCurrentInstance().getExternalContext().redirect("editFurnitureProduct.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "This furniture can't be deleted.", ""));
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteRetail(Long id) {
        try {
            if (inventorymanagement.deleteProduct(id, storeId)) {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "This retail product has been permanently deleted.", ""));
                FacesContext.getCurrentInstance().getExternalContext().redirect("editRetailProduct.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "This retail product can't be deleted.", ""));
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

    

    
    
    public void handleStockTransfer(ActionEvent event) {
        try {
            inventorymanagement.handleStockTransfer(productName, totalQuantity, location, location, storeId);
            statusMessage = "Stock Transfer Handled Successfully";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Stock Transfer Result: " + statusMessage, ""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
 
}
