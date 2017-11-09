package account.resource;


import account.domain.Account;
import account.dto.AccountDTO;
import account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("accounts")
public class AccountResource {

    @Autowired
    private AccountRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Account create(@RequestHeader("User-Ref") String userRef, @RequestBody AccountDTO account) {
        return repository.save(account.toEntity(userRef));
    }


    @RequestMapping
    @ResponseBody
    public Collection<AccountDTO> getAll(@RequestHeader("User-Ref") String userRef) {
        return repository.findByUserRef(userRef).stream().map(AccountDTO::new).collect(Collectors.toList());
    }
}
