/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.services;

import com.mcc.crud.entities.Region;
import com.mcc.crud.repositories.RegionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laila
 */
@Service
public class RegionService implements IRegionService{
    
    @Autowired
    RegionRepository regionRepository;
    
    //read
 public List<Region> getAll(){
     return regionRepository.findAll();
 }
 //create/update
 public void save(Region region){
     regionRepository.save(region);
     
 }
 //delete
 public void delete (Integer id){
     regionRepository.delete(new Region(id));
 }
 public Optional<Region> getById(int id){
     return regionRepository.findById(id);
 }

    
    public Optional<Region> findById(int id) {
    return regionRepository.findById(id);
    }
public List<Region> listAll(String keyword){
    if(keyword !=null){
        return regionRepository.search(keyword);
    }
    return regionRepository.findAll();
}

    @Override
    public List<Region> search(String keyword) {
        List<Region> regions = (List<Region>) regionRepository.search(keyword);
        return regions;
  
    }
   
}
