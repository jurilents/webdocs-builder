package org.obrii.fitdocs.core;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityWithId extends EntityBase<Integer> {
}

