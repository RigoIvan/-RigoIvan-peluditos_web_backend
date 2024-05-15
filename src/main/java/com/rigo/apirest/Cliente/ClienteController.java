package com.rigo.apirest.Cliente;

import java.util.List; // Importa la clase List correcta
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/peluditos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/create")
    public void createCliente(@RequestBody Cliente cliente){
        clienteService.createCliente(cliente);
    }

    @GetMapping("/all")
    public List<Cliente> obtenerClientes() { // Corrige la sintaxis aquí
        return clienteService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getPersonById(@PathVariable Integer id) {
        Optional<Cliente> optionalPerson = clienteService.findClienteById(id);
        if (optionalPerson.isPresent()) {
            return ResponseEntity.ok(optionalPerson.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        clienteService.updateCliente(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Integer id) {
        clienteService.deleteCliente(id); 
        return ResponseEntity.noContent().build(); 
    }
}
