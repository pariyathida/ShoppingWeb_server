package camt.cbsd.entity.security;

import camt.cbsd.config.json.View;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "true")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonView(View.Auth.class)
    @NonNull
    AuthorityName name;

}