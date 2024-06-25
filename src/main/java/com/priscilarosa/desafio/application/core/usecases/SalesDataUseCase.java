package com.priscilarosa.desafio.application.core.usecases;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.priscilarosa.desafio.application.core.domain.dtos.SalesDataCsvRepresentationDTO;
import com.priscilarosa.desafio.application.core.domain.dtos.SalesDataDTO;
import com.priscilarosa.desafio.application.core.domain.entities.SalesDataEntity;
import com.priscilarosa.desafio.application.ports.input.SalesDataUseCasePort;
import com.priscilarosa.desafio.application.ports.output.SalesDataRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesDataUseCase implements SalesDataUseCasePort {
    private final SalesDataRepositoryPort salesDataRepositoryPort;

    @Override
    public List<SalesDataEntity> getAll() {
        return salesDataRepositoryPort.getAll();
    }

    @Override
    public List<SalesDataEntity> save(MultipartFile file) throws IOException {
        Set<SalesDataEntity> salesDataEntity = parseCsv(file);
        List<SalesDataDTO> salesDataDTOS = new ArrayList();
        return salesDataRepositoryPort.save(salesDataEntity);
    }
    private Set<SalesDataEntity> parseCsv(MultipartFile file) throws IOException {
        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<SalesDataCsvRepresentationDTO> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(SalesDataCsvRepresentationDTO.class);
            CsvToBean<SalesDataCsvRepresentationDTO> csvToBean =
                    new CsvToBeanBuilder<SalesDataCsvRepresentationDTO>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .withSeparator('\t')
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> SalesDataEntity.builder()
                            .purchaserName(csvLine.getPurchaserName())
                            .itemDescription(csvLine.getItemDescription())
                            .itemPrice(csvLine.getItemPrice())
                            .purchaseCount(csvLine.getPurchaseCount())
                            .merchantAddress(csvLine.getMerchantAddress())
                            .merchantName(csvLine.getMerchantName())
                            .build()
                    )
                    .collect(Collectors.toSet());
        }
    }
}

