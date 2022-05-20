package com.example.mavenproject2.services.serviceimp;

import com.example.mavenproject2.daos.Class;
import com.example.mavenproject2.dtos.ClassDTO;
import com.example.mavenproject2.repositories.ClassRepository;
import com.example.mavenproject2.services.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ClassServiceImp implements IClassService {

    @Autowired
    private ClassRepository classRepository;
    @Override
    public Class createClass(ClassDTO classDTO) {
        Class aClass = new Class(classDTO.getId(),classDTO.getName(),classDTO.getAmount(),classDTO.getMonitor());
        return classRepository.save(aClass);
    }

    @Override
    public Class editClass(Integer idClass, ClassDTO classDTO) {
        Optional<Class> aClass = classRepository.findById(idClass);
        aClass.get().setId(idClass);
        aClass.get().setName(classDTO.getName());
        aClass.get().setAmount(classDTO.getAmount());
        aClass.get().setMonitor(classDTO.getMonitor());
        return classRepository.save(aClass.get());
    }

    @Override
    public void deleteClass(Integer idClass) {
        classRepository.deleteById(idClass);
    }

    @Override
    public Set<Class> getAllClass() {
        Set<Class> classes = new HashSet<>(classRepository.findAll());
        return classes;

    }

    @Override
    public Set<Class> getAllClassByAmount(Integer moreThan, Integer lessThan) {
        Set<Class> classes = classRepository.findAllByAmountGreaterThanAndAmountLessThan(moreThan, lessThan);
        return classes;
    }

    @Override
    public Class getClassByMonitor(String monitor) {
        Class aClass = classRepository.findByMonitor(monitor);
        return aClass;
    }

    @Override
    public Class getClassByName(String name) {
        Class aClass = classRepository.findByName(name);
        return aClass;
    }

    @Override
    public Class getById(Integer idClass) {
        Optional<Class> aClass = classRepository.findById(idClass);
        return aClass.get();
    }
}
