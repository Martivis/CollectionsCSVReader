package org.collectionscsv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentProviderTest {
    @Test
    public void getDepartmentDTO_newId() {
        // arrange
        var provider = new DepartmentProvider();
        var name = "A";
        var expected = new DepartmentDTO();
        expected.id = 0;
        expected.name = name;

        // act
        var actual = provider.getDepartmentDTO(name);

        // assert
        assertEquals(expected.id, actual.id);
        assertEquals(expected.name, actual.name);
    }

    @Test
    public void getDepartmentDTO_existingId() {
        // arrange
        var provider = new DepartmentProvider();
        var name = "A";
        var expected = new DepartmentDTO();
        expected.id = 0;
        expected.name = name;

        // act
        provider.getDepartmentDTO(name);
        var actual = provider.getDepartmentDTO(name);

        // assert
        assertEquals(expected.id, actual.id);
        assertEquals(expected.name, actual.name);
    }

    @Test
    public void getDepartmentDTO_newIdNotFirst() {
        // arrange
        var provider = new DepartmentProvider();
        var name1 = "A";
        var name2 = "B";
        var expected = new DepartmentDTO();
        expected.id = 1;
        expected.name = name2;

        // act
        provider.getDepartmentDTO(name1);
        var actual = provider.getDepartmentDTO(name2);

        // assert
        assertEquals(expected.id, actual.id);
        assertEquals(expected.name, actual.name);
    }

    @Test
    public void getDepartmentDTO_existingIdNotFirst() {
        // arrange
        var provider = new DepartmentProvider();
        var name1 = "A";
        var name2 = "B";
        var expected = new DepartmentDTO();
        expected.id = 0;
        expected.name = name1;

        // act
        provider.getDepartmentDTO(name1);
        provider.getDepartmentDTO(name2);
        var actual = provider.getDepartmentDTO(name1);

        // assert
        assertEquals(expected.id, actual.id);
        assertEquals(expected.name, actual.name);
    }
}