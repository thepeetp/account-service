package account.resource;


import account.domain.Transaction;
import account.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class TransactionResource {

    @Autowired
    private TransactionRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
    }
}
