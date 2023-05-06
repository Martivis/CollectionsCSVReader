package org.collectionscsv;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ListLoader {
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.mm.yyyy");

    public List<EmployeeDTO> ReadFromFile(String filename)
            throws IOException, ParseException {
        var list = new ArrayList<EmployeeDTO>();
        var separator = ';';

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(filename);
            CSVReader reader = in == null ? null : new CSVReader(new InputStreamReader(in), separator)) {
            if (reader == null) {
                throw new FileNotFoundException(filename);
            }

            read(list, reader);
        }
        return list;
    }

    private void read(ArrayList<EmployeeDTO> list, CSVReader reader) throws IOException, ParseException {
        String[] nextLine = reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            list.add(parseEmployeeDTO(nextLine));
        }
    }

    private EmployeeDTO parseEmployeeDTO(String[] line) throws ParseException {
        var dto = new EmployeeDTO();
        dto.id = Integer.parseInt(line[0]);
        dto.name = line[1];
        dto.gender = parseGender(line[2]);
        dto.birthDate = parseDate(line[3]);
        dto.department = parseDepartmentDTO(line[4]);
        dto.salary = Integer.parseInt(line[5]);
        return dto;
    }

    private Gender parseGender(String string) {
        return Objects.equals(string, Gender.Female.toString()) ? Gender.Female : Gender.Male;
    }

    private Date parseDate(String string) throws ParseException {
        return dateFormatter.parse(string);
    }

    private DepartmentDTO parseDepartmentDTO(String string) {
        var department = new DepartmentDTO();
        department.name = string;
        return department;
    }

}
