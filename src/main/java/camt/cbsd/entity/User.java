package camt.cbsd.entity;

import camt.cbsd.config.json.View;
import camt.cbsd.entity.security.Authority;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "true")
public class User {

    @JsonView(View.Auth.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonView(View.Auth.class)
    @NonNull
    String username;

    @NonNull
    String password;

    @JsonView(View.Auth.class)
    @ManyToMany
    List<Authority> authorities;

    public void addAuthority(Authority authority){
        if(authorities==null){
            authorities = new ArrayList<>();
        }
        authorities.add(authority);
    }

}
