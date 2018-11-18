import java.util.ArrayList;

class JsonMain {
    Result result = new Result();
}

class Result {
    ArrayList<PartMain> books = new ArrayList<>();
}

class PartMain {
    String url;
    String title;
}
