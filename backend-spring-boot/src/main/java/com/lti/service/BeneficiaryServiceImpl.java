package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.AddBeneficiaryDto;
import com.lti.dto.ShowBeneficiaryDto;
import com.lti.entity.Account;
import com.lti.entity.Beneficiary;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.repository.AccountRepository;
import com.lti.repository.BeneficiaryRepository;
import com.lti.repository.GenericRepository;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficaryService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	public void addNewBeneficiary(AddBeneficiaryDto beneficiaryDto) {

		try {
			if (!accountRepository.exists(beneficiaryDto.getAccountNumber())) {
				throw new ServiceException("Beneficiary Account Does not exist");
			} else {
				if (beneficiaryRepository.checkIfAlreadyPresent(beneficiaryDto.getUserId(),
						beneficiaryDto.getAccountNumber())) {

					throw new ServiceException("Beneficiary Already Exists");
				} else {
					Account account = accountRepository.findAccountByUserId(beneficiaryDto.getUserId());
					if (account.getAccountNumber() == beneficiaryDto.getAccountNumber())
						throw new ServiceException("Cannot Add Yourself as Beneficiary");

					Beneficiary b = new Beneficiary();
					User user = beneficiaryRepository.fetchById(User.class, beneficiaryDto.getUserId());

					b.setUser(user);
					b.setAccount(account);
					b.setBeneficiaryName(beneficiaryDto.getBeneficiaryName());
					b.setBeneficiaryNickName(beneficiaryDto.getBeneficiaryNickName());
					beneficiaryRepository.save(b);

				}
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public List<ShowBeneficiaryDto> fetchBeneficiary(int userId) {
		List<ShowBeneficiaryDto> listOfBeneficiaries = new ArrayList<>();
		try {
			if (beneficiaryRepository.checkIfAnyBeneficiaryExist(userId)) {
				List<Beneficiary> list = beneficiaryRepository.fetchBeneficiaryList(userId);
				for (Beneficiary b : list) {
					ShowBeneficiaryDto beneficiaryDto = new ShowBeneficiaryDto();
					beneficiaryDto.setAccountNo(b.getAccount().getAccountNumber());
					beneficiaryDto.setBeneficiaryName(b.getBeneficiaryName());
					beneficiaryDto.setBeneficiaryNickName(b.getBeneficiaryNickName());
					listOfBeneficiaries.add(beneficiaryDto);
				}
			} else
				throw new ServiceException("No Existing Beneficiary");

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

		return listOfBeneficiaries;
	}

}
