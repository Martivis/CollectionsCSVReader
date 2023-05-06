package org.collectionscsv;

public class DepartmentDTO {
    private static int firstFreeId = 0;

    public final int id;
    public String name;

    public DepartmentDTO()
    {
        id = firstFreeId++;
    }
}
