package com.example.medical_project.Controller;

import com.example.medical_project.Entity.Specialization;
import com.example.medical_project.Service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specializations")
@RequiredArgsConstructor
public class SpecializationController {
    private final SpecializationService specializationService;

    @PostMapping
    public Specialization createSpecialization(@RequestBody Specialization specialization) {
        return specializationService.createSpecialization(specialization);
    }

    @GetMapping("/{id}")
    public Specialization getSpecializationById(@PathVariable Long id) {
        return specializationService.getSpecializationById(id);
    }

    @GetMapping
    public List<Specialization> getAllSpecializations() {
        return specializationService.getAllSpecializations();
    }

    @PutMapping("/{id}")
    public Specialization updateSpecialization(@PathVariable Long id,
                                               @RequestBody Specialization specialization) {
        return specializationService.updateSpecialization(id, specialization);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialization(@PathVariable Long id) {
        specializationService.deleteSpecialization(id);
    }
}
