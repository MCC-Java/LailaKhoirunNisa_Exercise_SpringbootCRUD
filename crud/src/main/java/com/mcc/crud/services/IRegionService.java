/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.services;

import com.mcc.crud.entities.Region;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Laila
 */
public interface IRegionService {
    List<Region> search(String keyword);
    Optional<Region>findById(int id);
//    public List<Region> FindAll(){
//        RegionRepository.findAll();
//    }

    public List<Region> getAll();

    public void save(Region region);


//    public Optional<Region> findById(long id2);
}
