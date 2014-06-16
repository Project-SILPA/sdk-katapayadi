package org.silpa.katapayadi;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sujith on 16/6/14.
 */
public class KatapayadiTextView extends TextView implements KatapayadiInterface {

    /**
     * Katapayadi object
     */
    private Katapayadi katapayadi;

    public KatapayadiTextView(Context context) {
        super(context);
        init();
    }

    public KatapayadiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KatapayadiTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.katapayadi = new Katapayadi();
    }

    /**
     * This function is used to get katapayadi number
     *
     * @return number in string format
     */
    @Override
    public String getKatapayadiNumber() {
        return this.katapayadi.getKatapayadiNumber(getText().toString());
    }

    /**
     * This function is used to get swarasthanas
     *
     * @return List of swarasthanas
     */
    @Override
    public List<String> getSwarasthanas() {
        return this.katapayadi.getSwarasthanas(getText().toString());
    }

    /**
     * This function gives name of the module
     *
     * @return name of module
     */
    @Override
    public String getModuleName() {
        return this.katapayadi.getModuleName();
    }

    /**
     * This function gives a brief description of the module
     *
     * @return brief information regarding the module
     */
    @Override
    public String getModuleInformation() {
        return this.katapayadi.getModuleInformation();
    }
}
