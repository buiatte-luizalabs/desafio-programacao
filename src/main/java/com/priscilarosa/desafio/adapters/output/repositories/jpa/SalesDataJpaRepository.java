package com.priscilarosa.desafio.adapters.output.repositories.jpa;

import com.priscilarosa.desafio.application.core.domain.entities.SalesDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDataJpaRepository extends JpaRepository<SalesDataEntity, Long> {
}
