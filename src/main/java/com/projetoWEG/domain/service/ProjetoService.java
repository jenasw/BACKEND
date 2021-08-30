package com.projetoWEG.domain.service;

import com.projetoWEG.api.assembler.ProjetoAssembler;
import com.projetoWEG.api.model.dto.ProjetoDTO;
import com.projetoWEG.api.model.dto.ProjetoFornecedorDTO;
import com.projetoWEG.domain.model.Projeto;
import com.projetoWEG.domain.model.StatusProjeto;
import com.projetoWEG.domain.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProjetoService {

    private ProjetoRepository projetoRepository;
    private ProjetoAssembler projetoAssembler;
    public List<Projeto> listarTodos() {

        return projetoRepository.findAll();
    }

    public ResponseEntity<ProjetoFornecedorDTO> listarId(Long id) {
        return projetoAssembler.toFornecedor(projetoRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()));
    }
    public ResponseEntity<ProjetoFornecedorDTO> listarNome(String nome) {
        return projetoRepository.findByNome(nome).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    public List<Projeto> listarSecao(String secao) {

        return projetoRepository.findBySecao(secao);
    }
    public List<Projeto> listarContaining(String contain) {
        return projetoRepository.findByNomeContaining(contain);
    }
    public List<Projeto> listarStatus(StatusProjeto status) {
        return projetoRepository.findByStatus(status);
    }
}
