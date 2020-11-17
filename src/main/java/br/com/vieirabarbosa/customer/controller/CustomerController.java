package br.com.vieirabarbosa.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vieirabarbosa.customer.DTO.CustomerDTO;
import br.com.vieirabarbosa.customer.business.object.CustomerBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/brasilprev")
@Api(value = "API REST Customer"
, tags = "Customer registration microservice"
, description = "This microservice has the responsibility to register, update, delete and list customers.")
public class CustomerController {
	@Autowired
	private CustomerBO customerBO;
	@PostMapping(path = "/v1/customers")
	@ApiOperation(value = "This method creates customer")
	public @ResponseBody Boolean createCustomer(@RequestBody CustomerDTO customer) {
		return customerBO.createCustomerDTO(customer);
	}
	@GetMapping(path = "/v1/customers")
	@ApiOperation(value = "This method lists all registered customer")
	public @ResponseBody Object[] getCustomers() {
		return customerBO.getCustomers();
	}
	@GetMapping(path = "/v1/customers/{id}")
	@ApiOperation(value = "This method fetches the customer by id")
	public @ResponseBody CustomerDTO getCustomers(@PathVariable("id") int idCustomer) {
		return customerBO.getCustomer(idCustomer);
	}
	@PutMapping(path = "/v1/customers/{id}")
	@ApiOperation(value = "This method updates the given customer data by id")
	public @ResponseBody CustomerDTO updateCustomer(
			@RequestBody CustomerDTO customer
			, @PathVariable("id") int idCustomer) {
		return customerBO.updateCustomer(idCustomer, customer);
	}
	@DeleteMapping(path = "/v1/customers/{id}")
	@ApiOperation(value = "This method excludes the customer from the list by id")
	public @ResponseBody CustomerDTO deleteCustomer(@PathVariable("id") int idCustomer) {
		return customerBO.deleteCustomer(idCustomer);
	}
}