package camt.cbsd.security.repository;


import camt.cbsd.entity.security.Authority;
import camt.cbsd.entity.security.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository <Authority,Long> {
    Authority findByName(AuthorityName input);
}
