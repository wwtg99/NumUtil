/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numutil;

/**
 *
 * @author wwt
 */
public class Bitmask {
    public static final int ALLOW_SELECT = 1 << 0;  //0001
    public static final int ALLOW_INSERT = 1 << 1;  //0010
    public static final int ALLOW_UPDATE = 1 << 2;  //0100
    public static final int ALLOW_DELETE = 1 << 3;  //1000
    
    private int flag;
    
    public void setPermission(int pm){
        this.flag = pm;
    }
    
    public void enable(int pm){
        flag |= pm;
    }
    
    public void disable(int pm){
        flag &= ~pm;
    }
    
    public boolean isAllowed(int pm){
        return (flag & pm) == pm;
    }
    
    public boolean isNotAllowed(int pm){
        return (flag & pm) == 0;
    }
    
    public boolean isOnlyAllowed(int pm){
        return flag == pm;
    }
}
