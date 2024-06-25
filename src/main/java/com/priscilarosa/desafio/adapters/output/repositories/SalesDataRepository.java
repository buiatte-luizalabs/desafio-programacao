package com.priscilarosa.desafio.adapters.output.repositories;

import com.priscilarosa.desafio.adapters.output.repositories.jpa.SalesDataJpaRepository;
import com.priscilarosa.desafio.application.core.domain.entities.SalesDataEntity;
import com.priscilarosa.desafio.application.ports.output.SalesDataRepositoryPort;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public class SalesDataRepository implements SalesDataRepositoryPort {
    private SalesDataJpaRepository repository;
    public SalesDataRepository(SalesDataJpaRepository repository){
        this.repository = repository;
    }

    @Override
    public List<SalesDataEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public List<SalesDataEntity> save(Set<SalesDataEntity> salesDataEntity) {
        List<SalesDataEntity> save = repository.saveAll(salesDataEntity);
        return save;
    }
}
