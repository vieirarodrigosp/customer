package br.com.vieirabarbosa.customer.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddressDTO {
	public String street;
	public String number;
	public String district;
	public String complement;
	public String state;
	public String country;
	public String status;
	public String type;
}