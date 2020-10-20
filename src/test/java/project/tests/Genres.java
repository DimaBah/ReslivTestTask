package project.tests;

public enum Genres {
    COMEDY("Комедия"),
    ACTION("Боевик"),
    DETECTIVE("Детектив"),
    FANTASTIC("Фантастика");

    private String value;

    Genres(String value){
        this.value = value;
    }
    public String value(){
        return this.value;
    }

}
