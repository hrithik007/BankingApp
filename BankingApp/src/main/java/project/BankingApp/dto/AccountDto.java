package project.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {

    private Long Id;
    private String accountHolderName;
    private double balance;

}
