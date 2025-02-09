package com.sunBaseAssignment.Controller;




import com.sunBaseAssignment.Entity.Customer;
import com.sunBaseAssignment.Service.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerViewController {
//
    @Autowired
    private CustomerServiceImpl customerService;
//

//
    @GetMapping("/customers")
    public String listCustomers(Model model, @RequestParam(value = "search", required = false) String search) {
        List<Customer> customers = customerService.findAllCustomer(search);
        model.addAttribute("customers", customers);
        return "CustomerDetail";
    }
//
    @GetMapping("/customers/new")
    public String newCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }
//
    @PostMapping("/customers/new")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
//
    @GetMapping("/customers/edit/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "editCustomer";
    }
//
    @PostMapping("/customers/edit/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute Customer customer) {
        customerService.updateCustomer(id, customer);
        return "redirect:/customers";
    }
//
    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

//    @PostMapping("/sync")
//    @ResponseBody
//    public void syncCustomers() {
//        customerService.syncCustomers();
//    }
}
