package com.romario.bookstore_api.custom.converter;

import com.romario.bookstore_api.model.entity.Customer;
import com.romario.bookstore_api.model.request.CustomerReq;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToCustomer implements Converter<CustomerReq, Customer> {
    @Override
    public Customer convert(CustomerReq source) {
        Customer customer = new Customer();
        customer.setFirstname(source.getFirstname());
        customer.setLastname(source.getLastname());
        customer.setEmail(source.getEmail());
        customer.setPassword(source.getPassword());
        customer.setAdmin(source.isAdmin());

        return customer;
    }
}
