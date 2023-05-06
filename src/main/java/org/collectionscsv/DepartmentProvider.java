package org.collectionscsv;

import java.util.Dictionary;
import java.util.Hashtable;

public class DepartmentProvider {
    private Dictionary<String, DepartmentDTO> departments = new Hashtable();
    private int freeId;

    /**
     * Get Department DTO with generated id unique for each name.
     * DTO name field will contain String, passed as a parameter.
     *
     * IMPORTANT!
     * Second and each next call with same name will return the same object.
     * It means that if name was changed in first time returned object,
     * this changes will affect DTOs returned from future calls of this method.
     * It helps the system to keep data consistent.
     *
     * @param name Name of target department
     * @return DTO with specified name and generated id.
     */
    public synchronized DepartmentDTO getDepartmentDTO(String name) {
        var dto = departments.get(name);
        if (dto == null) {
            dto = new DepartmentDTO();
            dto.id = freeId++;
            dto.name = name;
            departments.put(name, dto);
        }
        return dto;
    }
}
