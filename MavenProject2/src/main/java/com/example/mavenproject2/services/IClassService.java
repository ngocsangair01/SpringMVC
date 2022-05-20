package com.example.mavenproject2.services;

import com.example.mavenproject2.daos.Class;
import com.example.mavenproject2.dtos.ClassDTO;

import java.util.Set;

public interface IClassService {
    Class createClass(ClassDTO classDTO);
    Class editClass(Integer idClass, ClassDTO classDTO);
    void deleteClass(Integer idClass);
    Set<Class> getAllClass();
    Set<Class> getAllClassByAmount(Integer moreThan,Integer lessThan);
    Class getClassByMonitor(String monitor);
    Class getClassByName(String name);
    Class getById(Integer idClass);
}
