package org.example.webservicesoapwithspringboot.ws;


import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.example.webservicesoapwithspringboot.entities.Compte;
import org.example.webservicesoapwithspringboot.entities.TypeCompte;
import org.example.webservicesoapwithspringboot.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
@WebService(serviceName = "BanqueWS")
public class CompteSoapService {
    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> getComptes(){
        return compteRepository.findAll();
    }

    @WebMethod
    public Compte getCompteByID(@WebParam(name="id") Long id){
        return compteRepository.findById(id).orElse(null);
    }

    @WebMethod
    public Compte createCompte(@WebParam(name="solde") double solde, @WebParam(name="type") TypeCompte type){
        Compte compte = new Compte(null,solde,new Date(),type);
        return compteRepository.save(compte);
    }

    @WebMethod
    public boolean deleteCompte(@WebParam(name="id") Long id){
        if(compteRepository.existsById(id)){
            compteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
