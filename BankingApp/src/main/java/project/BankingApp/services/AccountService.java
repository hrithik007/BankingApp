package project.BankingApp.services;

import project.BankingApp.dto.AccountDto;
import project.BankingApp.entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long Id);

    AccountDto depositeAmount(Long Id, double amount);
    AccountDto withdrawAmount(Long Id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long Id);
}
