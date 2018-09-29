package model.methodology;

public enum CobitSubType {
    PlanOrganise("Планирование и Организация"),
    AquireImplement("Проектирование и внедрение"),
    DeliverSupport("Эксплуатация и Сопровождение"),
    MonitorEvaluate("Мониторинг");

    private  String name;

    private CobitSubType(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    }
