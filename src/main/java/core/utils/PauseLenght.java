package core.utils;

public enum PauseLenght {
    MAX(6),
    AVG(5),
    MIN(3);

    private Integer value;

    PauseLenght(Integer value){
        this.value = value;
    }
    public Integer value(){
        return this.value;
    }
}
