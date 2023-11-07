package stmalltest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmalltest.domain.*;
import stmalltest.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StockDecreased extends AbstractEvent {

    private Long id;
    private String productName;
    private String productimg;
    private Integer stock;

    public StockDecreased(InventoryManagement aggregate) {
        super(aggregate);
    }

    public StockDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
