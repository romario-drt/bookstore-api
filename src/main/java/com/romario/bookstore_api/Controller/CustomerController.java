package com.romario.bookstore_api.Controller;

import com.romario.bookstore_api.custom.converter.ReqToCustomer;
import com.romario.bookstore_api.exception.PasswordMismatchException;
import com.romario.bookstore_api.model.entity.Customer;
import com.romario.bookstore_api.model.request.CustomerReq;
import com.romario.bookstore_api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ReqToCustomer reqToCustomerConverter;


    @GetMapping("/{id}")
    public Customer single(@PathVariable int id, CustomerReq newCustomer) {
        return customerService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody @Valid CustomerReq customerReq) {

        if (!(customerReq.getPassword().equals(customerReq.getPassword2()))) {
            throw new PasswordMismatchException();
        }

        Customer toSave = reqToCustomerConverter.convert(customerReq);

        return customerService.save(toSave);
    }

}
