package com.javi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javi.model.dto.ClienteDTO;
import com.javi.repository.dao.ClienteRepository;
import com.javi.repository.entity.Cuenta;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll() {
        log.info(this.getClass().getSimpleName() + " findAll: devolver todos los clientes");

        return this.clienteRepository.findAll().stream().map(c -> ClienteDTO.convertToDTO(c))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Long id) {
        log.info(this.getClass().getSimpleName() + " findById: devolver cliente con id: {}", id);

        return this.clienteRepository.findById(id).map(ClienteDTO::convertToDTO).orElse(null);
    }

    @Override
    public void save(ClienteDTO clienteDTO) {
        log.info(this.getClass().getSimpleName() + " save: guardar cliente con datos: {}", clienteDTO);

        Set<Cuenta> cuentas = new HashSet<>();

        if (clienteDTO.getId() != null) {
            cuentas = this.clienteRepository.findById(clienteDTO.getId()).get().getCuentas();
        }

        this.clienteRepository.save(ClienteDTO.convertToEntity(clienteDTO, cuentas));
    }

    @Override
    public void deleteById(Long id) {
        log.info(this.getClass().getSimpleName() + " deleteById: borrar cliente con id: {}", id);

        this.clienteRepository.deleteById(id);
    }

}