package com.javi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javi.model.dto.CuentaDTO;
import com.javi.repository.dao.ClienteRepository;
import com.javi.repository.dao.CuentaRepository;
import com.javi.repository.entity.Cliente;
import com.javi.repository.entity.Movimiento;


@Service
public class CuentaServiceImpl implements CuentaService {

    private static final Logger log = LoggerFactory.getLogger(CuentaServiceImpl.class);

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<CuentaDTO> findAllByCliente(Long idCliente) {
        log.info(this.getClass().getSimpleName()
                + " devolvemos todas las cuentas del cliente con id: " + idCliente);

        return this.cuentaRepository.findAllByCliente(idCliente).stream().map(c -> CuentaDTO.convertToDTO(c))
                .collect(Collectors.toList());
    }

    @Override
    public CuentaDTO findById(Long id) {
        log.info(this.getClass().getSimpleName() + "  devolvemos la cuenta con el id: " + id);

        return this.cuentaRepository.findById(id).map(CuentaDTO::convertToDTO).orElse(null);
    }

    @Override
    public void save(CuentaDTO cuentaDTO, Long idCliente) {
        log.info(this.getClass().getSimpleName() + " guardamos la cuenta con datos: " + cuentaDTO);

        if (cuentaDTO.getId() != null) {
            Cliente cliente = this.clienteRepository.findById(idCliente).orElse(null);

            this.cuentaRepository
                    .save(CuentaDTO.convertToEntity(cuentaDTO, cliente));

        } else {
            this.cuentaRepository
                    .save(CuentaDTO.convertToEntity(cuentaDTO,
                            this.clienteRepository.findById(idCliente).orElse(null)));
        }

    }

    @Override
    public void deleteById(Long id) {
        log.info(this.getClass().getSimpleName() + " borramos cuenta con el id: " + id);

        this.cuentaRepository.deleteById(id);
    }
}
