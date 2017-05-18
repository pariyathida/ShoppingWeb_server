package camt.cbsd.config;

/**
 * Created by Lenovo on 17-Apr-17.
 */

import camt.cbsd.dao.ProductDao;
import camt.cbsd.entity.Product;
import camt.cbsd.entity.User;
import camt.cbsd.entity.security.Authority;
import camt.cbsd.entity.security.AuthorityName;
import camt.cbsd.repository.UserRepository;
import camt.cbsd.security.repository.AuthorityRepository;
import camt.cbsd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@ConfigurationProperties(prefix="server")
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    ProductDao productDao;

    User user1,user2,user3;

//    @Autowired
//    public void setProductDao(ProductDao productDao){
//        this.productDao = productDao;
//    }




    String baseUrl;
    String imageUrl;
    String imageBaseUrl;
    public void setBaseUrl (String baseUrl){
        this.baseUrl = baseUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    UserRepository userSecurityRepository;
    @Autowired
    public void setUserSecurityRepository(UserRepository userSecurityRepository) {
        this.userSecurityRepository = userSecurityRepository;
    }

    AuthorityRepository authorityRepository;
    @Autowired
    public void setAuthorityRepository(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Product product1 = Product.builder().name("Canon EOS M10").description("Mirrorless camera").pictures("eosm10.jpg").price(13890).amount(10).rating(8.25).build();
        Product product2 = Product.builder().name("Fujifilm XA3").description("Mirrorless camera").pictures("xa3.jpg").price(23190).amount(10).rating(8.00).build();
        productDao.addProduct(product1);
        productDao.addProduct(product2);
        securitySetup();

    }

    private void securitySetup() {

        Authority auth1 = Authority.builder().name(AuthorityName.ROLE_CUSTOMER).build();
        Authority auth2 = Authority.builder().name(AuthorityName.ROLE_SHOPKEEPER).build();
        Authority auth3 = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();

        authorityRepository.save(auth1);
        authorityRepository.save(auth2);
        authorityRepository.save(auth3);


        user1 = User.builder()
                .username("customer")
                .password("customer")
                .build();
        user2 = User.builder()
                .username("shopkeeper")
                .password("shopkeeper")
                .build();
        user3 = User.builder()
                .username("admin")
                .password("admin")
                .build();
        //customer
        user1.addAuthority(auth1);

        //shopkeeper
        user2.addAuthority(auth1);
        user2.addAuthority(auth2);

        //admin
        user3.addAuthority(auth1);
        user3.addAuthority(auth2);
        user3.addAuthority(auth3);

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

    }
}
