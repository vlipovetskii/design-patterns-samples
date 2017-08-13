package dzone.grzegorztj;

import java.math.BigDecimal;

/**
 * https://dzone.com/articles/aggregate-pattern
 */
public class Aggregate {
}

/*
//@Entity
class Order {
    private String id;
    private Instant date;
    private List<OrderPosition> orderPositions;
    // stuff
}

// @Entity
class Order {
    private String id;
    private Instant date;
    private List<OrderPosition> orderPositions;
    // stuff
}
*/

// @Entity
class OrderPosition {
    private String id;
    private String name;
    private BigDecimal quantity;
    // stuff
}

//@Entity
class Order {
    private String id;
    private Long version; // optimistic locking!

    // other fields, c-tor
/*
    public void addPosition(Product product, BigDecimal quantity) {
        if (hasMaxPositions()) {
            throw new TooManyPositionsException(id);
        }
        if (valueTooHigh(product.getPrice().times(quantity))) {
            throw new ValueTooHighException(id);
        }
        // stuff
    }
*/
}

class OrderService {
    // fields, c-tor
//    @Transactional
/*
    public void addPosition(String orderId, String productId, BigDecimal quantity) {
        Order order = orderRepository.findById(orderId);
        Product product = productRepository.findById(productId);
        order.addPosition(product, quantity);
        orderRepository.save(order);
    }
*/
}