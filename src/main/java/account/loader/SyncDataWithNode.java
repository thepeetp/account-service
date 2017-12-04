package account.loader;

import account.domain.Account;
import account.repository.AccountRepository;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(50)
public class SyncDataWithNode implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    AccountRepository repository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        repository.findAll().forEach(this::sendPost);
    }


    private void sendPost(Account account) {
        try {
            Client client = Client.create();
            WebResource webResource = client
                    .resource("https://account-node.herokuapp.com/accounts");
            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, new Gson().toJson(account));
            if (response.getStatus() != 201 && response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
