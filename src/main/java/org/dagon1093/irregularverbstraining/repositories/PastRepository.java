package org.dagon1093.irregularverbstraining.repositories;

import org.dagon1093.irregularverbstraining.model.Past;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastRepository extends CrudRepository<Past, Long> {
}
