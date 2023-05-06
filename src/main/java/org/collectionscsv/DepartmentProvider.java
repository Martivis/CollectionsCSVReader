package org.collectionscsv;

import java.util.Dictionary;
import java.util.Hashtable;

public class DepartmentProvider {
    private Dictionary<String, DepartmentDTO> departments = new Hashtable();
    private int freeId;
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
