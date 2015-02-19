package org.partsystem.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.partsystem.model.Customer;
import org.partsystem.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

	private static final Logger logger = Logger.getLogger(CustomerController.class);
    
    @Autowired
	private CustomerServiceImpl customerService;
    
    @RequestMapping("/index")
    public String getCustomers(Map<String, Object> map) {

        map.put("customer", new Customer());
        map.put("customerList", customerService.getCustomers());

        return "customer";
    }
    
    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer,
            BindingResult result) {
    	logger.info(String.format("addCustomer(): id = %s, name = %s", customer.getId(), customer.getName()));
    	customerService.addCustomer(customer);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{customerId}")
    public String deleteContact(@PathVariable("customerId") Integer customerId) {

    	customerService.removeCustomer(customerId);

        return "redirect:/index";
    }

}
