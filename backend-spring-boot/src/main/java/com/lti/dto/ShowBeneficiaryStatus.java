package com.lti.dto;

import java.util.List;

public class ShowBeneficiaryStatus extends Status {
	
	private List<ShowBeneficiaryDto> beneficiaryDto;

	public List<ShowBeneficiaryDto> getBeneficiaryDto() {
		return beneficiaryDto;
	}

	public void setBeneficiaryDto(List<ShowBeneficiaryDto> beneficiaryDto) {
		this.beneficiaryDto = beneficiaryDto;
	}
	
	
	

}
