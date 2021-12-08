package org.dagon1093.irregularverbstraining.repositories;

import org.dagon1093.irregularverbstraining.model.Present;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresetRepository extends CrudRepository<Present,Long> {

}
