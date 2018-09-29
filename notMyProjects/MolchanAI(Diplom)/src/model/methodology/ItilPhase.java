package model.methodology;

public enum ItilPhase {
    SupportService("Поддержка сервисов"),
    ProvideService("Предоставление сервисов");

    private String name;

    private ItilPhase(String name) {
        this.name = name;
    }

    public String getName() {return name;}
}
