package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.BeneficiaryDto;
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
	
	
	public void addNewBeneficiary(BeneficiaryDto beneficiaryDto) {
		try {
			if(!accountRepository.exists(beneficiaryDto.getAccountNumber())) {
				throw new ServiceException("Beneficiary Account Does not exist");
			}
			else {
				if(beneficiaryRepository.checkIfAlreadyPresent(beneficiaryDto.getUserId(), beneficiaryDto.getAccountNumber())) {
					
					throw new ServiceException("Beneficiary Already Exists");
				}
				else
				{
				  List<Account> list=accountRepository.findAccountByUserId(beneficiaryDto.getUserId());
				  for(Account a:list) {
					  if(a.getAccountNumber()== beneficiaryDto.getAccountNumber())
						  throw new ServiceException("Cannot Add Yourself as Beneficiary");
				  }
				  
				  Beneficiary b=new Beneficiary();
				  User user=beneficiaryRepository.fetchById(User.class, beneficiaryDto.getUserId());
				  Account account=(Account) accountRepository.findAccountByUserId(beneficiaryDto.getUserId());
				
			      b.setUserId(user); 
				  b.setAccount(account);
				  b.setBeneficiaryName(beneficiaryDto.getBeneficiaryName());
				  b.setBeneficiaryNickName(beneficiaryDto.getBeneficiaryNickName());
				  beneficiaryRepository.save(b);
				  
				  
				}
			}
		}catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}

}
