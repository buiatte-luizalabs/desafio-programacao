package com.priscilarosa.desafio.application.ports.input;

import com.priscilarosa.desafio.application.core.domain.entities.SalesDataEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SalesDataUseCasePort {
    List<SalesDataEntity> getAll();
    List<SalesDataEntity> save(MultipartFile file) throws IOException;
}
