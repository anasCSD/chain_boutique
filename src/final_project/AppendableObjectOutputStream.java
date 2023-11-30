
package final_project;

import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class AppendableObjectOutputStream extends ObjectOutputStream {
    
    
    
    public AppendableObjectOutputStream(OutputStream out) throws Exception{
        super(out);
    }
    
    @Override
    public void writeStreamHeader(){
        ///....
    }
}
    

