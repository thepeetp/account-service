package account.resource;


import account.domain.Account;
import account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
public class AccountResource {

    @Autowired
    private AccountRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Account create(@RequestBody Account account) {
        return repository.save(account);
    }
}
