import java.util.ArrayList;

class JsonRanobe {
    ResultRanobe result;
}

class ResultRanobe {
    ArrayList<PartRanobe> parts = new ArrayList<>();
}

class PartRanobe {
    String url;
    boolean payment;
    boolean partDonate;
}