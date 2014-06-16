package org.silpa.katapayadi;

import java.util.List;

/**
 * Created by sujith on 16/6/14.
 */
public interface KatapayadiInterface {

    /**
     * This function is used to get katapayadi number
     *
     * @return number in string format
     */
    public String getKatapayadiNumber();

    /**
     * This function is used to get swarasthanas
     *
     * @return List of swarasthanas
     */
    public List<String> getSwarasthanas();

    /**
     * This function gives name of the module
     *
     * @return name of module
     */
    public String getModuleName();

    /**
     * This function gives a brief description of the module
     *
     * @return brief information regarding the module
     */
    public String getModuleInformation();
}
