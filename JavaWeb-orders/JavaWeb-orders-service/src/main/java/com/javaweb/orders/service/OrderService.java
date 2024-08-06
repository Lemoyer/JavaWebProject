package com.javaweb.orders.service;

import com.javaweb.messagesdk.model.po.MqMessage;
import com.javaweb.orders.model.dto.AddOrderDto;
import com.javaweb.orders.model.dto.PayRecordDto;
import com.javaweb.orders.model.dto.PayStatusDto;
import com.javaweb.orders.model.po.XcPayRecord;

public interface OrderService {
    public PayRecordDto createOrder(String userId, AddOrderDto addOrderDto);
    public XcPayRecord getPayRecordByPayno(String payNo);
    public PayRecordDto queryPayResult(String payNo);
    public void saveAliPayStatus(PayStatusDto payStatusDto) ;
    public void notifyPayResult(MqMessage message);


}
