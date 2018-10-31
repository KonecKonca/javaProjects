package model.methodology;

public enum ItilSubType {
    SupportService("Поддержка сервисов"),
    ProvideService("Предоставление сервисов");

    private String name;

    private ItilSubType(String name) {
        this.name = name;
    }

    public String getName() {return name;}
}
