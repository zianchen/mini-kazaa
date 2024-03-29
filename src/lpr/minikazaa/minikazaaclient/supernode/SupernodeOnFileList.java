
package lpr.minikazaa.minikazaaclient.supernode;

import java.util.ArrayList;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lpr.minikazaa.bootstrap.NodeInfo;
import lpr.minikazaa.minikazaaclient.ordinarynode.OrdinarynodeFiles;
import lpr.minikazaa.util.MKFileDescriptor;

/**
 *
 * @author Andrea Di Grazia, Massimiliano Giovine
 * @date 14-ott-2008
 * @file SupernodeOnFileList.java
 */
public class SupernodeOnFileList extends Observable{
    private ArrayList <OrdinarynodeFiles> file_list;
    
   
    
    public SupernodeOnFileList(){
        this.file_list = new ArrayList();
    }

    
    public boolean alreadyHave(OrdinarynodeFiles f){
        
        for(OrdinarynodeFiles o : this.file_list){
            if(f.getOwner().getId().equals(o.getOwner().getId())){
                //Owner trovato, pronto nella lista.
                return true;
            }
        }
        
        return false;
    }
    
    public synchronized void addNewOnFileList(OrdinarynodeFiles new_file_list){
        
        
        for(OrdinarynodeFiles o : this.file_list){
            if(o.getOwner().getId().equals(new_file_list.getOwner().getId())){
                //pronta la lista per questo owner.
                o.resetList(new_file_list.getFileList());
                return;
            }
        }
        
        this.file_list.add(new_file_list);
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public synchronized ArrayList <OrdinarynodeFiles> searchFiles(String regex){
        ArrayList <OrdinarynodeFiles> l = new ArrayList();
        
        Pattern pattern = Pattern.compile(regex);
        for(OrdinarynodeFiles files : this.file_list){
            
            ArrayList <MKFileDescriptor> node_files = files.getFileList();
            OrdinarynodeFiles files_found = new OrdinarynodeFiles(files.getOwner());
            MKFileDescriptor [] new_array = null;
            
            for(MKFileDescriptor file : node_files){
                System.out.println("DEBUG: file analizzato "+file.getFileName());
                ArrayList <MKFileDescriptor> found_list = new ArrayList();
                
                
                    Matcher matcher = pattern.matcher(file.getFileName());
                    
                    while(matcher.find()){
                        found_list.add(file);
                        System.out.println("DEBUG: file trovato "+file.getFileName());
                    }
                
                
                 new_array = (MKFileDescriptor [])found_list.toArray();
            }
            files_found.addFiles(new_array);
        }
        
        return l;
    }
    
    public synchronized void removeFiles(NodeInfo n){
        int i = 0;
        for(OrdinarynodeFiles f : this.file_list){
            if(f.getOwner().equals(n))
            {
                this.file_list.remove(i);
                this.setChanged();
                this.notifyObservers();
                return;
            }
            i++;
        }       
    }
    
    
}
