package stmalltest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmalltest.domain.*;
import stmalltest.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private String userid;
    private String productName;
    private Long productId;
    private Integer qty;
    private String status;
    private Date orderDt;

    public OrderCancelled(Order aggregate) {
        super(aggregate);
    }

    public OrderCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
