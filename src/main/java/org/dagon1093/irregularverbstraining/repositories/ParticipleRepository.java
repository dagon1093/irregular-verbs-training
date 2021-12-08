package org.dagon1093.irregularverbstraining.repositories;

import org.dagon1093.irregularverbstraining.model.Participle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipleRepository extends CrudRepository<Participle, Long> {
}
