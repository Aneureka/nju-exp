package cn.edu.nju.service.impl;

import cn.edu.nju.dao.OrderDao;
import cn.edu.nju.factory.DaoFactory;
import cn.edu.nju.model.Order;
import cn.edu.nju.model.vo.OrderVO;
import cn.edu.nju.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hiki on 2017-12-20
 */

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    private static class holder {
        private static final OrderServiceImpl INSTANCE = new OrderServiceImpl();
    }

    private OrderServiceImpl() {
        orderDao = DaoFactory.getOrderDao();
    }

    public static OrderServiceImpl getInstance() {
        return OrderServiceImpl.holder.INSTANCE;
    }


    @Override
    public List<OrderVO> findOrderVOByCustomerId(int customerId, int page) {
        List<Order> orders = orderDao.findByCustomerId(customerId, page);
        return orders.stream().map(this::fromEntity).collect(Collectors.toList());
    }

    @Override
    public int findCount(int customerId) {
        return orderDao.findCount(customerId);
    }

    private OrderVO fromEntity(Order order) {

//        CustomerDao customerDao = DaoFactory.getCustomerDao();
//        ProductDao productDao = DaoFactory.getProductDao();
//        Customer customer = customerDao.findByCustomerId(order.getCustomerId());
//        Product product = productDao.findByProductId(order.getProductId());

//        return new OrderVO(order.getId(), customer.getName(), product.getName(),
//                product.getQuantity() - order.getQuantity() >= 0 ? order.getQuantity() : -1, // judge if out of store
//                order.getTotalPrice(), order.getCreatedAt());

        return new OrderVO(order.getId(), "家里蹲", "漫画",
                5 - order.getQuantity() >= 0 ? order.getQuantity() : -1, // judge if out of store
                order.getTotalPrice(), order.getCreatedAt());

    }
}
