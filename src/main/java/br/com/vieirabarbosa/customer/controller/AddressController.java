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

import br.com.vieirabarbosa.customer.DTO.AddressDTO;
import br.com.vieirabarbosa.customer.business.object.AddressBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/brasilprev")
@Api(value = "API REST Customer"
, tags = "Customer registration microservice"
, description = "This microservice has the responsibility to register, update, delete and list address.")
public class AddressController {
	@Autowired
	private AddressBO addressBO;
	@PostMapping(path = "/v1/customers/{idCustomer}/address")
	@ApiOperation(value = "This method creates new addresses")
	public @ResponseBody Boolean createAddress(
			@PathVariable("idCustomer") int idCustomer
			, @RequestBody AddressDTO address) {
		return addressBO.createAddressDTO(idCustomer, address);
	}
	@GetMapping(path = "/v1/customers/{idCustomer}/address")
	@ApiOperation(value = "This method lists all customer addresses by id")
	public @ResponseBody Object[] getAddressList(@PathVariable("idCustomer") int idCustomer) {
		return addressBO.getAddressList(idCustomer);
	}
	@GetMapping(path = "/v1/customers/{idCustomer}/address/{idAddress}")
	@ApiOperation(value = "This method displays a customer's address by id")
	public @ResponseBody AddressDTO getaddress(
			@PathVariable("idCustomer") int idCustomer
			, @PathVariable("idAddress") int idAddress) {
		return addressBO.getAddress(idCustomer, idAddress);
	}
	@PutMapping(path = "/v1/customers/{idCustomer}/address/{idAddress}")
	@ApiOperation(value = "This method updates a customer's address data by id")
	public @ResponseBody AddressDTO updateaddress(
			@PathVariable("idCustomer") int idCustomer
			, @RequestBody AddressDTO address
			, @PathVariable("idAddress") int idAddress) {
		return addressBO.updateAddress(idCustomer, idAddress, address);
	}
	@DeleteMapping(path = "/v1/customers/{idCustomer}/address/{idAddress}")
	@ApiOperation(value = "This method excludes an address from a customer's list by id")
	public @ResponseBody AddressDTO deleteaddress(
			@PathVariable("idCustomer") int idCustomer
			, @PathVariable("idAddress") int idAddress) {
		return addressBO.deleteAddress(idCustomer, idAddress);
	}
}
