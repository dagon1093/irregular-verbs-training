package org.dagon1093.irregularverbstraining.services;

import org.dagon1093.irregularverbstraining.model.Participle;
import org.dagon1093.irregularverbstraining.model.Past;
import org.dagon1093.irregularverbstraining.model.Present;

import java.util.Set;

public interface ParticipleService extends CrudService<Participle,Long> {

    Present getPresent();
    Set<Past> getPast();
}
