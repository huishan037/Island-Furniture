/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package island.ims.managedbean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author HuiShan
 */
@Named(value = "iMSPurchaseOrderManagedBean")
@RequestScoped
public class IMSPurchaseOrderManagedBean {

    /**
     * Creates a new instance of IMSPurchaseOrderManagedBean
     */
    public IMSPurchaseOrderManagedBean() {
    }
    
        /*
    public List<SCMDeliveryOrderEntity> getPendingPurchaseOrder(){
        return inventorymanagement.getPendingDeliveryOrder(storeId);
    }
    */
    
    /*
    public List<SCMDeliveryOrderEntity> getCompletedPurchaseOrder(){
        return inventorymanagement.getCompletedDeliveryOrder(storeId);
    }
    */
    
    /*
    public void confirmPODelivery(Long id) {
        try {
            if (inventorymanagement.confirmPODelivery(id))) {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "The status of this purchase order has been changed.", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "The status of this purchase order can't be changed.", ""));
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
    
}
