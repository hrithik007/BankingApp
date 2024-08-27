package project.BankingApp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.BankingApp.dto.AccountDto;
import project.BankingApp.services.AccountService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;


    public  AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable ("id") Long id){
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable("id") Long Id, @RequestBody Map<String,Double> request){
        return new ResponseEntity<>(accountService.depositeAmount(Id,request.get("amount")),HttpStatus.OK);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable("id") Long Id, @RequestBody Map<String,Double> request){
        return new ResponseEntity<>(accountService.withdrawAmount(Id,request.get("amount")),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Account is delete Successfully",HttpStatus.OK);
    }

}
