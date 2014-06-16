package org.silpa.katapayadi;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sujith on 16/6/14.
 */
public class KatapayadiEditText extends EditText implements KatapayadiInterface {

    /**
     * Katapayadi object
     */
    private Katapayadi katapayadi;

    /**
     * Specified output field from layout
     */
    private int mOutputResourceId;

    /**
     * View specified from layout to output results
     */
    private View mOutputView;

    /**
     * For Katapayadi Number
     */
    private String mKatapayadiNumber;

    // Log tag
    private static final String LOG_TAG = "KatapayadiEditText";

    public KatapayadiEditText(Context context) {
        super(context);
        init(null, 0);
        initView();
    }

    public KatapayadiEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
        initView();
    }

    public KatapayadiEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
        initView();
    }

    /**
     * Initialize data members
     *
     * @param attrs    attribute set
     * @param defStyle default style
     */
    private void init(AttributeSet attrs, int defStyle) {

        this.katapayadi = new Katapayadi();
        initAttrs(attrs, defStyle);
    }

    /**
     * Initialize attributes used
     *
     * @param attrs    attribute set
     * @param defStyle default style
     */
    private void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.KatapayadiEditText,
                defStyle, defStyle
        );

        try {
            this.mOutputResourceId = a.getResourceId(
                    R.styleable.KatapayadiEditText_katapayadiOutputTo, -1);

        } catch (Exception e) {
            Log.e(LOG_TAG, "Error : " + e.getMessage());
        } finally {
            a.recycle();
        }
    }

    /**
     * Initialize view function
     */
    private void initView() {
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (mOutputView == null && mOutputResourceId != -1 &&
                        mOutputResourceId != getId()) {
                    mOutputView = getRootView().findViewById(mOutputResourceId);
                }
                if (mOutputView != null) {
                    if (getText().length() > 0) {
                        mKatapayadiNumber = katapayadi.getKatapayadiNumber(getText().toString());
                    } else {
                        mKatapayadiNumber = "";
                    }

                    if (mOutputView instanceof EditText) {
                        ((EditText) mOutputView).setText(mKatapayadiNumber);
                    } else if (mOutputView instanceof TextView) {
                        ((TextView) mOutputView).setText(mKatapayadiNumber);
                    }
                }
            }
        });
    }

    /**
     * Explicitly set output field
     *
     * @param resourceId resource id of output field
     */
    public void setOutputField(int resourceId) {
        this.mOutputResourceId = resourceId;
    }

    /**
     * This function is used to get katapayadi number
     *
     * @return number in string format
     */
    @Override
    public String getKatapayadiNumber() {
        return this.mKatapayadiNumber;
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
        return this.getModuleInformation();
    }
}
