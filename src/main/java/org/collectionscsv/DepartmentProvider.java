package org.collectionscsv;

import java.util.Dictionary;
import java.util.Hashtable;

public class DepartmentProvider {
    private static Dictionary<String, Integer> departments = new Hashtable();
    private static int freeId;
    public static synchronized DepartmentDTO getDepartmentDTO(String name) {
        var dto = new DepartmentDTO();
        var id = departments.get("name");
        if (id != null) {
            dto.id = id;
        }
        else {
            departments.put(name, freeId);
            dto.id = freeId++;
        }
        dto.name = name;
        return dto;
    }
}
