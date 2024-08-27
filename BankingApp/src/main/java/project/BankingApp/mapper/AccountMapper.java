package project.BankingApp.mapper;

import project.BankingApp.dto.AccountDto;
import project.BankingApp.entity.Account;
import project.BankingApp.repository.AccountDao;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),accountDto.getAccountHolderName(),accountDto.getBalance()
        );
    return account;
    }

    public static  AccountDto mapTpAccountDto(Account account){
        AccountDto accountDto = new AccountDto(account.getId(),account.getAccountHolderName(),account.getBalance());
return accountDto;
    }
}
