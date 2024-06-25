package com.priscilarosa.desafio.adapters.input.api.controllers;

import com.priscilarosa.desafio.application.core.domain.entities.SalesDataEntity;
import com.priscilarosa.desafio.application.ports.input.SalesDataUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class SalesDataController {
    private final SalesDataUseCasePort salesDataUseCasePort;

    public SalesDataController(SalesDataUseCasePort salesDataUseCasePort) {
        this.salesDataUseCasePort = salesDataUseCasePort;
    }

    @GetMapping("/salesdata")
    public ModelAndView getSalesOder() {
        ModelAndView mv= new ModelAndView("index");
        List<SalesDataEntity> salesDataEntities = salesDataUseCasePort.getAll();
        mv.addObject("salesDataEntities", salesDataEntities);
        return mv;
    }
    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<List<SalesDataEntity>> uploadFile(@RequestParam("file") MultipartFile file, ModelMap modelMap) throws Exception {
        modelMap.addAttribute("file", file);
        return ResponseEntity.ok(salesDataUseCasePort.save(file));
    }
}
