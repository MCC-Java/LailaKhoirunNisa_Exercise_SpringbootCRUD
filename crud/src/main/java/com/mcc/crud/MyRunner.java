/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud;




import com.mcc.crud.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.mcc.crud.services.IRegionService;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Laila
 */
@Component
public class MyRunner implements CommandLineRunner{
  
    @Autowired
    private IRegionService regionService;
    @Override
    public  void run(String... args) throws Exception{
        
//        regionService.save(new Region (6,"Ausi"));
                int id1 = 6;
//        var id=1L;
       
//       regionService.findById(id1).ifPresent(System.out::println);
//        System.out.println(val.get());
        
        int id2=1;
        Optional<Region> val2 = regionService.findById(id2);
        if(val2.isPresent()){
            System.out.println(val2.get());
        }    else{
                    System.out.printf("No Region found with id %d%n" , id2);
                    }
List<Region> regions=regionService.getAll();
regions.forEach(region->System.out.println(region.toString()));
    }
}
