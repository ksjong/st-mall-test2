package stmalltest.domain;

import java.util.*;
import lombok.*;
import stmalltest.domain.*;
import stmalltest.infra.AbstractEvent;

@Data
@ToString
public class DeliveryReturned extends AbstractEvent {

    private Long id;
    private String userId;
    private Long orderId;
    private String productName;
    private Long productId;
    private Integer qty;
    private String status;
    private Date deliveryDt;
}
