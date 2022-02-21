/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.silverolympics.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.silverolympics.bean.UserAccount;

/**
 * Datastructure 
 * @author Manon
 */
public class AllUserData {
    public HashMap<String,Integer> mapusers; 
    
    
    public AllUserData(){
        HashMap<String,Integer> mapusers = new HashMap<String,Integer>();
        //Adding fake "already created" accounts
        mapusers.put("Tournesols",5);
        mapusers.put("Tulipes",2);
        
        this.mapusers = mapusers;
    }
    public HashMap<String,Integer> getMapUsers(){
        Map<String,Integer> sortedmap = this.mapusers.entrySet().stream()
        .sorted(Comparator.comparingInt(e -> -e.getValue()))
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (a, b) -> { throw new AssertionError(); },
                LinkedHashMap::new
        ));
        return (HashMap<String, Integer>) sortedmap;
    }
    
}
