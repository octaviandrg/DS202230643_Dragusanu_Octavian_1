package ro.tuc.ds2022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tuc.ds2022.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
