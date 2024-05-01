package org.game.eltsvv.IO.File;

public class FileIOService {
    IFileIO fileIOService;
    public FileIOService(IFileIO _fileIOService) {
        fileIOService = _fileIOService;
    }
    public void writeToFile(String item) {
        fileIOService.writeFile(item);
    }
    public  String readFile() {
        return fileIOService.readFile();
    }
}
