/*
 * Author: Nurwidya Utami J
 */

package island.mrp.entity;

//import island.common.entity.MFEntity;
//import island.scm.entity.SCMMFInventoryEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author nurwidyauj
 */
@Entity
public class MRPProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String productID;
    private String productName;
    private Double costPrice;
    private Double sellingPrice;
    private String sourceDescription;
    private Integer label; // selling or not selling
    private String type;   // Furniture, retail product, or food
    private String category; // bedroom, living room, kitchen, furnishing, etc
    private String subCategory; // sofa, bed, cupboard etc
    private int productionTime; // in weeks
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    
    private String dimensions; // format: length-height-width-others
    private boolean requiresAssembly;
    private String keyFeatures;
    private String designer; // format: name-IKEA of Sweden-associated company if any
    private String packageMeasurement; // format: box dimensions and weight
    private String facts;
    private String careInstructions; // format: separate each instruction by a ;
    private String productDescription;
    
    /*
    @OneToMany(mappedBy="product") //(cascade={CascadeType.ALL}, 
    private List<MRPBOMEntity> bom = new ArrayList<MRPBOMEntity>();
    
    @OneToMany(mappedBy="product")
    private Collection<MRPMppEntity> mpp = new ArrayList<MRPMppEntity>();
    
    @OneToMany(mappedBy="product")
    private List<MRPMpsEntity> mps = new ArrayList<MRPMpsEntity>();
    
    @ManyToOne
    private MFEntity factory = new MFEntity();
    //@OneToOne(mappedBy="product")
    // SCMMFInventoryEntity mfInventory = new SCMMFInventoryEntity();
    */
    
    public MRPProductEntity(){
    }
    
    public void create(String productName, String productDescription, String sourceDescription, String type, String category, String subCategory, Date creationDate){
        this.setProductName(productName);
        this.setProductDescription(productDescription);
        this.setSourceDescription(sourceDescription);
        this.setLabel(1);
        this.setType(type);
        this.setCategory(category);
        this.setSubCategory(subCategory);
        this.setCreationDate(creationDate);
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRPProductEntity)) {
            return false;
        }
        MRPProductEntity other = (MRPProductEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MRPProductEntity[ id=" + id + " ]";
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getSourceDescription() {
        return sourceDescription;
    }

    public void setSourceDescription(String sourceDescription) {
        this.sourceDescription = sourceDescription;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*
    public List<MRPBOMEntity> getBom() {
        return bom;
    }

    public void setBom(List<MRPBOMEntity> bom) {
        this.bom = bom;
    }

    public Collection<MRPMppEntity> getMpp() {
        return mpp;
    }

    public void setMpp(Collection<MRPMppEntity> mpp) {
        this.mpp = mpp;
    }*/

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /*
    public List<MRPMpsEntity> getMps() {
        return mps;
    }

    public void setMps(List<MRPMpsEntity> mps) {
        this.mps = mps;
    }*/

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }
    
    /*
    public MFEntity getFactory() {
        return factory;
    }

    public void setFactory(MFEntity factory) {
        this.factory = factory;
    }*/

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isRequiresAssembly() {
        return requiresAssembly;
    }

    public void setRequiresAssembly(boolean requiresAssembly) {
        this.requiresAssembly = requiresAssembly;
    }

    public String getKeyFeatures() {
        return keyFeatures;
    }

    public void setKeyFeatures(String keyFeatures) {
        this.keyFeatures = keyFeatures;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getPackageMeasurement() {
        return packageMeasurement;
    }

    public void setPackageMeasurement(String packageMeasurement) {
        this.packageMeasurement = packageMeasurement;
    }

    public String getFacts() {
        return facts;
    }

    public void setFacts(String facts) {
        this.facts = facts;
    }

    public String getCareInstructions() {
        return careInstructions;
    }

    public void setCareInstructions(String careInstructions) {
        this.careInstructions = careInstructions;
    }
}
