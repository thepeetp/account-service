package account.resource;


import account.domain.Account;
import account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountResource {

    @Autowired
    private AccountRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public Account create(Account account) {
        return repository.save(account);
    }
}
