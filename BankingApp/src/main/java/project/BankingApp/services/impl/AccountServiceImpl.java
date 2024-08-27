package project.BankingApp.services.impl;

import org.springframework.stereotype.Service;
import project.BankingApp.Exception.BankingExceptions;
import project.BankingApp.dto.AccountDto;
import project.BankingApp.entity.Account;
import project.BankingApp.mapper.AccountMapper;
import project.BankingApp.repository.AccountDao;
import project.BankingApp.services.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;


    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountDao.save(account);
        return AccountMapper.mapTpAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long Id) {
        Account account = accountDao.findById(Id).orElseThrow(()-> new BankingExceptions("Account Does not Exist with ID :"+Id));
        return AccountMapper.mapTpAccountDto(account);
    }

    @Override
    public AccountDto depositeAmount(Long Id, double amount) {
        Account account = accountDao.findById(Id).orElseThrow(()-> new BankingExceptions("No Account found with Id :"+Id));
        double balance  = account.getBalance() + amount;
        account.setBalance(balance);
        return AccountMapper.mapTpAccountDto(accountDao.save(account));
    }

    @Override
    public AccountDto withdrawAmount(Long Id, double amount) {
        Account account = accountDao.findById(Id).orElseThrow(()-> new BankingExceptions("No Account found with Id :"+Id));
        double balance  = account.getBalance() - amount;
        account.setBalance(balance);
        return AccountMapper.mapTpAccountDto(accountDao.save(account));

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountDao.findAll();
        return accounts.stream().map((account -> AccountMapper.mapTpAccountDto(account))).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long Id) {
        Account account = accountDao.findById(Id).orElseThrow(()-> new BankingExceptions("No Account found with Id :"+Id));
        accountDao.deleteById(Id);
    }


}
