package service;

import model.vo.OrderVO;

import java.util.List;

/**
 * @author hiki on 2017-12-30
 */

public interface OrderService {

    List<OrderVO> findOrderVOByCustomerId(int customerId, int page);

    int findCount(int customerId);
}
