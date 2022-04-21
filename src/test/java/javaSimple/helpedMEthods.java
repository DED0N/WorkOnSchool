package javaSimple;

public class helpedMEthods {

    final static String arg = "qwe";

    public int ind = 2;

    public static String name(String word, int value) {
        String nameForReturn = word;

        return nameForReturn;
    }

    private String prefix(String pref) {
        return pref;
    }

    protected String sufix(String suf) {
        return suf;
    }

    String lost() {
        return "lost";
    }

    static int sum(int a, int b) {
        return a + b;
    }

    public String switchRadio(String radioName) {
        String radio;
        switch (radioName) {
            case "Afro":
                radio = "105.5";
                break;

            case "Auto":
                radio = "101.5";
                break;

            default:
                radio = "Ты кто такой?";
                break;
        }

        return radio;
    }
}

/*    Новая версия свитча, для идеи 14

    public String newSwitchRadio(String newRadioName)
    {
        String radio;

        radio = switch(newRadioName){
            case "Afro" -> "105.5";
            case "Auto" -> "101.5";
            default -> "Ты кто такой?";
        };
        return radio;
    }
}*/
