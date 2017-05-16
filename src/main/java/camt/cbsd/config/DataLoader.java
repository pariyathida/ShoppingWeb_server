package camt.cbsd.config;

/**
 * Created by Lenovo on 17-Apr-17.
 */

import camt.cbsd.dao.ProductDao;
import camt.cbsd.entity.Product;
import camt.cbsd.entity.security.Authority;
import camt.cbsd.entity.security.AuthorityName;
import camt.cbsd.entity.security.User;
import camt.cbsd.security.repository.AuthorityRepository;
import camt.cbsd.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


@ConfigurationProperties(prefix="server")
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    ProductDao productDao;
    User user1,user2,user3,user4;

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

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Product product1 = Product.builder().name("Canon EOS M10").description("Mirrorless camera").pictures("eosm10.jpg").price(13890).amount(10).rating(8.25).build();
        Product product2 = Product.builder().name("Fujifilm XA3").description("Mirrorless camera").pictures("xa3.jpg").price(23190).amount(10).rating(8.00).build();
        productDao.addProduct(product1);
        productDao.addProduct(product2);
        securitySetup();

    }

    private void securitySetup() {
        user1 = User.builder()
                .username("admin")
                .password("admin")
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user")
                .password("user")
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user4 = User.builder()
                .username("disabled")
                .password("disabled")
                .firstname("user")
                .lastname("user")
                .email("disabled@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        Authority auth1 = Authority.builder().name(AuthorityName.ROLE_CUSTOMER).build();
        Authority auth2 = Authority.builder().name(AuthorityName.ROLE_SHOPKEEPER).build();
        Authority auth3 = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        authorityRepository.save(auth1);
        authorityRepository.save(auth2);
        authorityRepository.save(auth3);
        user1.setAuthorities(new ArrayList<>());
        user1.getAuthorities().add(auth1);
        user1.getAuthorities().add(auth2);
        user1.getAuthorities().add(auth3);
        user2.setAuthorities(new ArrayList<>());
        user2.getAuthorities().add(auth1);
        user2.getAuthorities().add(auth2);
        user3.setAuthorities(new ArrayList<>());
        user3.getAuthorities().add(auth1);
        user4.setAuthorities(new ArrayList<>());
        user4.getAuthorities().add(auth1);

        userSecurityRepository.save(user1);
        userSecurityRepository.save(user2);
        userSecurityRepository.save(user3);
    }
}
