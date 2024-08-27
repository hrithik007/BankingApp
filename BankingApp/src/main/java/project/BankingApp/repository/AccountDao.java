package project.BankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.BankingApp.entity.Account;

public interface AccountDao extends JpaRepository<Account, Long> {
}
