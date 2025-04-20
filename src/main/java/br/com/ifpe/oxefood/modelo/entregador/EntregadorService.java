package br.com.ifpe.oxefood.modelo.entregador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EntregadorService {
    
    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {
        
        entregador.setHabilitado(Boolean.TRUE);

        // Salva o entregador no banco de dados usando o repositório e retorna o objeto gravado.
        return repository.save(entregador);
}}
