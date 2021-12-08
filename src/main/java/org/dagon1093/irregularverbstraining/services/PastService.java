package org.dagon1093.irregularverbstraining.services;

import org.dagon1093.irregularverbstraining.model.Participle;
import org.dagon1093.irregularverbstraining.model.Past;
import org.dagon1093.irregularverbstraining.model.Present;

import java.util.Set;

public interface PastService extends CrudService<Past, Long> {

    Present getPresent();
    Set<Participle> getParticiple();

}
