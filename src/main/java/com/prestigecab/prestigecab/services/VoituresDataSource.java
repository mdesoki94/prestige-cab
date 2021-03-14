package com.prestigecab.prestigecab.services;

import com.google.common.collect.Lists;
import com.prestigecab.prestigecab.Model.Type;
import com.prestigecab.prestigecab.Model.Vehicules;
import com.prestigecab.prestigecab.dao.TypeRepository;
import com.prestigecab.prestigecab.dao.VehiculesRepository;
import com.prestigecab.prestigecab.formdata.VehiculesFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;


@Service
public class VoituresDataSource {
com.prestigecab.prestigecab.dao.VehiculesRepository VehiculesRepository;
TypeRepository typeRepository;


@Autowired
public VoituresDataSource(com.prestigecab.prestigecab.dao.VehiculesRepository vehiculesRepository,TypeRepository typeRepository ){

    this.VehiculesRepository =vehiculesRepository;
    this.typeRepository=typeRepository;
}

public List <Vehicules> getVehicules(){return Lists.newArrayList(VehiculesRepository.findAll());}

public Vehicules getVehicule(Long id){
    return VehiculesRepository.findById(id).orElse(new Vehicules());
}

public void deleteVehicule(long id){ VehiculesRepository.deleteById(id);}

public void saveVehicule(VehiculesFormDTO vehiculesDTO){
    Vehicules vehiculesDB = VehiculesRepository.findById(vehiculesDTO.getId()).orElse(new Vehicules());
    vehiculesDB.setNom(vehiculesDTO.getNom());
    vehiculesDB.setDescription(vehiculesDTO.getDescription());
    vehiculesDB.setPrix(vehiculesDTO.getPrix());
    vehiculesDB.setImage1(vehiculesDTO.getImage1());
    vehiculesDB.setImage2(vehiculesDTO.getImage2());
    vehiculesDB.setImage3(vehiculesDTO.getImage3());

    VehiculesRepository.save(vehiculesDB);
}
    public List<Type> getTypes(){
        return Lists.newArrayList(typeRepository.findAll());
    }
    public Type getType(Long id){
        return typeRepository.findById(id).orElse(new Type());
    }

}
