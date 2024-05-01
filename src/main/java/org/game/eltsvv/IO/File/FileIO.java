package org.game.eltsvv.IO.File;

import java.io.*;

public class FileIO implements IFileIO{

    @Override
    public void writeFile(String item) {
        try(FileOutputStream fos=new FileOutputStream("notes.txt"))
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

        try(FileInputStream fin=new FileInputStream("notes.txt"))
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
