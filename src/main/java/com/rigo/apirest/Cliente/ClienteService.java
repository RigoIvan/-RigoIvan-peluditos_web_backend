package com.rigo.apirest.Cliente;

import java.util.List; // Importa List

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepo;

    @Autowired
    public void createCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    public Optional<Cliente> findClienteById(Integer id) {
        return clienteRepo.findById(id);
    }

    public List<Cliente> findAll() { // Método para obtener todos los clientes
        return clienteRepo.findAll();
    }

    public void updateCliente(Cliente cliente){
        clienteRepo.save(cliente);
    }

    public void deleteCliente(Integer id) {
        clienteRepo.deleteById(id); 
    }

    public boolean existsById(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }
}
