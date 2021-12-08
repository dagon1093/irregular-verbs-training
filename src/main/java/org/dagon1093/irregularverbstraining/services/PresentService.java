package org.dagon1093.irregularverbstraining.services;

import org.dagon1093.irregularverbstraining.model.Participle;
import org.dagon1093.irregularverbstraining.model.Past;
import org.dagon1093.irregularverbstraining.model.Present;
import org.dagon1093.irregularverbstraining.model.Translation;

import java.util.Set;

public interface PresentService extends CrudService<Present, Long> {

    Set<Past> getPast();
    Set<Participle> getParticiple();
    Translation getTranslation();

}
