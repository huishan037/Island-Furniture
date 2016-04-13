package island.mrp.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-10-25T17:28:26")
@StaticMetamodel(MRPProductEntity.class)
public class MRPProductEntity_ { 

    public static volatile SingularAttribute<MRPProductEntity, String> subCategory;
    public static volatile SingularAttribute<MRPProductEntity, String> productID;
    public static volatile SingularAttribute<MRPProductEntity, Boolean> requiresAssembly;
    public static volatile SingularAttribute<MRPProductEntity, String> careInstructions;
    public static volatile SingularAttribute<MRPProductEntity, Double> costPrice;
    public static volatile SingularAttribute<MRPProductEntity, Integer> label;
    public static volatile SingularAttribute<MRPProductEntity, String> designer;
    public static volatile SingularAttribute<MRPProductEntity, String> type;
    public static volatile SingularAttribute<MRPProductEntity, Date> creationDate;
    public static volatile SingularAttribute<MRPProductEntity, String> keyFeatures;
    public static volatile SingularAttribute<MRPProductEntity, String> facts;
    public static volatile SingularAttribute<MRPProductEntity, String> productName;
    public static volatile SingularAttribute<MRPProductEntity, Double> sellingPrice;
    public static volatile SingularAttribute<MRPProductEntity, String> packageMeasurement;
    public static volatile SingularAttribute<MRPProductEntity, Long> id;
    public static volatile SingularAttribute<MRPProductEntity, String> sourceDescription;
    public static volatile SingularAttribute<MRPProductEntity, String> category;
    public static volatile SingularAttribute<MRPProductEntity, Integer> productionTime;
    public static volatile SingularAttribute<MRPProductEntity, String> productDescription;
    public static volatile SingularAttribute<MRPProductEntity, String> dimensions;

}