Usage
=====

### Note :
This module is still under development and this document presently shows only currently available utilities.

This module is dependent on Syllabifier module so please add project `https://github.com/Project-SILPA/sdk-syllabifier`
to the dependencies. 

#### Get Katapayadi Number
```
        Katapayadi obj = new Katapayadi();
        String num = obj.getNumber("ചണ്ഡാംശുചന്ദ്രാധമകുംഭിപാല");
```
The above function `obj.getNumber();` returns Katapayadi number in `String` format.

#### Get Swarasthanas
```
        Katapayadi obj = new Katapayadi();
        List<String> swarasthans = obj.getSwarasthanas("1");
```
The above function `obj.getSwarasthanas(String);` returns list of Swarasthanas. For eg: `"[Sa, Ri1, Ga1, Ma1, Pa, Da1, Ni1, Sa]"`

Argument can be number or raga in `String` format.
 
 ```
 "1"  -  Kanagangi
 "2"  -  Ratnangi
 "3"  -  Ganamoorti
 "4"  -  Vanaspati
 "5"  -  Manavati
 "6"  -  Tanaroopi
 "7"  -  Senavati
 "8"  -  Hanumatodi
 "9"  -  Dhenuka
 "10"  -  Natakapriya
 "11"  -  Kokilapriya
 "12"  -  Roopavati
 "13"  -  Gayakapriya
 "14"  -  Vakulabharanam
 "15"  -  Mayamalavagowla
 "16"  -  Chakravakam
 "17"  -  Sooryakantam
 "18"  -  Hatakambari 
 "19"  -  Jhankaradhwani
 "20"  -  Natabhairavi
 "21"  -  Keeravani
 "22"  -  Kharaharapriya
 "23"  -  Gourimanohari
 "24"  -  Varunapriya
 "25"  -  Mararanjani
 "26"  -  Charukesi
 "27"  -  Sarasangi
 "28"  -  Harikambhoji
 "29"  -  Dheerasankarabharanam
 "30"  -  Naganandini
 "31"  -  Yagapriya
 "32"  -  Ragavardhini
 "33"  -  Gangeyabhooshani
 "34"  -  Vagadheeswari
 "35"  -  Shoolini
 "36"  -  Chalanata
 "37"  -  Salagam
 "38"  -  Jalarnavam
 "39"  -  Jhalavarali
 "40"  -  Navaneetam
 "41"  -  Pavani
 "42"  -  Raghupriya
 "43"  -  Gavambhodi
 "44"  -  Bhavapriya
 "45"  -  Shubhapantuvarali
 "46"  -  Shadvidamargini
 "47"  -  Suvarnangi
 "48"  -  Divyamani
 "49"  -  Dhavalambari
 "50"  -  Namanarayani
 "51"  -  Kamavardani
 "52"  -  Ramapriya
 "53"  -  Gamanashrama
 "54"  -  Vishwambari
 "55"  -  Shamalangi
 "56"  -  Shanmukhapriya
 "57"  -  Simhendramadhyamam
 "58"  -  Hemavati
 "59"  -  Dharmavati
 "60"  -  Neetimati
 "61"  -  Kantamani
 "62"  -  Rishabhapriya
 "63"  -  Latangi
 "64"  -  Vachaspati
 "65"  -  Mechakalyani
 "66"  -  Chitrambari
 "67"  -  Sucharitra
 "68"  -  Jyotiswaroopini
 "69"  -  Dhatuvardani
 "70"  -  Nasikabhooshani
 "71"  -  Kosalam
 "72"  -  Rasikapriya
 ```

#### Get module name and information
```
        String moduleName = obj.getModuleName();
        String moduleInforamtion =  obj.getModuleInformation();
```

#### To run tests
Tests present at `/src/test/java/`

  - Select test to run
  - Right Click -> Run Test -> Run as Android Test

