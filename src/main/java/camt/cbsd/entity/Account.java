package camt.cbsd.entity;

import camt.cbsd.entity.security.Authority;
import camt.cbsd.entity.security.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pariy on 5/14/2017.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
    String password;
    String role;

    @OneToOne(mappedBy = "account")
    @JsonManagedReference
    User user;

    @JsonManagedReference
    private List<Authority> authorities;

    public List<Authority> getAuthorities(){
        return user.getAuthorities();
    }
}
