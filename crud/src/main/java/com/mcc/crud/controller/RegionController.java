/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.controller;

import com.mcc.crud.services.RegionService;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcc.crud.entities.Region;
import com.mcc.crud.repositories.RegionRepository;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Laila
 */
@Controller
public class RegionController {
    @Autowired
    RegionService regionService;
    RegionService regionService1;
    
@Autowired
    RegionRepository regionRepository;
    
    @GetMapping("")
public String index( Model model){
   model.addAttribute("region", new Region());
    model.addAttribute("regions", regionService.getAll());
   
    return "index";
}
@PostMapping("/save")
public String save(@Valid Region region){
    regionService.save(region);
    return "redirect:/";
    
    
}
@RequestMapping("/delete/{id}")
public String delete(@PathVariable int id){
    regionService.delete(id);
    return "redirect:/";
    
}
@RequestMapping("/getById/{id}")
public Optional<Region> getById(@Valid int id){
//    Optional<Region> region= regionRepository.findAllById(id);
//region.addAttribute("region", new Region()); 
return regionService.getById(id);
//     return "index";
//    if (region.isPresent()) {
//      return new ResponseEntity<>(region.get(), HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
  }

//@RequestMapping("/search")
//public String viewHomePage(Model model){
//String keyword="a";
//    List<Region> listRegions= regionService.listAll(keyword);
//    model.addAttribute("listRegions", listRegions);
////    model.addAttribute("keyword", keyword);
//    return "index";
//}

@GetMapping("/search")
public String search (Model model, @RequestParam String keyword){
        List<Region> regions = (List<Region>) regionRepository.search(keyword);
    model.addAttribute("regions", regions);
    return "showSearch";
}

}
