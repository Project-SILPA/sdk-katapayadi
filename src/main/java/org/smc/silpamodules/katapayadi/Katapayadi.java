package org.smc.silpamodules.katapayadi;

import org.smc.silpamodules.syllabifier.LanguageDetect;
import org.smc.silpamodules.syllabifier.Syllabifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sujith on 31/5/14.
 */
public class Katapayadi {

    /**
     * private map for language bases
     */
    private static final Map<Integer, Integer> languageBases = new HashMap<Integer, Integer>();

    static {
        languageBases.put(LanguageDetect.HINDI, 0x0915);
        languageBases.put(LanguageDetect.BENGALI, 0x0995);
        languageBases.put(LanguageDetect.PUNJABI, 0x0A15);
        languageBases.put(LanguageDetect.GUJARATI, 0x0A95);
        languageBases.put(LanguageDetect.ORIYA, 0x0B15);
        languageBases.put(LanguageDetect.TAMIL, 0x0B95);
        languageBases.put(LanguageDetect.TELUGU, 0x0C15);
        languageBases.put(LanguageDetect.KANNADA, 0x0C95);
        languageBases.put(LanguageDetect.MALAYALAM, 0x0D15);
    }

    public static final String KATAPAYADI_MODULE_NAME = "Katapayadi";
    public static final String KATAPAYADI_MODULE_INFORMATION = "Decodes the numbers from the " +
            "katapayadi numbering system";

    private static final String LOG_TAG = Katapayadi.KATAPAYADI_MODULE_NAME;

    /**
     * This function is used to get katapayadi number
     *
     * @param word text
     * @return number in string format
     */
    public String getNumber(String word) {
        word = word.trim();
        Syllabifier syllabifier = new Syllabifier();
        List<String> syllables = syllabifier.getSyllables(word);
        String number = "";
        int base;

        try {
            int srcLangCode = LanguageDetect.detectLanguage(word).get(word);
            base = languageBases.get(srcLangCode);
        } catch (Exception e) {
            return "Unsupported Language";
        }
        for (String str : syllables) {
            number = getNumberForSyllable(str, base) + number;
        }
        return number;
    }

    /**
     * This function is used to get number for a syllable
     *
     * @param syllable syllable
     * @param base     language base - unicode
     * @return number as a string
     */
    private String getNumberForSyllable(String syllable, int base) {
        List<Integer> katapayadi = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6,
                7, 8, 9, 0, 0, 1, 2, 3, 4, 5, 1, 2, 0, 3, 9, 0, 4, 5, 6, 7, 8);
        int length = syllable.length();
        int index = length - 1;

        while (index >= 0) {
            char chr = syllable.charAt(index);
            int offset = chr - base;

            if (offset >= 0) {
                try {
                    return String.valueOf(katapayadi.get(offset));
                } catch (Exception e) {

                }
            }
            index -= 1;
        }
        return "0";
    }

    /**
     * This function is used to get swarasthanas
     *
     * @param raga number
     * @return List of swarasthanas
     */
    public List<String> getSwarasthanas(String raga) {
        List<String> swarasthans = new ArrayList<String>();
        swarasthans.add("Sa");

        long number;

        try {
            number = Long.parseLong(raga);
        } catch (Exception e) {
            number = Long.parseLong(getNumber(raga));
        }
        long melakarthaNumber = number % 100;
        long quotient = (melakarthaNumber - 1) / 6;
        long remainder = (melakarthaNumber - 1) % 6;
        quotient = quotient % 6;

        if (quotient == 0) {
            swarasthans.add("Ri1");
            swarasthans.add("Ga1");
        }
        if (quotient == 1) {
            swarasthans.add("Ri1");
            swarasthans.add("Ga2");
        }
        if (quotient == 2) {
            swarasthans.add("Ri1");
            swarasthans.add("Ga3");
        }
        if (quotient == 3) {
            swarasthans.add("Ri2");
            swarasthans.add("Ga2");
        }
        if (quotient == 4) {
            swarasthans.add("Ri2");
            swarasthans.add("Ga3");
        }
        if (quotient == 5) {
            swarasthans.add("Ri3");
            swarasthans.add("Ga3");
        }

        if (melakarthaNumber <= 36) {
            swarasthans.add("Ma1");
        }
        if (melakarthaNumber > 36 && melakarthaNumber <= 72) {
            swarasthans.add("Ma2");
        }
        swarasthans.add("Pa");

        if (remainder == 0) {
            swarasthans.add("Da1");
            swarasthans.add("Ni1");
        }
        if (remainder == 1) {
            swarasthans.add("Da1");
            swarasthans.add("Ni2");
        }
        if (remainder == 2) {
            swarasthans.add("Da1");
            swarasthans.add("Ni3");
        }
        if (remainder == 3) {
            swarasthans.add("Da2");
            swarasthans.add("Ni2");
        }
        if (remainder == 4) {
            swarasthans.add("Da2");
            swarasthans.add("Ni3");
        }
        if (remainder == 5) {
            swarasthans.add("Da3");
            swarasthans.add("Ni3");
        }
        swarasthans.add("Sa");
        return swarasthans;
    }

    /**
     * This function gives name of the module
     *
     * @return name of module
     */
    public String getModuleName() {
        return Katapayadi.KATAPAYADI_MODULE_NAME;
    }

    /**
     * This function gives a brief description of the module
     *
     * @return brief information regarding the module
     */
    public String getModuleInformation() {
        return Katapayadi.KATAPAYADI_MODULE_INFORMATION;
    }

}
