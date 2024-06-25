package com.priscilarosa.desafio.application.ports.output;

import com.priscilarosa.desafio.application.core.domain.entities.SalesDataEntity;
import java.util.List;
import java.util.Set;

public interface SalesDataRepositoryPort {
    List<SalesDataEntity> getAll();
    List<SalesDataEntity> save(Set<SalesDataEntity> salesDataEntity);
}
