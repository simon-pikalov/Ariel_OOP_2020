//ackage class1;//package week1
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

/**
 * This class represents a simple file based logger.
 * The main use is to simplify the use of text-files and keep it simple.
 * Note: the default log file name is auto-ganerated by _FileLogger_+time(ms).txt
 */

public class FileLogger {
    public static final String  START_NAME = "FileLogger_";
    private String _file_name;
    private FileWriter _file;

    public FileLogger() {
        this(START_NAME+new Date().getTime()+".txt");
    }
    public FileLogger(String file) {
        File f = new File(file);
        if(!f.exists()) {
            String _file_name = file;
            try {
                _file = new FileWriter(file);
            }
            catch(Exception e){ e.printStackTrace();}
        }
        else {
            throw new RuntimeException("class1.FileLogger should not rewrite on existing file. Do choose a new log file name");
        }

    }
    public void log(String s) {
        try {
            _file.write(s+"\n");
            _file.flush();
        }
        catch(Exception e){ e.printStackTrace();}
    }
    public void flush() {
        try {
            _file.flush();
        }
        catch(Exception e){ e.printStackTrace();}
    }
    public void close() {
        try {
            _file.close();
        }
        catch(Exception e){ e.printStackTrace();}
    }
}
