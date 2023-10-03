package com.cbfacademy.FileHandler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.cbfacademy.Employee.Employee;
import com.google.gson.GsonBuilder;

@DisplayName(value = "JSON File Exercise")
public class JSONFileHandlerTest {
    @TempDir
    Path tempDir;

    Path tempFile;
    Employee employee = new Employee(1, "test", "name", Arrays.asList("Tester"));

    @BeforeEach
    public void setUp() {
        try {
            tempFile = Files.createFile(tempDir.resolve("temp.json"));
            Files.writeString(tempFile, "[" + new GsonBuilder().setPrettyPrinting().create().toJson(employee) + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName(value = "readFile() returns file contents")
    @Test
    public void readFile_ReturnsFileContent() throws IOException, FilenameException {
        List<Employee> result = JSONFileHandler.readFile(tempFile.toString());

        assertTrue(result.size() > 0);
    }

    @DisplayName(value = "readFile() throws FilenameException when file is not a .json file")
    @Test
    public void readFile_ThrowsFilenameExceptionWhenFileIsNotJsonFile() {
        assertThrows(FilenameException.class, () -> JSONFileHandler.readFile("not_json_file.java"));
    }

    @DisplayName(value = "save() creates new file when file does not yet exist")
    @Test
    public void save_createsNewFileWhenFileDoesNotYetExist() throws FilenameException, IOException {
        String filePathString = "src/test/resources/new.json";
        Path path = Paths.get(filePathString);

        JSONFileHandler.save(employee, filePathString);

        assertTrue(Files.exists(path));
        Files.delete(path);
    }

    @DisplayName(value = "save() adds data to existing file")
    @Test
    public void save_addsDataToExistingFile() throws FilenameException, IOException {
        JSONFileHandler.save(employee, tempFile.toString());

        assertTrue(Files.exists(Paths.get(tempFile.toUri())));
    }
}
