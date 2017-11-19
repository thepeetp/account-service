package account.repository;

import account.domain.Account;
import account.dto.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("FROM Account a WHERE a.userRef = ? ORDER BY a.createdDate")
    Collection<Account> findByUserRef(String userRef);
}
