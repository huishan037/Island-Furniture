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
@Named(value = "iMSDeliveryOrderManagedBean")
@RequestScoped
public class IMSDeliveryOrderManagedBean {

    /**
     * Creates a new instance of IMSDeliveryOrderManagedBean
     */
    public IMSDeliveryOrderManagedBean() {
    }
    
        /*
    public List<SCMDeliveryOrderEntity> getPendingDeliveryOrder(){
        return inventorymanagement.getPendingDeliveryOrder(storeId);
    }
    */
    
    /*
    public List<SCMDeliveryOrderEntity> getCompletedDeliveryOrder(){
        return inventorymanagement.getCompletedDeliveryOrder(storeId);
    }
    */
    
    /*
    public void confirmDODelivery(Long id) {
        try {
            if (inventorymanagement.confirmDODelivery(id))) {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "The status of this delivery order has been changed.", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage("msgs",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "The status of this delivery order can't be changed.", ""));
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
}
