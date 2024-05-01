package org.game.eltsvv.IO.File;

import java.io.*;

public class FileIO implements IFileIO{
    private String fileName;

    public FileIO(String _fileName) {
        fileName = _fileName;
    }

    @Override
    public void writeFile(String item) {
        try(FileOutputStream fos=new FileOutputStream(fileName))
        {
            // перевод строки в байты
            byte[] buffer = item.getBytes();
            fos.write(buffer, 0, buffer.length);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

    @Override
    public String readFile() {
        String str = "";
        StringWriter writer = new StringWriter();

        try(FileInputStream fin=new FileInputStream(fileName))
        {
            int i;
            while((i=fin.read())!=-1) {
                writer.append((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return writer.toString();
    }
}
