package au.com.qsone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.qsone.entity.Property;

import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
    Optional<Property> findByOwner(String owner);

    Optional<Property> findByEmail(String email);
}
