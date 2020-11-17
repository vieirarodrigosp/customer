package br.com.vieirabarbosa.customer.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerDTO {
	public String name;
	public String cpf;
	public List<AddressDTO> addressList;
}