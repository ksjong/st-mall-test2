package stmalltest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmalltest.domain.*;
import stmalltest.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private String userid;
    private String productName;
    private Long productId;
    private Integer qty;
    private String status;
    private Date orderDt;
    private String address;

    public Ordered(Order aggregate) {
        super(aggregate);
    }

    public Ordered() {
        super();
    }
}
//>>> DDD / Domain Event
