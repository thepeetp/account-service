package account.repository;

import account.domain.Account;
import account.dto.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AccountRepository extends JpaRepository<Account, String> {

    Collection<Account> findByUserRef(String userRef);
}
