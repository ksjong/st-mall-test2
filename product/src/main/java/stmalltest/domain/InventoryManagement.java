package stmalltest.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import stmalltest.ProductApplication;
import stmalltest.domain.StockDecreased;
import stmalltest.domain.StockIncreased;

@Entity
@Table(name = "InventoryManagement_table")
@Data
//<<< DDD / Aggregate Root
public class InventoryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private String productimg;

    private Integer stock;

    @PostUpdate
    public void onPostUpdate() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();

        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();
    }

    public static InventoryManagementRepository repository() {
        InventoryManagementRepository inventoryManagementRepository = ProductApplication.applicationContext.getBean(
            InventoryManagementRepository.class
        );
        return inventoryManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseStock(DeliveryCompleted deliveryCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        InventoryManagement inventoryManagement = new InventoryManagement();
        repository().save(inventoryManagement);

        StockDecreased stockDecreased = new StockDecreased(inventoryManagement);
        stockDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(inventoryManagement->{
            
            inventoryManagement // do something
            repository().save(inventoryManagement);

            StockDecreased stockDecreased = new StockDecreased(inventoryManagement);
            stockDecreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseStock(DeliveryReturned deliveryReturned) {
        //implement business logic here:

        /** Example 1:  new item 
        InventoryManagement inventoryManagement = new InventoryManagement();
        repository().save(inventoryManagement);

        StockIncreased stockIncreased = new StockIncreased(inventoryManagement);
        stockIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryReturned.get???()).ifPresent(inventoryManagement->{
            
            inventoryManagement // do something
            repository().save(inventoryManagement);

            StockIncreased stockIncreased = new StockIncreased(inventoryManagement);
            stockIncreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
